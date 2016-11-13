package bd.com.softengine.admin;

import bd.com.softengine.ServiceFactory;
import bd.com.softengine.admin.model.Customer;
import bd.com.softengine.admin.model.ItemReport;
import bd.com.softengine.admin.model.Manufacturer;
import bd.com.softengine.admin.model.Staff;
import bd.com.softengine.security.SessionUtil;
import bd.com.softengine.security.model.User;
import bd.com.softengine.security.service.UserDetailsService;
import bd.com.softengine.shop.model.Item;
import bd.com.softengine.util.ShopDictionary;
import bd.com.softengine.util.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 21/12/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 21/12/15
 * Version : 1.0
 */

@Controller
@RequestMapping("/admin/")
public class AdminController  extends ServiceFactory implements Text {

    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping(method = RequestMethod.GET, value = "/createCustomer.se")
    public ModelAndView createCustomer() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Customer Create");
        map.put("customerList", adminService.findAllCustomer());

       //r.getSession().getClass().getSimpleName();

        return new ModelAndView("admin/customer_create", map);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/saveCustomer.se")
    public ModelAndView saveCustomer(@RequestParam String name,
                                     @RequestParam String cellPhone,
                                     @RequestParam String altPhone,
                                     @RequestParam String emailAddress,
                                     @RequestParam String mailingAddress,
                                     @RequestParam String nid,
                                     @RequestParam String tin,
                                     @RequestParam String keyName,
                                     @RequestParam Integer custType,
                                     @RequestParam String businessAddress
                                     ) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Customer Create");
        
        boolean saved = adminService.saveCustomer(
                 name,
                 cellPhone,
                 altPhone,
                 emailAddress,
                 mailingAddress,
                 nid,
                 tin,
                 keyName,
                 custType,
                 businessAddress
        );

        if (saved) {
            map.put(ERROR_KEY, "Saved Successfully");
            return new ModelAndView(REDIRECT_SUCCESS, map);
        } else {
            map.put(ERROR_KEY, "Saving failed !");
            return new ModelAndView(REDIRECT_ERROR, map);
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/createStaff.se")
    public ModelAndView createStaff() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Customer Create");
        map.put("customerList", adminService.findAllCustomer());

        return new ModelAndView("admin/staff_create", map);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/saveStaff.se")
    public ModelAndView saveStaff(@RequestParam String name,
                                     @RequestParam String cellPhone,
                                     @RequestParam String altPhone,
                                     @RequestParam String emailAddress,
                                     @RequestParam String mailingAddress,
                                     @RequestParam Integer staffType,
                                     @RequestParam String fatherName,
                                     @RequestParam String referenceName,
                                     @RequestParam String username,
                                     @RequestParam String password
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Customer Create");
        User duplicate = userDetailsService.getUser(username);
        if (duplicate != null) {
            map.put(ERROR_KEY, "Username -"+username+"- already exists");
            return new ModelAndView(REDIRECT_ERROR, map);
        }
        boolean saved = adminService.saveStaff(
                name,
                cellPhone,
                altPhone,
                emailAddress,
                mailingAddress,
                staffType,
                fatherName,
                referenceName,
                username,
                password
        );

        if (saved) {
            map.put(ERROR_KEY, "Saved Successfully");
            return new ModelAndView(REDIRECT_SUCCESS, map);
        } else {
            map.put(ERROR_KEY, "Saving failed !");
            return new ModelAndView(REDIRECT_ERROR, map);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customerList.se")
    public ModelAndView customerList() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Stock Ledger");
        map.put("customerList", adminService.findAllCustomer());

        return new ModelAndView("admin/customer_list", map);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/staffList.se")
    public ModelAndView staffList() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Stock Ledger");
        map.put("staffList", adminService.findAllStaff());

        return new ModelAndView("admin/staff_list", map);
    }

    // Manufacturer
    @RequestMapping(method = RequestMethod.GET, value = "/createManufacturer.se")
    public ModelAndView createManufacturer() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Manufacturer Create");

        return new ModelAndView("admin/manufacturer_create", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveManufacturer.se")
    public ModelAndView saveManufacturer(@RequestParam String name,
                                         @RequestParam String hotLine,
                                         @RequestParam String email,
                                         @RequestParam String officeAddress,
                                         @RequestParam String warehouseAddress,
                                         @RequestParam String factoryAddress,
                                         @RequestParam Integer since,
                                         @RequestParam String category
                                         ) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Manufacturer");
        Manufacturer m = new Manufacturer();
        m.setName(name);
        m.setEmail(email);
        m.setHotLine(hotLine);
        m.setOfficeAddress(officeAddress);
        m.setFactoryAddress(factoryAddress);
        m.setWarehouseAddress(warehouseAddress);
        m.setSince(since);
        m.setCategory(category);
        adminService.save(m);
        return new ModelAndView("redirect:/admin/manufacturerList.se");
    }
    @RequestMapping(method = RequestMethod.GET, value = "/manufacturerList.se")
    public ModelAndView manufacturerList() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Manufacturer");
        map.put("manuFList", adminService.findAllManufacturer());

        return new ModelAndView("admin/manufacturer_list", map);
    }
    // ItemReport
    @RequestMapping(method = RequestMethod.GET, value = "/createItemReport.se")
    public ModelAndView createItemReport(@RequestParam Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Manufacturer Create");
        map.put("item", shopService.getItem(id));
        User user = SessionUtil.getSessionUser();
        if (user instanceof Staff) {
            return new ModelAndView("admin/report_on_item", map);
        }else if(user instanceof Customer){
            return new ModelAndView("cust_template/pages/report_on_item", map);
        }else {
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveItemReport.se")
    public ModelAndView saveItemReport(@RequestParam Integer itemId,
                                         @RequestParam String comment,
                                         @RequestParam String suggestion
                                         ) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Item Report");
        ItemReport report = new ItemReport();
        report.setComment(comment);
        report.setSuggestion(suggestion);
        report.setDate(new Date());
        User user = SessionUtil.getSessionUser();
        report.setReporter(user);
        Item item = shopService.getItem(itemId);
        report.setItem(item);
        report.setViewed(false);
        adminService.save(report);
        return new ModelAndView("redirect:/admin/itemReportList.se");
    }
    @RequestMapping(method = RequestMethod.GET, value = "itemReportList.se")
    public ModelAndView itemReportList() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Stock Ledger");
        map.put("reportList", adminService.findAllItemReport());
        User user = SessionUtil.getSessionUser();
        if (user instanceof Staff) {
            return new ModelAndView("admin/item_report_list", map);
        }else if(user instanceof Customer){
            return new ModelAndView("redirect:/home/home.se", map);
        }else {
            return new ModelAndView("redirect:/");
        }

    }


}
