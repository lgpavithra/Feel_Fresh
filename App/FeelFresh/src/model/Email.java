/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import gui.dialog.GetEmailCredentials;
import java.awt.Frame;
import java.io.File;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author PC
 */
public class Email {

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    private Frame frame;//parent frame

    public Email(Frame f) {
        
        /*These methods should be called before send the email
            setSubject();
            setBody();
        */
        
        setupCredentials();
        this.frame = f;

    }

//    Varables
    //emails
    private String sender = "test@gmail.com";
    private String recipients = "test@gmail.com";

    private String subject;
    private String body;

    //credentials
    private String host = "smtp.gmail.com";
    private String username = "test@gmail.com";
    private String password = "test test test test";

    public void setupCredentials() {
        //check that saved file is avaliable
        File file = new File("email/credentials.ser");

        if (file.exists()) {
            System.out.println("avaliable");
        } else {
            System.out.println("unavaliable");

            Credentials cre = new Credentials();
            String[] creArray = {cre.getUsername(), cre.getPassword()};//this array is used as a container to get collected valuses from jdialog below.

            new GetEmailCredentials(frame, true, creArray).setVisible(true);

            cre.setUsername(creArray[0]);
            cre.setPassword(creArray[1]);

            cre.saveObject();
        }

    }

//    setup properties
    private Properties props = new Properties();

    private void setup() {

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.protocols", "TLSv1.3");  // Specify the TLS protocol version
        props.put("mail.smtp.ssl.ciphers", "TLS_AES_128_GCM_SHA256");  // Specify the cipher suite

    }

//    create the session
    Session session = Session.getInstance(props, new Authenticator() {

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }

    });

//    compose the message
    Message message = new MimeMessage(session);

    private void composeEmail() {
        try {
            message.setFrom(new InternetAddress(sender));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));
            message.setSubject(subject);

            Multipart mpart = new MimeMultipart();
            BodyPart bodyHtmlPart = new MimeBodyPart();
            bodyHtmlPart.setContent(body, "text/html");
            mpart.addBodyPart(bodyHtmlPart);

            message.setContent(mpart);

        } catch (AddressException ex) {
            ex.printStackTrace();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

//    send the email
    public int sendEmail() {
        //this returns 0 - success , 1 - error was occured
        setup();
        composeEmail();        

        try {
            Transport.send(message);
            System.out.println("Email was sent successfully");
            return 0;
        } catch (MessagingException ex) {
            ex.printStackTrace();
            return 1;
        }

    }

}
