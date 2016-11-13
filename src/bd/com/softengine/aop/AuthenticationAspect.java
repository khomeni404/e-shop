package bd.com.softengine.aop;

import bd.com.softengine.admin.model.Customer;
import bd.com.softengine.admin.model.Staff;
import bd.com.softengine.security.model.User;
import bd.com.softengine.constant.SecurityConstants;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.servlet.ModelAndView;

import bd.com.softengine.security.SessionUtil;

@Aspect
public class AuthenticationAspect {

	@Pointcut("within(@org.springframework.stereotype.Controller *) " +
			"&& !within(@org.springframework.stereotype.Controller bd.com.softengine.security.AuthenticationController) ")
	public void allControllers(){}

	@Pointcut("execution(* *(..))")
    public void methodPointcut() {}

	@Around("allControllers() && methodPointcut()")
	public Object proceedToAction(ProceedingJoinPoint joinPoint) throws Throwable {
        Object sessionUserInstance = SessionUtil.getSession().getAttribute(SecurityConstants.SESSION_USER);
        if (sessionUserInstance instanceof Staff || sessionUserInstance instanceof Customer){
            return joinPoint.proceed();
        }else{
            return new ModelAndView("redirect:/");
        }
    }

}
