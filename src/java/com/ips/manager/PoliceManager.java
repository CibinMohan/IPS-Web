/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ips.manager;

import com.ips.bean.CaseBean;
import com.ips.bean.RegistrationBean;
import com.ips.db.DbConnection;
import com.ips.util.AppConstants;
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
public class PoliceManager {

    Connection connection = null;

    public PoliceManager() {
        connection = new DbConnection().getConnection();
    }
      // Admin  delete Police
    public int deletePolice(int parseInt) {
        int number = 0;
        String username = "";
        try {
            String getusername = "select username from police_info where police_id = ?";
            PreparedStatement ps = connection.prepareStatement(getusername);
            ps.setInt(1, parseInt);
            ResultSet executeQuery = ps.executeQuery();
            if (executeQuery.next()) {
                username = executeQuery.getString("username");
            }

            String deletePolice = "delete from login_info where username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deletePolice);
            preparedStatement.setString(1, username);
            number = preparedStatement.executeUpdate();      


        } catch (SQLException ex) {
            Logger.getLogger(PoliceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return number;
    }
      // get police data for editing
    public RegistrationBean getEditPolice(int id) {
        RegistrationBean registrationBean = new RegistrationBean();
        try {
            String getCourt = "select * from police_info where police_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(getCourt);
            preparedStatement.setInt(1, id);
            ResultSet executeQuery = preparedStatement.executeQuery();
            if (executeQuery.next()) {
                registrationBean.setName(executeQuery.getString("name"));
                registrationBean.setEmail(executeQuery.getString("email"));
                registrationBean.setPhone(executeQuery.getString("phone"));
                registrationBean.setUsername(executeQuery.getString("username"));
                registrationBean.setId(executeQuery.getString("police_id"));
                registrationBean.setAddress(executeQuery.getString("address"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourtManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registrationBean;
    }
      // Edit police profile
    public int updatePolice(RegistrationBean policeBean) {
        int number = 0;
        try {
            String updatePolice = "update police_info set name = ?,email = ?,phone = ?,address = ? where username = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(updatePolice);
            preparedStatement.setString(1, policeBean.getName());
            preparedStatement.setString(2, policeBean.getEmail());
            preparedStatement.setString(3, policeBean.getPhone());
            preparedStatement.setString(4, policeBean.getAddress());
            preparedStatement.setString(5, policeBean.getUsername());
            number = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PoliceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return number;

    }

    //  get History to police
    public ArrayList getHistory(String no) {
         ArrayList list = new ArrayList();
        try {
            String getCase = "select * from case_details_info where vehicle_no = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(getCase);
            preparedStatement.setString(1, no);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
                if (!executeQuery.getString("case_status").equals(AppConstants.CLOSED) && !executeQuery.getString("case_status").equals(AppConstants.TO_CORT) && !executeQuery.getString("case_status").equals(AppConstants.SET_PENALTY)) {
                    CaseBean caseBean = new CaseBean();
                    caseBean.setSuspect_AddarNo(executeQuery.getString("suspect_adhaar_no"));
                    caseBean.setPhone(executeQuery.getString("suspect_phone"));
                    caseBean.setEmail(executeQuery.getString("email"));
                    caseBean.setAddress(executeQuery.getString("address"));
                    caseBean.setSuspect_Name(executeQuery.getString("name"));
                    caseBean.setVehicle_No(executeQuery.getString("vehicle_no"));
                    caseBean.setTime(executeQuery.getString("time"));
                    caseBean.setDate(executeQuery.getString("dates"));
                    caseBean.setLocation(executeQuery.getString("location"));
                    caseBean.setVictim_Adhaar_No(executeQuery.getString("victim_adhaar_no"));
                    caseBean.setStatus(executeQuery.getString("case_status"));
                    caseBean.setCase_id(String.valueOf(executeQuery.getInt("case_id")));
                    caseBean.setCase_type(executeQuery.getString("case_type"));
                    caseBean.setCase_Comands(executeQuery.getString("case_camands"));
                    list.add(caseBean);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
