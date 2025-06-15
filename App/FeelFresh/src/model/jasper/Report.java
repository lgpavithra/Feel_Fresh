package model.jasper;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Report {

    /*
    _____HOW TO USE THIS CLASS______
    
    
    EXAMPLE-:
    
        try {
            //STEP 1 - Create a HashMap<String,Object>
    1: HashMap<String, Object> map = new HashMap<>();
    
     *//*
            STEP 2 - Create a data source
                IF YOU DON'T HAVE ANY DATASOURCE YOU CAN PASS A JREmptyDatasource.
    
                //TABEL MODEL DATA SOURCE
    2: JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());

     *//*
        STEP 3 - Create a JasperPrint object
    3: JasperPrint print = JasperFillManager.fillReport("src/reports/order/filtered_orders.jasper", map, dataSource);
       
        STEP 4 - Pass above created object to the Report class.
    //This method is to pass the jasper print object to proceed ************* 
    4: Report.execute(print);

    } catch (JRException ex) {
        ex.printStackTrace();
    }
    
    
     */


    public static final int VIEW_REPORT = 0;

    public static void execute(JasperPrint jasperPrint) {
        view(jasperPrint);
    }

    public static void execute(JasperPrint jasperPrint, int option) {
        /*
        jasperPrint 
        option - (view(0) or direct print(1))
         */
        
        switch (option) {
            case 1:
                break;
            default:
                view(jasperPrint);
        }

    }

    /*
    
    
     */
    private Report() {
    }

    private static void view(JasperPrint print) {

        JasperViewer.viewReport(print, false);

    }

}
