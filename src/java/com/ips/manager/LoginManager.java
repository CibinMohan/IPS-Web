/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ips.manager;

import com.ips.bean.LoginBean;
import com.ips.db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * 
 */
public class LoginManager {
 Connection  connection = null;
    public LoginManager() {
        connection = new DbConnection().getConnection();
    }

    public String checkLogin(LoginBean loginBean) throws SQLException {
        String type = "";               
            String login = "select type from login_info where username = ? and password = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(login);
            preparedStatement.setString(1,loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());
            ResultSet executeQuery = preparedStatement.executeQuery();
            if(executeQuery.next()) {
             type = executeQuery.getString("type")   ;
            }
       
        return type;

    }

}
