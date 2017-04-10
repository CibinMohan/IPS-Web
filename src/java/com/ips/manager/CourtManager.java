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
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class CourtManager {

    Connection connection = null;

    public CourtManager() {
        connection = new DbConnection().getConnection();
    }
     // get All cases under Court
    public ArrayList getCase() {
        ArrayList list = new ArrayList();
        try {
            String getCase = "select * from case_details_info where case_status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(getCase);
            preparedStatement.setString(1, AppConstants.TO_CORT);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
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
                String str[] = splitString(caseBean.getLocation());
                caseBean.setLat(str[0]);
                caseBean.setLog(str[1]);
                caseBean.setVictim_Adhaar_No(executeQuery.getString("victim_adhaar_no"));
                caseBean.setStatus(executeQuery.getString("case_status"));
                caseBean.setCase_id(String.valueOf(executeQuery.getInt("case_id")));
                caseBean.setCase_type(executeQuery.getString("case_type"));
                caseBean.setCase_Comands(executeQuery.getString("case_camands"));
                list.add(caseBean);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CourtManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList getSearchCase(String value) {
        ArrayList list = new ArrayList();
        try {
            String getCase = "select * from case_details_info where case_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(getCase);
            preparedStatement.setInt(1, Integer.parseInt(value));
            ResultSet executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
                CaseBean caseBean = new CaseBean();
                caseBean.setSuspect_AddarNo(executeQuery.getString("suspect_adhaar_no"));
                caseBean.setPhone(executeQuery.getString("suspect_phone"));
                caseBean.setEmail(executeQuery.getString("email"));
                caseBean.setSuspect_Name(executeQuery.getString("name"));
                caseBean.setAddress(executeQuery.getString("address"));
                caseBean.setVehicle_No(executeQuery.getString("vehicle_no"));
                caseBean.setTime(executeQuery.getString("time"));
                caseBean.setDate(executeQuery.getString("dates"));
                caseBean.setLocation(executeQuery.getString("location"));
                String str[] = splitString(caseBean.getLocation());
                caseBean.setLat(str[0]);
                caseBean.setLog(str[1]);
                caseBean.setVictim_Adhaar_No(executeQuery.getString("victim_adhaar_no"));
                caseBean.setStatus(executeQuery.getString("case_status"));
                caseBean.setCase_id(String.valueOf(executeQuery.getInt("case_id")));
                caseBean.setCase_type(executeQuery.getString("case_type"));
                caseBean.setCase_Comands(executeQuery.getString("case_camands"));
                list.add(caseBean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourtManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
         // view case
    public CaseBean getOneCase(String value) {
        CaseBean caseBean = new CaseBean();
        try {
            String getCase = "select * from case_details_info where case_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(getCase);
            preparedStatement.setInt(1, Integer.parseInt(value));
            ResultSet executeQuery = preparedStatement.executeQuery();
//            // new Code
//            String getFile = "Select * from case_file_info where case_id = ?";
//            PreparedStatement statement = connection.prepareStatement(getFile);
//            statement.setInt(1, Integer.parseInt(value));
//            ResultSet executeQuery1 = statement.executeQuery();
//            //ended
            if (executeQuery.next()) {
//            if (executeQuery.next() && executeQuery1.next()) {
//                caseBean.setFile_id(executeQuery1.getString("case_file_id"));
//                caseBean.setImage(executeQuery1.getBytes("case_file"));
                caseBean.setSuspect_AddarNo(executeQuery.getString("suspect_adhaar_no"));
                caseBean.setPhone(executeQuery.getString("suspect_phone"));
                caseBean.setEmail(executeQuery.getString("email"));
                caseBean.setSuspect_Name(executeQuery.getString("name"));
                caseBean.setAddress(executeQuery.getString("address"));
                caseBean.setVehicle_No(executeQuery.getString("vehicle_no"));
                caseBean.setTime(executeQuery.getString("time"));
                caseBean.setDate(executeQuery.getString("dates"));
                caseBean.setLocation(executeQuery.getString("location"));
                String str[] = splitString(caseBean.getLocation());
                caseBean.setLat(str[0]);
                caseBean.setLog(str[1]);
                caseBean.setVictim_Adhaar_No(executeQuery.getString("victim_adhaar_no"));
                caseBean.setStatus(executeQuery.getString("case_status"));
                caseBean.setCase_id(String.valueOf(executeQuery.getInt("case_id")));
                caseBean.setCase_type(executeQuery.getString("case_type"));
                caseBean.setCase_Comands(executeQuery.getString("case_camands"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CourtManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return caseBean;
    }
      // get court Info
    public ArrayList getcourt() {
        ArrayList list = new ArrayList();
        try {
            String getCourt = "select * from court_info";
            PreparedStatement preparedStatement = connection.prepareStatement(getCourt);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
                RegistrationBean registrationBean = new RegistrationBean();
                registrationBean.setName(executeQuery.getString("court_name"));
                registrationBean.setEmail(executeQuery.getString("email"));
                registrationBean.setPhone(executeQuery.getString("phone"));
                registrationBean.setUsername(executeQuery.getString("username"));
                registrationBean.setId(executeQuery.getString("court_id"));
                registrationBean.setAddress(executeQuery.getString("address"));
                list.add(registrationBean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourtManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     // get Police Info
    public ArrayList getPolice() {
        ArrayList list = new ArrayList();
        try {
            String getCourt = "select * from police_info";
            PreparedStatement preparedStatement = connection.prepareStatement(getCourt);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
                RegistrationBean registrationBean = new RegistrationBean();
                registrationBean.setName(executeQuery.getString("name"));
                registrationBean.setEmail(executeQuery.getString("email"));
                registrationBean.setPhone(executeQuery.getString("phone"));
                registrationBean.setUsername(executeQuery.getString("username"));
                registrationBean.setId(executeQuery.getString("police_id"));
                registrationBean.setAddress(executeQuery.getString("address"));
                list.add(registrationBean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourtManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

  // delete Court
    public int deteleCourt(int parseInt) {
        int number = 0;
        String username = "";
        try {
            String getusername = "select username from court_info where court_id = ?";
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
          // get values for editing
    public RegistrationBean EditCourtValue(int id) {
        RegistrationBean registrationBean = new RegistrationBean();
        try {
            String getCourt = "select * from court_info where court_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(getCourt);
            preparedStatement.setInt(1, id);
            ResultSet executeQuery = preparedStatement.executeQuery();
            if (executeQuery.next()) {
                registrationBean.setName(executeQuery.getString("court_name"));
                registrationBean.setEmail(executeQuery.getString("email"));
                registrationBean.setPhone(executeQuery.getString("phone"));
                registrationBean.setUsername(executeQuery.getString("username"));
                registrationBean.setId(executeQuery.getString("court_id"));
                registrationBean.setAddress(executeQuery.getString("address"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourtManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registrationBean;
    }
     // update Court Profile
    public int updateCourt(RegistrationBean bean) {
        int number = 0;
        try {
            String updateCourt = "update court_info set court_name = ?,email = ?,phone = ?,address = ? where username = ?  ";
            PreparedStatement preparedStatement = connection.prepareStatement(updateCourt);
            preparedStatement.setString(1, bean.getName());
            preparedStatement.setString(2, bean.getEmail());
            preparedStatement.setString(3, bean.getPhone());
            preparedStatement.setString(4, bean.getAddress());
            preparedStatement.setString(5, bean.getUsername());
            number = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourtManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return number;
    }

    private String[] splitString(String location) {
        int i = 0;
        String[] str = new String[2];
        StringTokenizer tokenizer = new StringTokenizer(location, ",");
        while (tokenizer.hasMoreTokens()) {
            str[i++] = tokenizer.nextToken();
        }
        return str;
    }

    // get history to court
    public ArrayList getHistoryToCourt(String no) {
           ArrayList list = new ArrayList();
        try {
            String getCase = "select * from case_details_info where vehicle_no = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(getCase);
            preparedStatement.setString(1, no);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
                if (executeQuery.getString("case_status").equals(AppConstants.TO_CORT)) {
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
