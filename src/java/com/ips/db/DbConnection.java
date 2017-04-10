/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ips.db;

import com.ips.util.AppConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DbConnection {
      Connection connection = null;
    public Connection getConnection() {
        if (connection == null) {
            connection = creatConnection();
        }
        return connection;
    }

    private Connection creatConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+ AppConstants.DB_SERVERIP + ":3306/ips_data",AppConstants.USER,AppConstants.PASSWORD);

        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         return connection;
    }


}
