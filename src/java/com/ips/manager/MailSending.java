/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ips.manager;

import com.ips.bean.RegistrationBean;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * 
 */
public class MailSending implements Runnable {

    String MAIL_SUBJECT = "";
    String content = "";
    RegistrationBean bean = null;

    MailSending(RegistrationBean policeBean, String message, String sub) {
        bean = policeBean;
        content = message;
        MAIL_SUBJECT = sub;
    }

    public void run() {
          String number = "";
        try {
      
            Properties properties = System.getProperties();
            properties.put("mail.smtps.host", "smtp.gmail.com");
            properties.put("mail.smtps.auth", "true");
            properties.put("mail.smtps.quitwait", "true");
            // Session session = Session.getInstance(properties);
            Session mailSession = Session.getDefaultInstance(properties, null);

            MimeMessage msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(bean.getEmail()));
            if (bean.getPassword() != null) {

                msg.addRecipients(Message.RecipientType.TO, bean.getEmail());
                number = "a";
            }
            msg.setSubject(MAIL_SUBJECT);
            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();
            // Fill the message
            messageBodyPart.setText(content);
            // Create a Multipart
            Multipart multipart = new MimeMultipart();
            // Add part one
            multipart.addBodyPart(messageBodyPart);
            msg.setContent(multipart);
            msg.saveChanges();
            Transport tr = mailSession.getTransport("smtps");
            tr.connect("smtp.gmail.com", "i.police.system@gmail.com", "ipolicesystem");
            // tr.connect("smtp.gmail.com", bean.getFrom(), "netbeans");
            tr.sendMessage(msg, msg.getAllRecipients());
            tr.close();
            System.out.println("Mailsending.......");

        } catch (MessagingException ex) {
            Logger.getLogger(MailSending.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
