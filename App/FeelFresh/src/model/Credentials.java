/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Credentials implements Serializable {

    /**
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    private transient File file = new File("email/credentials.ser");

    public Credentials() {

        if (!file.exists()) {
            file.getParentFile().mkdir();
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            System.out.println("created");
        } else {
            
            readObject();
        }

    }

    public void readObject() {

        try {

            FileInputStream fileIS = new FileInputStream(file);
            ObjectInputStream objectIS = new ObjectInputStream(fileIS);

            Credentials cre = (Credentials) objectIS.readObject();

            this.username = cre.getUsername();
            this.password = cre.getPassword();
            this.sender = cre.getSender();

            objectIS.close();
            fileIS.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public void saveObject() {

        if (this.username != null && this.password != null) {

            try {

                FileOutputStream fileOS = new FileOutputStream(file);
                ObjectOutputStream objectOS = new ObjectOutputStream(fileOS);

                objectOS.writeObject(this);
                

                objectOS.close();
                fileOS.close();

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }

    //credentials    
    private String sender ;
    private String username;
    private String password;

}
