package bd.com.softengine.shop;

import bd.com.softengine.ServiceFactory;
import bd.com.softengine.account.model.CashAccount;
import bd.com.softengine.admin.model.Customer;
import bd.com.softengine.admin.model.Manufacturer;
import bd.com.softengine.security.SessionUtil;
import bd.com.softengine.security.model.User;
import bd.com.softengine.security.service.ConfigureServiceImpl;
import bd.com.softengine.util.DateUtil;
import bd.com.softengine.util.SoftUtil;
import bd.com.softengine.util.Text;
import com.google.gson.Gson;
import bd.com.softengine.admin.model.Staff;
import bd.com.softengine.admin.service.AdminService;
import bd.com.softengine.shop.model.*;
import bd.com.softengine.shop.service.ShopService;
import bd.com.softengine.util.ShopDictionary;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 22/11/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 22/11/15
 * Version : 1.0
 */

@Controller
@RequestMapping("/shop/")
public class ShopController extends ServiceFactory implements Text {

    @RequestMapping(method = RequestMethod.POST, value = "/extAjax.se")
    public void getPatientList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JsonObject myObj = new JsonObject();
        /*String loginData = request.getParameter("loginData");
        Gson gson = new Gson();
        UserInfo userInfo = gson.fromJson(loginData, UserInfo.class);
        String userId = userInfo.getUserId();
        String password = userInfo.getPassword();

        PrintWriter out = SoftUtil.getWriter(response);

        JsonObject myObj = new JsonObject();

        //nothing was sent
        if (userId == null || password == null) {
            myObj.addProperty("success", false);
            myObj.addProperty("message", "Please send userId and Password!");
        } else {
            if (userId.trim().equals("ajax") && password.trim().equals("request")) {
                myObj.addProperty("success", true);
                myObj.addProperty("message", "Welcome to as400sampecode.blogspot.com");
            } else {
                myObj.addProperty("success", false);
                myObj.addProperty("message", "Looks like you forgot your login infomartion");
            }
        }

        out.println(myObj.toString());
        out.close();*/
        // return null;
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


    @RequestMapping(method = RequestMethod.GET, value = "/allStaff.se")
    public ModelAndView allStaff() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Item Create");

        map.put("allStaff", adminService.findAllStaff());

        return new ModelAndView("/shop/item_create", map);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/createItem.se")
    public ModelAndView createItem() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Item Create");
        map.put("maufList", adminService.findAllManufacturer());
        map.put("categoryList", /*new ArrayList<Category>()); //*/ shopService.findAllCategory());
        map.put("unitList", /*new ArrayList<MeasurementUnit>());// */shopService.findAllMeasurementUnit());

