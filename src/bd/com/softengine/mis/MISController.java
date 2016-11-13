package bd.com.softengine.mis;

import bd.com.softengine.ServiceFactory;
import bd.com.softengine.admin.model.Staff;
import bd.com.softengine.security.SessionUtil;
import bd.com.softengine.security.model.User;
import bd.com.softengine.shop.model.Item;
import bd.com.softengine.shop.model.ItemOutLog;
import bd.com.softengine.shop.model.MeasurementUnit;
import bd.com.softengine.shop.model.SalesLedger;
import bd.com.softengine.util.NumberUtil;
import bd.com.softengine.util.SEUtil;
import bd.com.softengine.util.ShopDictionary;
import bd.com.softengine.util.SoftUtil;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 14/09/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 14/09/15
 * Version : 1.0
 */

@Controller
@RequestMapping("/mis/")
public class MISController extends ServiceFactory {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @RequestMapping(value = "/printSalesOrder.se", method = RequestMethod.GET)
    public
    @ResponseBody
    String printSalesOrder(@RequestParam Integer id,
                           HttpServletRequest request, HttpServletResponse response)
            throws JRException, IOException {
        SalesLedger ledger = shopService.getSalesLedger(id);
        List<ItemOutLog> itemOutLogList = ledger.getOutLogList();

        Map<String, Object> params = new HashMap<>();
        List<Map<String, String>> dataList = new ArrayList<>();
        Map<String, String> map;
        int sl = 1;
        for (ItemOutLog log : itemOutLogList) {
            map = new HashMap<>();
            map.put("SL", ShopDictionary.DF_000.format(sl));
            Item item = log.getItem();
            map.put("ITEM_CODE", item.getItemCode() == null ? "" : item.getItemCode());
            map.put("ITEM_NAME", item.getName() == null ? "" : item.getName());
            Double qty = log.getQty();
            MeasurementUnit unit = item.getUnit();
            map.put("QTY", qty + " " + unit.getName());
            Double amount = log.getSalesPrice();
            map.put("UNIT_PRICE", BigDecimal.valueOf(amount).toPlainString());
            map.put("SALES_PRICE", BigDecimal.valueOf(qty*amount).toPlainString());
            dataList.add(map);
            sl++;
        }
        params.put("ORDER_NO", ledger.getOrderNo());
        params.put("DATE", sdf.format(ledger.getDate()));
        params.put("CUST_NAME", ledger.getCustomerName());
        String totalAmt = SoftUtil.toJasperAmt(ledger.getTotalAmount());
        params.put("TOTAL_AMT", totalAmt);
        params.put("TOTAL_AMT_WORD", NumberUtil.inWord((new Double(totalAmt)).longValue()).toUpperCase() + " TAKA ONLY");
        params.put("PAID_AMT", SoftUtil.toJasperAmt(ledger.getPaidTotal()));
        params.put("DUE_AMT", SoftUtil.toJasperAmt(ledger.getDueTotal()));
        Staff staff = ledger.getSalesMan();
        params.put("SALES_MAN", staff == null ? "" : staff.getName());
        JRDataSource dataSource = new JRBeanCollectionDataSource(dataList);
        try {
            params.put("format", "pdf");
            params.put("fileName", "test");
            ByteArrayOutputStream byteArrayOutputStream = misService.generateReport(response, params, dataSource);
            response.setContentLength(byteArrayOutputStream.size());
            response.getOutputStream().write(byteArrayOutputStream.toByteArray());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/home.se")
    public ModelAndView home() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PageTitle", "MIS Home");
        map.put("DashboardLink", ShopDictionary.DASHBOARD_LINK);
        // map.put("projectList", csdService.findAllProject());

        return new ModelAndView("mis/home", map);

    }

}

