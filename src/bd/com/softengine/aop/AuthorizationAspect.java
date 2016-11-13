package bd.com.softengine.aop;

import bd.com.softengine.admin.model.Customer;
import bd.com.softengine.admin.model.Staff;
import bd.com.softengine.constant.SecurityConstants;
import bd.com.softengine.enam.Applications;
import bd.com.softengine.licencing.SELicence;
import bd.com.softengine.security.SessionUtil;
import bd.com.softengine.security.model.Attempt;
import bd.com.softengine.security.model.Module;
import bd.com.softengine.security.model.Operation;
import bd.com.softengine.security.model.User;
import bd.com.softengine.security.service.AuthenticationAndAuthorizationService;
import bd.com.softengine.security.service.SecurityService;
import bd.com.softengine.util.ActionResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Aspect
public class AuthorizationAspect {
    @Autowired
    private SecurityService securityService;

    /*@Around("execution(* *(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = point.proceed();
        String name = MethodSignature.class.cast(point.getSignature()).getMethod().getName();
        System.out.println("name = " + name);
        System.out.println("point.getArgs() = " + point.getArgs());
        System.out.println("result = " + result);
        return result;
    }*/

    @Autowired
    private AuthenticationAndAuthorizationService authorizationService;

    private User sessionUser = null;

    private List<Operation> grantedOperations = null;
    private boolean isAllowed = false;
    String moduleName = null;
    String operationName = null;
    String requestMapping = null;

    @Pointcut("within(@org.springframework.stereotype.Controller *) " +
            "&& !within(@org.springframework.stereotype.Controller bd.com.softengine.security.AuthenticationController)" +
            "&& !within(@org.springframework.stereotype.Controller bd.com.softengine.HomeController)")
    public void allControllers() {
    }

    @Pointcut("execution(* *(..))")
    public void allOperations() {
    }


    @Around("allControllers() && allOperations()")
    public Object proceedToAction(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
        sessionUser = SessionUtil.getSessionUser();
        grantedOperations = SessionUtil.getSessionUserFeatures();
        int annotationIndex = 0;
        Annotation[] annotations = proceedJoinPoint.getTarget().getClass().getAnnotations();
        int annotationLength = annotations.length;
        for (int i = 0; i < annotationLength; i++) {
            if (annotations[i].toString().contains(SecurityConstants.REQUEST_MAPPING)) {
                annotationIndex = i;
                break;
            }
        }

        requestMapping = annotations[annotationIndex].toString();
        //moduleName = requestMapping.split(",")[2].split("/")[1];
        operationName = proceedJoinPoint.getSignature().getName();
        isAllowed = authorizationService.checkAuthorization(operationName);
        //isAllowed = authorizationService.checkAuthorization(grantedOperations, operationName);
        // isAllowed = authorizationService.checkAuthorization(grantedOperations, moduleName, operationName);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PageTitle", "Sorry");
        ActionResult go = SELicence.checkLicenceValidity(Applications.eSHOP);
        if (go.isSuccess()) {
            if (isAllowed) {
                return proceedJoinPoint.proceed();
            } else {
                ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpServletRequest request = attr.getRequest();
                String referer = request.getHeader(SecurityConstants.REFERER);
//                String refModuleName = referer.split("/")[4];
//                String refOperationName = referer.split("/")[5].split("\\.")[0];
                Module module2 = securityService.getModuleByName(moduleName);
                Operation operation2 = securityService.findOperationByName(operationName);
                Attempt attempt = new Attempt();
                attempt.setAttemptType(1);
                attempt.setModule(module2);
                attempt.setOperation(operation2);
                attempt.setTime(new Date());
                attempt.setOperator(sessionUser);
                attempt.setOperationName(operationName);
                attempt.setReferer(referer);
                securityService.save(attempt);
                map.put("message", "You have no permission to execute this operation.");
                if (sessionUser instanceof Customer) {
                    return new ModelAndView("cust_template/pages/no_permission", map);
                }else if (sessionUser instanceof Staff) {
                    return new ModelAndView("home/no_permission", map);
                }else {
                    return new ModelAndView("redirect:/auth/logout.se");
                }

            }
        } else {
            return new ModelAndView("home/licence_missing", map);
        }
    }


}
