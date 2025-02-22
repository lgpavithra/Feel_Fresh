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
     * @return the recipients
     */
    public String getRecipients() {
        return recipients;
    }

    /**
     * @param recipients the recipients to set
     */
    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

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
            setRecipient();
            setSubject();
            setBody();
         */
        setupCredentials();
        this.frame = f;

    }

//    Varables
    //emails
    private String sender;
    private String recipients;

    private String subject;
    private String body;

    //credentials
    private String host = "smtp.gmail.com";
    private String username;
    private String password;

    public void setupCredentials() {
        //check that saved file is avaliable
        File file = new File("email/credentials.ser");

        if (file.exists()) {

            Credentials cre = new Credentials();
            this.username = cre.getUsername();
            this.password = cre.getPassword();
            this.sender = cre.getSender();

            if (this.username == null || this.password == null || this.sender == null
                    || this.username.isBlank() || this.password.isBlank() || this.sender.isBlank()) {
                collectCredentials();

                cre = new Credentials();
                this.username = cre.getUsername();
                this.password = cre.getPassword();
                this.sender = cre.getSender();
            }

        } else {

            collectCredentials();

            Credentials cre = new Credentials();
            this.username = cre.getUsername();
            this.password = cre.getPassword();
            this.sender = cre.getSender();
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
            message.setFrom(new InternetAddress(getSender()));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(getRecipients()));
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
            return 0;
        } catch (MessagingException ex) {
            ex.printStackTrace();
            return 1;
        }

    }

    private void collectCredentials() {
        Credentials cre = new Credentials();

        String[] creArray = {cre.getUsername(), cre.getPassword(), cre.getSender()};//this array is used as a container to get collected valuses from jdialog below.

        new GetEmailCredentials(frame, true, creArray).setVisible(true);

        cre.setUsername(creArray[0]);
        cre.setPassword(creArray[1]);
        cre.setSender(creArray[2]);

        cre.saveObject();
    }

}
