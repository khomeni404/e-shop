package bd.com.softengine.mis.service;


import net.sf.jasperreports.engine.JRDataSource;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.Map;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 14/09/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 14/09/15
 * Version : 1.0
 */

public interface MISService {

    public String getRealPath(String pathExtension);

    public ByteArrayOutputStream generateReport(HttpServletResponse response, Map<String, Object> params, JRDataSource dataSource);

}
