package bd.com.softengine.util;

public interface HTTPConstants {
    /**
     * HTTP request types
     */
    public static final int POST_TYPE   = 1;
    public static final int GET_TYPE    = 2;
    public static final int PUT_TYPE    = 3;
    public static final int DELETE_TYPE = 4;

    /**
     * HTTP request header constants
     */
    public static final String CONTENT_TYPE         = "Content-Type";
    public static final String ACCEPT_ENCODING      = "Accept-Encoding";
    public static final String CONTENT_ENCODING     = "Content-Encoding";
    public static final String ENCODING_GZIP        = "gzip";
    public static final String MIME_FORM_ENCODED    = "application/x-www-form-urlencoded";
    public static final String MIME_TEXT_PLAIN      = "text/plain";

}
