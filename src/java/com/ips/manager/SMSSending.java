/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ips.manager;

import com.ips.util.AppConstants;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class SMSSending implements Runnable {

    private String urlStr = "";

    public void sendSMS(String msgString, String Phone) {

        try {
            urlStr = "http://bulksms.groupsmsindia.com/"
                    + "messageapi.asp?username=thinkforce&password=37854134"
                    + "&sender=think"
                    + "&mobile=" + Phone.trim() + "&message=" + msgString.replace(" ", "%20");
            System.out.println("url : " + urlStr);
            new Thread(this).start();
        } catch (Exception ex) {
            Logger.getLogger(SMSSending.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        try {
            System.out.println("In Run to send sms");
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();
            byte[] data = new byte[100];
            connection.getInputStream().read(data);
            System.out.println("Sent SMS To :" + new String(data));
        } catch (MalformedURLException ex) {
            Logger.getLogger(SMSSending.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SMSSending.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static void main(String[] args) {
//       //        String s =" manoj";
////        String msgString = "hai god mar nimg man how ar you manoj manoj manoj" +s+"manoj";
//        String Phone = "8281309774";
//        new SMSSending().sendSMS(msgString, Phone);
//        System.out.println("Send Successsfully");
//    }
}