        return new ModelAndView("/shop/item_create", map);

    }

    @Autowired
    private ConfigureServiceImpl testService;

    @RequestMapping(method = RequestMethod.POST, value = "/saveItem.se")
    public ModelAndView saveItem(@RequestParam String name,
                                 @RequestParam String code,
                                 @RequestParam Integer catId,
                                 @RequestParam Integer maufId,
                                 @RequestParam Integer unitId) {
        //new BootStrapImpl().initializeDefaultSecurityData();
        //new BootStrapImpl().createDefaultAdmin();
        //testService.createDefaultAdmin();

        Item item = new Item();
        item.setName(name);
        item.setPurchasedPrice(0.0);
        item.setStock(0.0);
        item.setLabeledPrice(0.0);
        item.setPriceCode("");
        item.setItemCode(code);
        Category category = shopService.getCategory(catId);
        item.setCategory(category);
        MeasurementUnit unit = shopService.getMeasurementUnit(unitId);
        item.setUnit(unit);
        Manufacturer manufacturer = adminService.getManufacturer(maufId);
        item.setManufacturer(manufacturer);
        shopService.save(item);


        return new ModelAndView("redirect:/shop/createItem.se");

    }

    @RequestMapping(method = RequestMethod.GET, value = "/itemList.se")
    public ModelAndView itemList() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Stock Ledger");
        map.put("itemList", shopService.findAllItem());

        return new ModelAndView("shop/item_list", map);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/viewItem.se")
    public ModelAndView viewItem(@RequestParam Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "View Item");
        map.put("item", shopService.getItem(id));

        return new ModelAndView("shop/item_view", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateItem.se")
    public ModelAndView updateItem(@RequestParam Integer id,
                                         @RequestParam String code,
                                         @RequestParam String name,
                                         @RequestParam Double labeledPrice,
                                         @RequestParam Double stock) {
        Map<String, Object> map = new HashMap<>();
        map.put("PageTitle", "Sales Ledger List");
        Staff operator;
        User sessionUser = SessionUtil.getSessionUser();
        if (sessionUser instanceof Staff) {
            operator = adminService.getStaff(sessionUser.getId());
        } else {
            map.put("errorMsg", "You must have to be Staff to execute this operation.");
            return new ModelAndView(REDIRECT_ERROR, map);
        }
        boolean updated = shopService.updateItem(
                id,
                code,
                name,
                labeledPrice,
                stock,
                operator
        );
        if (updated) {
            return new ModelAndView("redirect:/shop/viewItem.se?id=" + id);
        }else {
            map.put("errorMsg", "Not Updated.");
            return new ModelAndView(REDIRECT_ERROR, map);
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/mUnitList.se")
    public ModelAndView mUnitList() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Unit List");
        map.put("mUnitList", shopService.findAllMeasurementUnit());

        return new ModelAndView("shop/m_unit_list", map);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/createStore.se")
    public ModelAndView createStore() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Unit List");
        map.put("storeList", shopService.findAllStore());
        return new ModelAndView("/shop/store_create", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveStore.se")
    public ModelAndView saveStore(@RequestParam String name,
                                  @RequestParam String address,
                                  @RequestParam String startedDate,
                                  @RequestParam String contactNo) {
        Date startedFrom = startedDate.equals("") ? new Date() : DateUtil.toDate(startedDate, "MM/DD/YYYY");
        Store store = new Store();
        store.setName(name);
        store.setStartedFrom(startedFrom);
        store.setAddress(address);
        store.setContactNo(contactNo);
        shopService.save(store);

        return new ModelAndView("redirect:/shop/createStore.se");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/createSalesLedger.se")
    public ModelAndView createSalesLedger(@RequestParam(required = false) String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Sales Order Create");
        map.put("message", msg);

        //List<Customer> customerList = shopService.findAllCustomer();
        // map.put("customerList", customerList);
        //List<Object[]> itemList = shopService.findAllItemWithDetails();
        List<Item> itemList = shopService.findAllItem();
        map.put("itemList", itemList);
        List<Store> storeList = shopService.findAllStore();
        map.put("storeList", storeList);
        List<Customer> customerList = adminService.findAllCustomer();
        map.put("customerList", customerList);
        List<Item> downStockList = shopService.findAllItem(10.0, true);
        map.put("downStockList", downStockList);
        return new ModelAndView("/shop/sales_order_create", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveSalesLedger.se")
    public ModelAndView saveSalesLedger(//@RequestParam Date orderDate,
                                        @RequestParam String customerName,
                                        @RequestParam Long customerId,
                                        @RequestParam String sourceName,
                                        @RequestParam Integer storeId,
                                        @RequestParam String itemArr,
                                        @RequestParam String qtyArr,
                                        @RequestParam String priceArr,
                                        @RequestParam String discountArr,
                                        @RequestParam String totPriceArr,
                                        @RequestParam Double roundDiscount,
                                        @RequestParam Double paid
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("PageTitle", "Sales Ledger List");
        Staff operator;
        User sessionUser = SessionUtil.getSessionUser();
        if (sessionUser instanceof Staff) {
            operator = adminService.getStaff(sessionUser.getId());
            CashAccount staffAccount = operator.getCashAccount();
            if (staffAccount == null) {
                map.put("errorMsg", "You have no 'Cash Account'");
                return new ModelAndView(REDIRECT_ERROR, map);
            }
        } else {
            map.put("errorMsg", "You must have to be Staff to execute this operation.");
            return new ModelAndView(REDIRECT_ERROR, map);
        }

        boolean saved = shopService.saveSalesLedger(
                operator,
                customerName,
                customerId,
                sourceName,
                storeId,
                itemArr,
                qtyArr,
                priceArr,
                discountArr,
                totPriceArr,
                roundDiscount,
                paid
        );
        if (saved) {
            map.put("successMsg", "Order saved Successfully");
            return new ModelAndView(REDIRECT_SUCCESS, map);
        } else {
            map.put("errorMsg", "Order can't be saved !");
            return new ModelAndView(REDIRECT_ERROR, map);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/salesLedgerList.se")
    public ModelAndView salesLedgerList() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Sales Ledger List");
        map.put("salesLedgerList", shopService.findAllSalesLedger());

        return new ModelAndView("shop/sales_ledger_list", map);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchSalesLedger.se")
    public ModelAndView searchSalesLedger(@RequestParam String salesLedgerSearchText) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Search Sales Ledger");
        map.put("salesLedgerList", shopService.findAllSalesLedger(salesLedgerSearchText));
        map.put("focusOn", "salesLedgerSearchText");

        return new ModelAndView("shop/sales_ledger_list", map);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/salesLedgerView.se")
    public ModelAndView salesLedgerView(@RequestParam Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Sales Ledger");
        map.put("salesLedger", shopService.getSalesLedger(id));

        return new ModelAndView("shop/sales_ledger_view", map);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/salesLedgerCustomerView.se")
    public ModelAndView salesLedgerCustomerView(@RequestParam Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Sales Ledger");
        map.put("salesLedger", shopService.getSalesLedger(id));

        return new ModelAndView("cust_template/pages/sales_ledger_view", map);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/createStockLedger.se")
    public ModelAndView createStockLedger(@RequestParam String source) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Stock Ledger");

        //List<Customer> customerList = shopService.findAllCustomer();
        // map.put("customerList", customerList);
        List<Item> itemList = shopService.findAllItem();
        map.put("itemList", itemList);
        List<Store> storeList = shopService.findAllStore();
        map.put("storeList", storeList);
        List<Staff> proprietorList = adminService.findAllStaff(0);
        map.put("proprietorList", proprietorList);
        Source s = shopService.getSource(source);
        map.put("source", s);

        return new ModelAndView("/shop/stock_ledger_create", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveStockLedger.se")
    public ModelAndView saveStockLedger(@RequestParam Integer sourceId,
                                        @RequestParam String refNo,
                                        @RequestParam String vendorName,
                                        @RequestParam Integer storeId,
                                        @RequestParam String itemArr,
                                        @RequestParam String qtyArr,
                                        @RequestParam String ppArr,
                                        @RequestParam String lpArr,
                                        @RequestParam String orderDate,
                                        @RequestParam Long propId
    ) {

        Map<String, Object> map = new HashMap<>();
        map.put("PageTitle", "Sales Ledger List");
        boolean saved = shopService.saveStockLedger(
                sourceId,
                refNo,
                vendorName,
                storeId,
                itemArr,
                qtyArr,
                ppArr,
                lpArr,
                orderDate,
                propId
        );

        if (saved) {
            map.put("successMsg", "Purchase Order saved Successfully !");
            return new ModelAndView(REDIRECT_SUCCESS, map);
        } else {
            map.put("errorMsg", "Unable to save Purchase Order !");
            return new ModelAndView(REDIRECT_ERROR, map);
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/stockLedgerList.se")
    public ModelAndView stockLedgerList() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Stock Ledger List");
        map.put("stockLedgerList", shopService.findAllStockLedger());

        return new ModelAndView("shop/stock_ledger_list", map);
    }


}
