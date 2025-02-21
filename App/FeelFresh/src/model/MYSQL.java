/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Virajith Pavitha
 */
public class MYSQL {

    public static Connection connection;
    private static String username ;
    private static String password ;

    public static void createConnection() {
        settingUsernamePassword_vp();
        try {
            if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/feelfresh_db", username, password);
        }
        } catch (Exception e) {
            
            
            File file_vp = new File("dbInfo.txt");
            if (file_vp.delete()) {
                settingUsernamePassword_vp();    //delete existig data and recollect.
            }else{
            
            e.printStackTrace();
            
            }
            
            
            
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
    private static void settingUsernamePassword_vp(){
        File file = new File("dbInfo.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();// creating the file
            }
        } catch (IOException e) {
            System.out.println("dbInfo.txt couldn't be created.");
            e.printStackTrace();
        }
        
        try {
            Scanner sc_vp = new Scanner(file);
            for (int i=0; i<2; i++) {                
                if (sc_vp.hasNextLine()) {//check that username is avaliable
                    if (i == 0) {
                        username = sc_vp.nextLine();
                        
                    }else if(i == 1){//check that password is avaliable
                        password = sc_vp.nextLine();
                    }
                    
                    System.out.println(i);
                }else{
                    Scanner sc_in_vp = new Scanner(System.in);
                    
                    if (i ==0) {
                        System.out.println("Username not found \n Please enter database username here : ");
                        username = sc_in_vp.nextLine().trim();                        
                        System.out.println("Done");
                    }else if (i == 1) {
                        System.out.println("Password not found \n Please enter database password here : ");
                        password = sc_in_vp.nextLine().trim();
                        System.out.println("Done");
                    }
                    
                    try {
                        FileWriter writer_vp = new FileWriter("dbInfo.txt");
                        
                        writer_vp.write( username +"\n" + password);
                        
                        writer_vp.close();
                    } catch (IOException e) {
                        
                        e.printStackTrace();
                    }
                    
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        
        
    }
    
    //setting username and password
}
