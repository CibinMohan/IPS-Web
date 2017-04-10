/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ips.manager;

import com.ips.db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class DataAnalysis {

    Connection connection = null;

    public DataAnalysis() {
        connection = new DbConnection().getConnection();
    }

    public ArrayList getValue() {
        ArrayList list = new ArrayList();
        String[] value = {"Documents", "Driving", "Speed & Overtaking", "Pollution", "Parking", "Signal"};
        try {
            for (int i = 0; i < value.length; i++) {
                int count = 0;
                String number = "Select * from case_details_info where Case_type = ? and MONTH(dates) = MONTH(CURDATE())";
                PreparedStatement statement = connection.prepareStatement(number);
                statement.setString(1, value[i]);
                ResultSet executeQuery1 = statement.executeQuery();
                while (executeQuery1.next()) {
                    count++;
                }
                list.add(count);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAnalysis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList getDateInWeek() {
         ArrayList list = new ArrayList();
        String[] value = {"Documents", "Driving", "Speed & Overtaking", "Pollution", "Parking", "Signal"};
        try {
            for (int i = 0; i < value.length; i++) {
                int count = 0;
                String number = "Select * from case_details_info where Case_type = ? and week(`dates`) = week(curdate())";
                PreparedStatement statement = connection.prepareStatement(number);
                statement.setString(1, value[i]);
                ResultSet executeQuery1 = statement.executeQuery();
                while (executeQuery1.next()) {
                    count++;
                }
                list.add(count);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAnalysis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
