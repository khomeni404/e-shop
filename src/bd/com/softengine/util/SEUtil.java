/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.com.softengine.util;

import bd.com.softengine.enam.Applications;
import bd.com.softengine.licencing.SELicence;

/**
 * @author   [+--+]
 */
public class SEUtil {
    public static ActionResult checkLicenceValidity(Applications app){
        return SELicence.checkLicenceValidity(app);
    }
}
