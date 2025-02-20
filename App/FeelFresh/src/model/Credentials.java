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
class Credentials implements Serializable {

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

    // the transient keyword is used to ignore these fields from serialization process
    private transient File file;
    private transient FileInputStream fileIS;
    private transient ObjectInputStream objectIS;

    private transient FileOutputStream fileOS;
    private transient ObjectOutputStream objectOS;

    Credentials() {

        file = new File("email/credentials.ser");

        if (!file.exists()) {
            file.getParentFile().mkdir();
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            System.out.println("created");
        } else {
            System.out.println("read");
            readObject();
        }

    }

    public void readObject() {

        try {
            fileIS = new FileInputStream(file);
            objectIS = new ObjectInputStream(fileIS);
            Object obj = objectIS.readObject();
            if (obj instanceof Credentials) {
                Credentials cre = (Credentials) obj;

                this.username = cre.getUsername();
                this.password = cre.getPassword();
            }

            fileIS.close();
            objectIS.close();

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
                fileOS = new FileOutputStream(file);
                objectOS = new ObjectOutputStream(fileOS);

                objectOS.writeObject(this);
                System.out.println(this.getClass());

                fileOS.close();
                objectOS.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }

    //credentials    
    private String username;
    private String password;

}
