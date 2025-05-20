package model.jasper;

import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

public class JasperReport {

    public static JasperReport jasperReport;

    private JasperReport() {

    }

    public static JasperReport getInstance() {
        if (jasperReport == null) {
            jasperReport = new JasperReport();
        }
        return jasperReport;
    }
    
    
//    public static void view(String report, HashMap<Object,Object> map, ){
//
//        try {
//
//            JasperViewer.viewReport(JasperFillManager.fillReport(jasperReport, parameters, dataSource));
//            
//        } catch (Exception e) {
//        }
//        
//    }
//    

}
