package bd.com.softengine.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 07/01/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 07/01/16
 * Version : 1.0
 */

public interface Text {

    public static final String NOT_A_STAFF = "Only staff have this permission";
    public static final String REDIRECT_ERROR = "redirect:/home/genError.se";
    public static final String ERROR_KEY = "errorMsg";
    public static final String REDIRECT_SUCCESS = "redirect:/home/genSuccess.se";
    public static final String SUCCESS_KEY = "successMsg";

    public static final DecimalFormat DF_00 = new DecimalFormat("00");
    public static final DecimalFormat DF_000 = new DecimalFormat("000");
    public static final DecimalFormat DF_0000 = new DecimalFormat("0000");
    public static final DecimalFormat DF_JASPER = new DecimalFormat("0.00");
    public static final SimpleDateFormat SDF_DMY = new SimpleDateFormat("dd/MM/yyyy");


}
