/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ips.manager;

import com.ips.bean.CaseBean;
import com.ips.db.DbConnection;
import com.ips.util.AppVariable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  
 * 
 */
public class WebServiceManager {

    private Connection connection = null;

    public WebServiceManager() {
        connection = new DbConnection().getConnection();
    }
    // View All case police

    public ArrayList<CaseBean> getAllCase(String username) {
        ArrayList<CaseBean> list = new ArrayList<CaseBean>();
        try {
            String id = "";
            String getPoliceId = "select * from police_info where username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(getPoliceId);
            preparedStatement.setString(1, username);
            ResultSet executeQuery = preparedStatement.executeQuery();
            if (executeQuery.next()) {
                id = executeQuery.getString("police_id");
            }
            String getCase = "select * from case_details_info where police_id = ? ";
            PreparedStatement statement = connection.prepareStatement(getCase);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CaseBean caseBean = new CaseBean();
                caseBean.setSuspect_AddarNo(resultSet.getString("suspect_adhaar_no"));
                caseBean.setPhone(resultSet.getString("suspect_phone"));
                caseBean.setEmail(resultSet.getString("email"));
                caseBean.setAddress(resultSet.getString("address"));
                caseBean.setSuspect_Name(resultSet.getString("name"));
                caseBean.setVehicle_No(resultSet.getString("vehicle_no"));
                caseBean.setTime(resultSet.getString("time"));
                caseBean.setDate(resultSet.getString("dates"));
                caseBean.setLocation(resultSet.getString("location"));
                caseBean.setVictim_Adhaar_No(resultSet.getString("victim_adhaar_no"));
                caseBean.setStatus(resultSet.getString("case_status"));
                caseBean.setCase_id(String.valueOf(resultSet.getInt("case_id")));
                caseBean.setCase_type(resultSet.getString("case_type"));
                caseBean.setCase_Comands(resultSet.getString("case_camands"));
                list.add(caseBean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebServiceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //police search Vehicle No

    public ArrayList<CaseBean> getSearchCaseVehicleNo(String value) {
        ArrayList<CaseBean> list = new ArrayList<CaseBean>();
        try {
            String getCase = "select * from case_details_info where vehicle_no = ?";
            PreparedStatement statement = connection.prepareStatement(getCase);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CaseBean caseBean = new CaseBean();
                caseBean.setSuspect_AddarNo(resultSet.getString("suspect_adhaar_no"));
                caseBean.setPhone(resultSet.getString("suspect_phone"));
                caseBean.setEmail(resultSet.getString("email"));
                caseBean.setAddress(resultSet.getString("address"));
                caseBean.setSuspect_Name(resultSet.getString("name"));
                caseBean.setVehicle_No(resultSet.getString("vehicle_no"));
                caseBean.setTime(resultSet.getString("time"));
                caseBean.setDate(resultSet.getString("dates"));
                caseBean.setLocation(resultSet.getString("location"));
                caseBean.setVictim_Adhaar_No(resultSet.getString("victim_adhaar_no"));
                caseBean.setStatus(resultSet.getString("case_status"));
                caseBean.setCase_id(String.valueOf(resultSet.getInt("case_id")));
                caseBean.setCase_type(resultSet.getString("case_type"));
                caseBean.setCase_Comands(resultSet.getString("case_camands"));
                list.add(caseBean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebServiceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    //police search Aadhaar No

    public ArrayList<CaseBean> getSearchCaseAadhaarNo(String value) {
        ArrayList<CaseBean> list = new ArrayList<CaseBean>();
        try {
            String getCase = "select * from case_details_info where suspect_adhaar_no = ?";
            PreparedStatement statement = connection.prepareStatement(getCase);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CaseBean caseBean = new CaseBean();
                caseBean.setSuspect_AddarNo(resultSet.getString("suspect_adhaar_no"));
                caseBean.setPhone(resultSet.getString("suspect_phone"));
                caseBean.setEmail(resultSet.getString("email"));
                caseBean.setAddress(resultSet.getString("address"));
                caseBean.setSuspect_Name(resultSet.getString("name"));
                caseBean.setVehicle_No(resultSet.getString("vehicle_no"));
                caseBean.setTime(resultSet.getString("time"));
                caseBean.setDate(resultSet.getString("dates"));
                caseBean.setLocation(resultSet.getString("location"));
                caseBean.setVictim_Adhaar_No(resultSet.getString("victim_adhaar_no"));
                caseBean.setStatus(resultSet.getString("case_status"));
                caseBean.setCase_id(String.valueOf(resultSet.getInt("case_id")));
                caseBean.setCase_type(resultSet.getString("case_type"));
                caseBean.setCase_Comands(resultSet.getString("case_camands"));
                list.add(caseBean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebServiceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public String AddNewCase(CaseBean caseBean) {
        int number = 0;
        String id = "";
        int caseId = 0;
        int setFileNumber = 0;
        String respones = "false";
        StringBuilder builder = new StringBuilder();
        try {
            String getPoliceId = "select * from police_info where username = ?";
            PreparedStatement statement = connection.prepareStatement(getPoliceId);
            statement.setString(1, caseBean.getUsername());
            ResultSet executeQuery = statement.executeQuery();
            if (executeQuery.next()) {
                id = executeQuery.getString("police_id");
            }
            String addCase = "insert into case_details_info(police_id,name,suspect_adhaar_no,suspect_phone,email,address,vehicle_no,time,dates,location,victim_adhaar_no,case_status,case_camands,Case_type) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(addCase, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setString(2, caseBean.getSuspect_Name());
            preparedStatement.setString(3, caseBean.getSuspect_AddarNo());
            preparedStatement.setString(4, caseBean.getPhone());
            preparedStatement.setString(5, caseBean.getEmail());
            preparedStatement.setString(6, caseBean.getAddress());
            preparedStatement.setString(7, caseBean.getVehicle_No());
            preparedStatement.setString(8, caseBean.getTime());
            preparedStatement.setString(9, caseBean.getDate());
            preparedStatement.setString(10, caseBean.getLocation());
            preparedStatement.setString(11, caseBean.getVictim_Adhaar_No());
            preparedStatement.setString(12, caseBean.getStatus());
            preparedStatement.setString(13, caseBean.getCase_Comands());
            preparedStatement.setString(14, caseBean.getCase_type());
            number = preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys != null && generatedKeys.next()) {
                caseId = generatedKeys.getInt(1);
                System.out.println("Caseid :" + caseId);
                respones = "true";
                builder.append(respones);
                builder.append(",");
                builder.append(String.valueOf(caseId));
            }
            AppVariable.Case_id = String.valueOf(caseId);
            AppVariable.vechile_No = caseBean.getVehicle_No();
//            if(number > 0) {
//            String insertfile = "insert into case_file_info (case_id,case_file) value(?,?)";
//            PreparedStatement ps = connection.prepareStatement(insertfile);
//            ps.setInt(1, caseId);
//            ps.setString(2, String.valueOf(caseBean.getImage()));
//            ps.executeUpdate();
//
//            ps.setInt(1, caseId);
//            ps.setString(2, String.valueOf(caseBean.getVideo()));
//            setFileNumber = ps.executeUpdate();
//            respones = "true";
//
//            }
//            if (setFileNumber > 0) {
//                String checkVehicle = "select * from lost_vehicle_info where vehicle_no = ?";
//                PreparedStatement ps = connection.prepareStatement(checkVehicle);
//                ps.setString(1, caseBean.getVehicle_No());
//                ResultSet executeQuery1 = ps.executeQuery();
//                if (executeQuery1.next()) {
//                    respones = "ok";
//                    builder.append(respones);
//                    builder.append(",");
//                    builder.append(String.valueOf(caseId));
//                }
//
//            }

        } catch (SQLException ex) {
            Logger.getLogger(WebServiceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return builder.toString();
    }

    public String addImage(byte[] bs, String id) {
        String respons = "false";
        try {
            String insertfile = "insert into case_file_info (case_id,case_file) value(?,?)";
            PreparedStatement ps = connection.prepareStatement(insertfile);
            ps.setInt(1, Integer.parseInt(id));
            ps.setString(2, String.valueOf(bs));
            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                respons = "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebServiceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respons;
    }

    public String checkLostVechile(String vechile_No) {
        String respons = "true";

        try {
            String checkVehicle = "select * from lost_vehicle_info where vehicle_no = ?";
            PreparedStatement ps = connection.prepareStatement(checkVehicle);
            ps.setString(1, vechile_No);
            ResultSet executeQuery1 = ps.executeQuery();
            if (executeQuery1.next()) {
                respons = "ok";
                String smsMessage = "Your Vechicle number" + AppVariable.vechile_No + "has been found.Please contact nearest police station with Id card .";
                new SMSSending().sendSMS(smsMessage, executeQuery1.getString("phone"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(WebServiceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respons;
    }
}
