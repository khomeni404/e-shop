package bd.com.softengine.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Contains the constants
 */
public class ShopDictionary {

	public static final String SESSION_USER = "sessionUser";
	public static final String SESSION_USER_ID = "sessionUserId";
	public static final String SESSION_USER_AUTHORIZED_GROUPS = "sessionUserAuthorizedGroups";
	public static final String SESSION_USER_AUTHORITIES = "sessionUserAuthorities";
	public static final String SESSION_USER_FEATURES = "sessionUserFeatures";
    public static final String SESSION_SAVE = "save";
    public static final String DASHBOARD_LINK = "../home/home.se";
    public static final String EMAIL_SUFFIX =   "Best Regards...\n" +
                                                "Customer Care\n" +
                                                "Fair Vision Properties Ltd.\n" +
                                                "N.B. This is an automatic system generated email. Feel free to call 01938852237, if found any inconsistency.";
    public static final String CUSTOMER_ID_PREFIX = "";
    public static final String PROJECT_ID_FORMAT = "00";     //02-A-0025
    public static final String SHARE_ID_FORMAT = "0000";     //02-A-0025


    public static final DecimalFormat DF_00 = new DecimalFormat("00");
    public static final DecimalFormat DF_000 = new DecimalFormat("000");
    public static final DecimalFormat DF_0000 = new DecimalFormat("0000");
    public static final DecimalFormat DF_JASPER = new DecimalFormat("0.00");
    public static final SimpleDateFormat SDF_DMY = new SimpleDateFormat("dd/MM/yyyy");


    public static final String APT = "APT";
    public static final String PLOT = "PLOT";

    public static final String PROCESSING = "Processing";
    public static final String APPROVED = "Approved";
    public static final String CANCELLED = "Cancelled";
    public static final String REFUNDED= "Refunded";

    public static final String CHECKED = "Checked";
    public static final String PASSED = "Passed";
    public static final String REJECTED = "Rejected";
    public static final String PETTY_CASH = "Petty Cash";

    public static final String ACC_TYPE_BANK = "Bank Account";
    public static final String ACC_TYPE_CASH = "Cash Account";
    public static final String DR = "DR";
    public static final String CR = "CR";
    public static final String SHOP_STOCK_IN_SOURCE[][] = {
            {"0", "Purchase", "Item in by purchasing"},
            {"1", "Return", "Return of sales item"},
            {"2", "Donation", "Someone donate"}
    };



}
