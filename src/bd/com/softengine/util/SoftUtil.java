package bd.com.softengine.util;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 05/09/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 05/09/15
 * Version : 1.0
 */

public class SoftUtil {


    public static void main(String[] args) {
        System.out.println(makeCID(5L,"B", "78"));
        //System.out.println(formatCID("87dd4"));
      //  System.out.println(formatCID("1A1"));

    }

    public static String formatCID(String cid) {
        DecimalFormat pdf = new DecimalFormat(ShopDictionary.PROJECT_ID_FORMAT);
        DecimalFormat sdf = new DecimalFormat(ShopDictionary.SHARE_ID_FORMAT);
        String[] idArray = cid.split("[^a-zA-Z0-9]+|(?<=[a-zA-Z])(?=[0-9])|(?<=[0-9])(?=[a-zA-Z])");
        String returnId = ShopDictionary.CUSTOMER_ID_PREFIX;
        try {
            returnId += pdf.format(Integer.parseInt(idArray[0]));
            returnId += "-" + idArray[1].toUpperCase() + "-";
            returnId += sdf.format(Integer.parseInt(idArray[2]));
        } catch (IndexOutOfBoundsException ex) {
            returnId = "invalid";
        } catch (NumberFormatException ex) {
            returnId = "invalid";
        }
        return returnId;
    }

    /**
     *
     * @param projectId
     * @param phaseCode
     * @param cid
     * @return
     */
    public static String makeCID(Long projectId, String phaseCode, String cid) {
        String[] cidArr = cid.split("-");
        if (cidArr.length == 3) {
            cid = cidArr[2];
        }
        DecimalFormat pdf = new DecimalFormat(ShopDictionary.PROJECT_ID_FORMAT);
        DecimalFormat sdf = new DecimalFormat(ShopDictionary.SHARE_ID_FORMAT);
        String returnId = ShopDictionary.CUSTOMER_ID_PREFIX;
        returnId += pdf.format(projectId);
        returnId += "-" + phaseCode.toUpperCase() + "-";
        returnId += sdf.format(Integer.parseInt(cid.trim()));
        return returnId;
    }

    public static PrintWriter getWriter(HttpServletResponse response) throws IOException{
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");

        return writer;
    }

    public static String generateId_12() {
        DateFormat df = new SimpleDateFormat("yyMMddHHmmss");
        return df.format(new Date());
    }
    public static String toJasperAmt(Double d) {
        return BigDecimal.valueOf(d.intValue()).toPlainString()+"";
    }
}
