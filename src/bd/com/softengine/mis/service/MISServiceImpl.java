package bd.com.softengine.mis.service;

import bd.com.softengine.DAOFactory;
import bd.com.softengine.ServiceFactory;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 14/09/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 14/09/15
 * Version : 1.0
 */

@Service
public class MISServiceImpl extends DAOFactory implements MISService {


    @Override
    public String getRealPath(String pathExtension) {
        try {
            String filePath = "bd/com/softengine/mis/jasper" + pathExtension;
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            return classLoader.getResource(filePath).getPath();
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public ByteArrayOutputStream generateReport(HttpServletResponse response, Map<String, Object> params, JRDataSource dataSource) {
        try {
            String format = (String) params.get("format");
            String fileName = (String) params.get("fileName");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            InputStream jasperStream = this.getClass().getResourceAsStream("/bd/com/softengine/mis/jasper/" + fileName + ".jasper");
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

            if (format.equals("pdf")) {
                JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            } else if (format.equals("html")) {
                JRHtmlExporter htmlExporter = new JRHtmlExporter();
                htmlExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                htmlExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
                // File imageDir = new File(context.substring(0, context.indexOf("WEB-INF")) + "\\images");
                // htmlExporter.setParameter(JRHtmlExporterParameter.IMAGES_DIR, imageDir);
                htmlExporter.setParameter(JRHtmlExporterParameter.IS_OUTPUT_IMAGES_TO_DIR, Boolean.FALSE);
                htmlExporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                htmlExporter.exportReport();
            } else if (format.equals("excel")) {
                JRXlsExporter exporterXLS = new JRXlsExporter();
                exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, stream);
                exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                exporterXLS.exportReport();
            } else if (format.equals("csv")) {
                JRCsvExporter exporter = new JRCsvExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
                exporter.exportReport();
            } else if (format.equals("download")) {
                response.setContentType("application/x-pdf");
                response.setHeader("Content-disposition", "inline; filename=" + fileName + ".pdf");
                final OutputStream outStream = response.getOutputStream();
                JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
                //JasperExportManager.exportReportToPdf(jasperPrint);
            } else {
                JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            }

            return stream;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
