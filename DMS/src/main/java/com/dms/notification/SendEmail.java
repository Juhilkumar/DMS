package com.dms.notification;

import com.dms.notification.interfaces.ISendEmail;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail implements ISendEmail {

    public static final String USERNAME="g7518925@gmail.com";
    public static final String PASSWORD="Group11@dms";
    public static String hostname="";
    public static String port="";
    public static String auth="";
    public static String TLS_ENABLED="";
    public static String SSL_ENABLED="";
    public static String SSL_TRUST="";

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("properties//mailNotification.properties"));
            hostname=properties.getProperty("hostname");
            port=properties.getProperty("port");
            auth=properties.getProperty("auth");
            TLS_ENABLED=properties.getProperty("tls_enabled");
            SSL_ENABLED=properties.getProperty("ssl_enabled");
            SSL_TRUST=properties.getProperty("ssl_trust");
        } catch (IOException e) {

        }
    }

    private static class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(USERNAME, PASSWORD);
        }
    }

    public boolean sendMailNotification(String recipients[],String mailSubject, String mailBody){
        boolean mailSent = false;
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", hostname);
            properties.put("mail.smtp.port", port);
            properties.put("mail.smtp.auth", auth);
            properties.put("mail.smtp.starttls.enable", TLS_ENABLED);
            properties.put("mail.smtp.ssl.enable", SSL_ENABLED);
            properties.put("mail.smtp.ssl.trust", SSL_TRUST);

            Authenticator authenticator = new SMTPAuthenticator();
            Session smtpMailSession = Session.getInstance(properties,authenticator);
            smtpMailSession.setDebug(false);
            Message message = new MimeMessage(smtpMailSession);
            InternetAddress addressFrom = new InternetAddress(USERNAME);
            message.setFrom(addressFrom);
            InternetAddress[] addressTo = new InternetAddress[recipients.length];
            if(addressTo != null){
                for (int i = 0; i < recipients.length; i++) {
                    addressTo[i] = new InternetAddress(recipients[i]);
                }
                message.setRecipients(Message.RecipientType.BCC, addressTo);
            }
            message.setSubject(mailSubject);
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(mailBody, "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport transport = smtpMailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", USERNAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            mailSent= true;
        }
        catch (Exception e)
        {e.printStackTrace();
            mailSent= false;
        }
        return mailSent;
        }
}

