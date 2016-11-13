package bd.com.softengine;

import bd.com.softengine.admin.model.Customer;
import bd.com.softengine.admin.model.Staff;
import bd.com.softengine.security.SessionUtil;
import bd.com.softengine.security.model.LoginLog;
import bd.com.softengine.security.model.User;
import bd.com.softengine.util.NumberUtil;
import bd.com.softengine.util.ShopDictionary;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import bd.com.softengine.shop.model.Category;
import bd.com.softengine.shop.model.Item;
import bd.com.softengine.shop.model.Store;
//import bd.com.softengine.util.ExtJSReturn;
import bd.com.softengine.util.SoftUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Copyright @ Soft Engine Inc.
 * Created on 22/05/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 22/11/15
 * Version : 1.0
 */

@Controller
@RequestMapping("/home/")
public class HomeController extends ServiceFactory{
    @RequestMapping(method = RequestMethod.GET, value = "/home.se")
    public ModelAndView home() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Home");
        User user = SessionUtil.getSessionUser();
        if (user instanceof Staff) {
            securityService.saveLoginLog(user, true);
            return new ModelAndView("home/dashboard", map);
        } else if (user instanceof Customer) {
            securityService.saveLoginLog(user, true);
            Customer customer = adminService.getCustomer(user.getId());
            map.put("customer", customer);
            Double balance = customer.getCashAccount().getBalance();
            map.put("balance_in_word", NumberUtil.inWord((balance).longValue()).toUpperCase() + " TAKA ONLY");
            return new ModelAndView("cust_template/pages/dashboard_cust", map);
        }else {
            return new ModelAndView("redirect:/");
        }
    }



    @RequestMapping(method = RequestMethod.GET, value = "/genError.se")
    public ModelAndView genError(@RequestParam(required = false) String PageTitle,
                                             @RequestParam(required = false) String errorMsg) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", PageTitle);
        map.put("errorMsg", errorMsg);
        return new ModelAndView("home/gen_error_page", map);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/genSuccess.se")
    public ModelAndView genSuccess(@RequestParam(required = false) String PageTitle,
                                             @RequestParam(required = false) String successMsg) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", PageTitle);
        map.put("successMsg", successMsg);
        return new ModelAndView("home/gen_success_page", map);
    }
    //extTest
    @RequestMapping(value = {"extTest.se"})
    public ModelAndView extTest(HttpServletRequest request) {
        //request.getSession().invalidate();
        return new ModelAndView("pages/ext_test");
    }

    @RequestMapping(value = {"getStoreJsonData.se"}, method = RequestMethod.GET)
    public @ResponseBody String getStoreJsonData() {
        Gson gson = new Gson();
        // convert your list to json
        List<Store> storeList = shopService.findAllStore();
        String jsonProductList = gson.toJson(storeList);
        // print your generated json
        System.out.println("jsonCartList: " + jsonProductList);
        return jsonProductList;
        //return new ModelAndView("pages/ext_test");
    }

    @RequestMapping(value="getStoreJsonData2.se")
    public @ResponseBody
    Map<String,? extends Object> getStoreJsonData2(/*@RequestParam int start, @RequestParam int limit*/) throws Exception {
        /*try{
            List<Store> storeList = shopService.findAllStoreComboData(); // contactService.getContactList(start,limit);
            int total = storeList.size();
            return ExtJSReturn.mapOK2(storeList, total);
        } catch (Exception e) {
            return ExtJSReturn.mapError("Error retrieving Contacts from database.");
        }*/
        return null;
    }

    @RequestMapping(value="getSalesLedgerJsonData3.se")
    public @ResponseBody
    Map<String,? extends Object> getSalesLedgerJsonData3(@RequestParam int start, @RequestParam int limit) throws Exception {
        /*try{
            List<SalesLedger> storeList = shopService.findAllSalesLedgerJsonData(start, limit); // contactService.getContactList(start,limit);
            int total = storeList.size();
            return ExtJSReturn.mapOK3(storeList, total);
        } catch (Exception e) {
            return ExtJSReturn.mapError("Error retrieving Data from database.");
        }*/
        return null;
    }

    @RequestMapping(value="getSalesLedgerJsonData.se")
    public @ResponseBody
    Map<String,? extends Object> getSalesLedgerJsonData(/*@RequestParam int start, @RequestParam int limit*/) throws Exception {
        /*try{
            List<SalesLedger> storeList = shopService.findAllSalesLedgerJsonData(); // contactService.getContactList(start,limit);
            int total = storeList.size();
            return ExtJSReturn.mapOK2(storeList, total);
        } catch (Exception e) {
            return ExtJSReturn.mapError("Error retrieving Data from database.");
        }*/
        return null;
    }
    @RequestMapping(value="getCategoryComboJsonData.se")
    public @ResponseBody
    Map<String,? extends Object> getCategoryComboJsonData(/*@RequestParam int start, @RequestParam int limit*/) throws Exception {
        /*try{
            List<Category> storeList = shopService.findAllCategoryComboData(); // contactService.getContactList(start,limit);
            int total = storeList.size();
            return ExtJSReturn.mapOK2(storeList, total);
        } catch (Exception e) {
            return ExtJSReturn.mapError("Error retrieving Contacts from database.");
        }*/
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveItem2.se")
    public void saveItem2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, JSONException {
        String itemData = request.getParameter("itemData");
        JSONObject jsonObject = new JSONObject(itemData);
        Integer catId = jsonObject.getInt("catId");
        Gson gson = new Gson();
        Item item = gson.fromJson(itemData, Item.class);
        Category category = shopService.getCategory(catId);
        item.setCategory(category);
        category.getItemList().add(item);

        PrintWriter out = SoftUtil.getWriter(response);
        JsonObject myObj = new JsonObject();
        if (shopService.save(item)) {
            myObj.addProperty("success", true);
            myObj.addProperty("message", "Item saved Successfully");
        } else {
            myObj.addProperty("success", false);
            myObj.addProperty("message", "Sorry Can't saves.");
        }
        out.println(myObj.toString());
        out.close();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/extAjax2.se")
    public
    @ResponseBody
    String extAjax2() {

        return new Gson().toJson("Hello");

    }


}
