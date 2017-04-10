/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ips.manager;

import com.ips.bean.RegistrationBean;
import com.ips.db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class RegistrationManager {

    Connection connection = null;

    public RegistrationManager() {
        connection = new DbConnection().getConnection();
    }
    //  police Registration

    public int policeRegistration(RegistrationBean policeBean) {
        int number = 0;
        try {
            String str = "select username from login_info where username = ?";
            PreparedStatement statement = connection.prepareStatement(str);
            statement.setString(1, policeBean.getUsername());
            ResultSet executeQuery = statement.executeQuery();
            if (!executeQuery.next()) {
                String login = "insert into login_info(password,username,type) VALUES(?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(login);
                preparedStatement.setString(1, policeBean.getPassword());
                preparedStatement.setString(2, policeBean.getUsername());
                preparedStatement.setString(3, policeBean.getUserType());
                int executeUpdate = preparedStatement.executeUpdate();
                if (executeUpdate > 0) {
                    String register = "insert into police_info(username,name,email,phone,address) values(?,?,?,?,?)";
                    PreparedStatement ps = connection.prepareStatement(register);
                    ps.setString(1, policeBean.getUsername());
                    ps.setString(2, policeBean.getName());
                    ps.setString(3, policeBean.getEmail());
                    ps.setString(4, policeBean.getPhone());
                    ps.setString(5, policeBean.getAddress());
                    number = ps.executeUpdate();
                }
            }
            if (number > 0) {

                //mail sending
                String sub = "Hi Police Officer, You have successfully registered with IPS ";
                String message = "Please note down the following details for future references\n"
                        + "Username : " + policeBean.getUsername() + "\n" + "Password : " + policeBean.getPassword();
                String smsMessage = "Please note down the following details for future references"
                        + "Username : " + policeBean.getUsername() + "Password : " + policeBean.getPassword();
                MailSending mailSending = new MailSending(policeBean, message, sub);
                new Thread(mailSending).start();

                // send SMS
                SMSSending mSSending = new SMSSending();
                mSSending.sendSMS(smsMessage, policeBean.getPhone());
            } else {
                String deletePolice = "delete from login_info where username = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(deletePolice);
                preparedStatement.setString(1, policeBean.getUsername());
                int executeUpdate = preparedStatement.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return number;
    }
    // cout Registration

    public int coutRegistration(RegistrationBean bean) {
        int number = 0;
        try {
            String str = "select username from login_info where username = ?";
            PreparedStatement statement = connection.prepareStatement(str);
            statement.setString(1, bean.getUsername());
            ResultSet executeQuery = statement.executeQuery();
            if (!executeQuery.next()) {
                String login = "insert into login_info(password,username,type) VALUES(?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(login);
                preparedStatement.setString(1, bean.getPassword());
                preparedStatement.setString(2, bean.getUsername());
                preparedStatement.setString(3, bean.getUserType());
                int executeUpdate = preparedStatement.executeUpdate();
                if (executeUpdate > 0) {
                    String register = "insert into court_info(username,court_name,email,phone,address) values(?,?,?,?,?)";
                    PreparedStatement ps = connection.prepareStatement(register);
                    ps.setString(1, bean.getUsername());
                    ps.setString(2, bean.getName());
                    ps.setString(3, bean.getEmail());
                    ps.setString(4, bean.getPhone());
                    ps.setString(5, bean.getAddress());
                    number = ps.executeUpdate();
                }
            }
            if (number > 0) {

                //mail sending
                String sub = "Hi Court Officer, You have successfully registered with IPS";
                String message = "Please note down the following details for future references\n"
                        + "Username : " + bean.getUsername() + "\n" + "Password : " + bean.getPassword();
                String smsMessage = "Please note down the following details for future references"
                        + " Username : " + bean.getUsername() + "Password : " + bean.getPassword();
                MailSending mailSending = new MailSending(bean, message, sub);
                new Thread(mailSending).start();

                // send SMS
                SMSSending mSSending = new SMSSending();
                mSSending.sendSMS(smsMessage, bean.getPhone());

            }else {
                String deletePolice = "delete from login_info where username = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(deletePolice);
                preparedStatement.setString(1,bean.getUsername());
                int executeUpdate = preparedStatement.executeUpdate();
            }


        } catch (SQLException ex) {
            Logger.getLogger(RegistrationManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return number;
    }

    public boolean checkUsername(String user) {
        boolean b = false;
        try {
            String query = "select username from login_info";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                if (username.equalsIgnoreCase(user)) {
                    b = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
}
