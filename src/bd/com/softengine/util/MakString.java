package bd.com.softengine.util;

/**
 * Created by ayatullah on 13/04/2015.
 */
public class MakString {

    public static String getDashOnEmpty(String s){
        String rtString=null;
        if (s.trim().equals("") || s.equals(null)) {
            rtString = "---";
        } else {
            rtString = s;
        }
        return rtString;
    }
}
