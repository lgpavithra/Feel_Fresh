/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import finance.TransactionManager;
import gui.dialog.ConnectionDialog;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.io.BeanReader;
import model.system.SystemStatus;

/**
 *
 * @author Virajith Pavitha
 */
public class MYSQL {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MYSQL.class);    
    
    public static Connection connection;
    private static DbInfoBean bean;
    private static ConnectionDialog conDialog_vp;

    public static String createConnection() {
        /*
        Return>
            **Success - Connection success
            **Error message
         */
        settingUsernamePassword_vp();
        try {
            if (connection == null) {
 


                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://" + bean.getHost() + ":" + bean.getPort() + "/" + bean.getDbName() + "", bean.getUsername(), bean.getPassword());


            }
            return "Success";
        } catch (SQLException ex) {

            logger.error("EXCEPTION",ex);
            ex.printStackTrace();

            showDBInfoDialog();//if error found , collect details again
            settingUsernamePassword_vp();

            return "MYSQL.createConnection();.... \n" + ex;

        } catch (ClassNotFoundException ex) {
            logger.error("EXCEPTION",ex);
            ex.printStackTrace();
            return "MYSQL.createConnection();.... \n" + ex;
        }

    }

    public static ResultSet executeSearch(String q) throws Exception {
        createConnection();
        return connection.createStatement().executeQuery(q);

    }

    public static void executeIUD(String q) throws Exception {
        createConnection();
        connection.createStatement().executeUpdate(q);
    }

    //==============================================================================
    //setting username and password
    private static void settingUsernamePassword_vp() {
        File file = new File("dbInfo.ser");
        try {
            if (!file.exists()) {
                file.createNewFile();// creating the file  
                showDBInfoDialog();
            }
            //
            try {
                try {
                    bean = (DbInfoBean) BeanReader.getInstance().read(file);
                } catch (ClassCastException ex) {
                    showDBInfoDialog();
                    logger.error("EXCEPTION",ex);
                    ex.printStackTrace();                    
                }
            } catch (IOException ex) {
                showDBInfoDialog();
                logger.error("EXCEPTION",ex);
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                showDBInfoDialog();
                logger.error("EXCEPTION",ex);
                ex.printStackTrace();
            }

            //
        } catch (IOException e) {
            System.out.println("dbInfo.ser couldn't be created.");
            logger.error("EXCEPTION",e);
            e.printStackTrace();
        }

    }

    private static void showDBInfoDialog() {
        
        System.out.println("con "+SystemStatus.connectionDialog );
        System.out.println("set " + SystemStatus.settingsDialog );
        if (SystemStatus.connectionDialog == 0 ) {
            if (SystemStatus.settingsDialog == 0) {
                new ConnectionDialog(Frame.getFrames()[0]).setVisible(true);
            }
        }
    }

}
