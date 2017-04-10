/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ips.manager;

import com.ips.bean.CaseBean;
import com.ips.db.DbConnection;
import com.ips.util.AppConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class SearchManager {

    Connection connection = null;

    public SearchManager() {
        connection = new DbConnection().getConnection();
    }
    //View Forward Case in Police

    public ArrayList getSearchCaseId(String value) {
        ArrayList list = new ArrayList();
        try {
            String getCase = "select * from case_details_info where case_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(getCase);
            preparedStatement.setString(1, value);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
                if (executeQuery.getString("case_status").equals(AppConstants.TO_CORT)) {
                    CaseBean caseBean = new CaseBean();
                    caseBean.setSuspect_AddarNo(executeQuery.getString("suspect_adhaar_no"));
                    caseBean.setPhone(executeQuery.getString("suspect_phone"));
                    caseBean.setEmail(executeQuery.getString("email"));
                    caseBean.setAddress(executeQuery.getString("address"));
                    caseBean.setVehicle_No(executeQuery.getString("vehicle_no"));
                    caseBean.setTime(executeQuery.getString("time"));
                    caseBean.setSuspect_Name(executeQuery.getString("name"));
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
            Logger.getLogger(SearchManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList getSearchCaseAddharNo(String value) {
        ArrayList list = new ArrayList();
        try {
            String getCase = "select * from case_details_info where suspect_adhaar_no = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(getCase);
            preparedStatement.setString(1, value);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
                if (executeQuery.getString("case_status").equals(AppConstants.TO_CORT)) {
                    CaseBean caseBean = new CaseBean();
                    caseBean.setSuspect_AddarNo(executeQuery.getString("suspect_adhaar_no"));
                    caseBean.setPhone(executeQuery.getString("suspect_phone"));
                    caseBean.setEmail(executeQuery.getString("email"));
                    caseBean.setAddress(executeQuery.getString("address"));
                    caseBean.setVehicle_No(executeQuery.getString("vehicle_no"));
                    caseBean.setTime(executeQuery.getString("time"));
                    caseBean.setSuspect_Name(executeQuery.getString("name"));
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
            Logger.getLogger(SearchManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList getSearchCasevechicleNO(String value) {
        ArrayList list = new ArrayList();
        try {
            String getCase = "select * from case_details_info where vehicle_no = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(getCase);
            preparedStatement.setString(1, value);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
                if (executeQuery.getString("case_status").equals(AppConstants.TO_CORT)) {
                    CaseBean caseBean = new CaseBean();
                    caseBean.setSuspect_AddarNo(executeQuery.getString("suspect_adhaar_no"));
                    caseBean.setPhone(executeQuery.getString("suspect_phone"));
                    caseBean.setEmail(executeQuery.getString("email"));
                    caseBean.setAddress(executeQuery.getString("address"));
                    caseBean.setVehicle_No(executeQuery.getString("vehicle_no"));
                    caseBean.setTime(executeQuery.getString("time"));
                    caseBean.setSuspect_Name(executeQuery.getString("name"));
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
            Logger.getLogger(SearchManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    // End  View Forward Case in Police
    // View Penalty Cases in Court
    public ArrayList getSearchPenaltyCaseId(String value) {
        ArrayList list = new ArrayList();
        try {
            String getCase = "select * from case_details_info where case_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(getCase);
            preparedStatement.setString(1, value);
            ResultSet executeQuery = preparedStatement.executeQuery();       

            while (executeQuery.next() ) {
                if (executeQuery.getString("case_status").equals(AppConstants.SET_PENALTY)) {
                    CaseBean caseBean = new CaseBean();
                    caseBean.setSuspect_AddarNo(executeQuery.getString("suspect_adhaar_no"));
                    caseBean.setPhone(executeQuery.getString("suspect_phone"));
                    caseBean.setEmail(executeQuery.getString("email"));
                    caseBean.setAddress(executeQuery.getString("address"));
                    caseBean.setVehicle_No(executeQuery.getString("vehicle_no"));
                    caseBean.setTime(executeQuery.getString("time"));
                    caseBean.setSuspect_Name(executeQuery.getString("name"));
                    caseBean.setDate(executeQuery.getString("dates"));
                    caseBean.setLocation(executeQuery.getString("location"));
                    caseBean.setVictim_Adhaar_No(executeQuery.getString("victim_adhaar_no"));
                    caseBean.setStatus(executeQuery.getString("case_status"));
                    caseBean.setCase_id(String.valueOf(executeQuery.getInt("case_id")));
                    caseBean.setCase_type(executeQuery.getString("case_type"));
                    caseBean.setCase_Comands(executeQuery.getString("case_camands"));

                    String date = "Select * from case_penalty_info where  case_id = ?";
                    PreparedStatement statement = connection.prepareStatement(date);
                    statement.setString(1, value);
                    ResultSet executeQuery1 = statement.executeQuery();


                    if (executeQuery1.next()) {
                        caseBean.setLastDate(executeQuery1.getString("last_date"));
                        caseBean.setPanalty_status(executeQuery1.getString("penalty_status"));
                        caseBean.setPenalty_id(executeQuery1.getString("penalty_id"));
                        caseBean.setPanalty_atm(executeQuery1.getString("penaity_amt"));
                        caseBean.setDate_diff(getDateDifferance(caseBean.getLastDate()));
                    }



                    list.add(caseBean);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList getSearchPenaltyCasesAddharNo(String value) {
        ArrayList list = new ArrayList();
        try {
            String getCase = "select * from case_details_info where suspect_adhaar_no = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(getCase);
            preparedStatement.setString(1, value);
            ResultSet executeQuery = preparedStatement.executeQuery();

            while (executeQuery.next()) {
                if (executeQuery.getString("case_status").equals(AppConstants.SET_PENALTY)) {
                    CaseBean caseBean = new CaseBean();
                    caseBean.setSuspect_AddarNo(executeQuery.getString("suspect_adhaar_no"));
                    caseBean.setPhone(executeQuery.getString("suspect_phone"));
                    caseBean.setEmail(executeQuery.getString("email"));
                    caseBean.setAddress(executeQuery.getString("address"));
                    caseBean.setVehicle_No(executeQuery.getString("vehicle_no"));
                    caseBean.setTime(executeQuery.getString("time"));
                    caseBean.setSuspect_Name(executeQuery.getString("name"));
                    caseBean.setDate(executeQuery.getString("dates"));
                    caseBean.setLocation(executeQuery.getString("location"));
                    caseBean.setVictim_Adhaar_No(executeQuery.getString("victim_adhaar_no"));
                    caseBean.setStatus(executeQuery.getString("case_status"));
                    caseBean.setCase_id(String.valueOf(executeQuery.getInt("case_id")));
                    caseBean.setCase_type(executeQuery.getString("case_type"));
                    caseBean.setCase_Comands(executeQuery.getString("case_camands"));

                    String date = "Select * from case_penalty_info where  case_id = ?";
                    PreparedStatement statement = connection.prepareStatement(date);
                    statement.setInt(1, Integer.parseInt(caseBean.getCase_id()));
                    ResultSet executeQuery1 = statement.executeQuery();
                    if (executeQuery1.next()) {
                        caseBean.setLastDate(executeQuery1.getString("last_date"));
                        caseBean.setPanalty_status(executeQuery1.getString("penalty_status"));
                        caseBean.setPenalty_id(executeQuery1.getString("penalty_id"));
                        caseBean.setPanalty_atm(executeQuery1.getString("penaity_amt"));
                        caseBean.setDate_diff(getDateDifferance(caseBean.getLastDate()));
                    }

                    list.add(caseBean);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList getSearchPenaltyCasesvechicleNO(String value) {
        ArrayList list = new ArrayList();
        try {
            String getCase = "select * from case_details_info where vehicle_no = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(getCase);
            preparedStatement.setString(1, value);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
                if (executeQuery.getString("case_status").equals(AppConstants.SET_PENALTY)) {
                    CaseBean caseBean = new CaseBean();
                    caseBean.setSuspect_AddarNo(executeQuery.getString("suspect_adhaar_no"));
                    caseBean.setPhone(executeQuery.getString("suspect_phone"));
                    caseBean.setEmail(executeQuery.getString("email"));
                    caseBean.setAddress(executeQuery.getString("address"));
                    caseBean.setVehicle_No(executeQuery.getString("vehicle_no"));
                    caseBean.setTime(executeQuery.getString("time"));
                    caseBean.setSuspect_Name(executeQuery.getString("name"));
                    caseBean.setDate(executeQuery.getString("dates"));
                    caseBean.setLocation(executeQuery.getString("location"));
                    caseBean.setVictim_Adhaar_No(executeQuery.getString("victim_adhaar_no"));
                    caseBean.setStatus(executeQuery.getString("case_status"));
                    caseBean.setCase_id(String.valueOf(executeQuery.getInt("case_id")));
                    caseBean.setCase_type(executeQuery.getString("case_type"));
                    caseBean.setCase_Comands(executeQuery.getString("case_camands"));

                    String date = "Select * from case_penalty_info where  case_id = ?";
                    PreparedStatement statement = connection.prepareStatement(date);
                    statement.setInt(1, Integer.parseInt(caseBean.getCase_id()));
                    ResultSet executeQuery1 = statement.executeQuery();

                    if (executeQuery1.next()) {
                        caseBean.setLastDate(executeQuery1.getString("last_date"));
                        caseBean.setPanalty_status(executeQuery1.getString("penalty_status"));
                        caseBean.setPenalty_id(executeQuery1.getString("penalty_id"));
                        caseBean.setPanalty_atm(executeQuery1.getString("penaity_amt"));
                        caseBean.setDate_diff(getDateDifferance(caseBean.getLastDate()));
                    }

                    list.add(caseBean);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    private String getDateDifferance(String lastDate) {
        String dateDiff = "";
        long diffSeconds = 0;
        long diffMinutes = 0;
        long diffHours = 0;
        long diffDays = 0;
        try {
            String str = lastDate;
            // SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String format = dateFormat.format(new Date());
            System.out.println("date : = " + format);
            Date d1 = dateFormat.parse(format);
            Date d2 = dateFormat.parse(str);
            long diff = d1.getTime() - d2.getTime();
            diffSeconds = diff / 1000 % 60;
            diffMinutes = diff / (60 * 1000) % 60;
            diffHours = diff / (60 * 60 * 1000) % 24;
            diffDays = diff / (24 * 60 * 60 * 1000);
            int year = (int) (diffDays / 365);
            int mothe = (int) (diffDays % 30);
            System.out.println(diffDays + " days, ");
            System.out.println(year + "year");
            System.out.println(mothe + "mothe");
        } catch (ParseException ex) {
            Logger.getLogger(CaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        dateDiff = String.valueOf(diffDays);
        return dateDiff;
    }
}
