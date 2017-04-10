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
public class CaseManager {

    Connection connection = null;

    public CaseManager() {
        connection = new DbConnection().getConnection();
    }

    // Register new Case
    public int registerNewCase(CaseBean caseBean) {
        int id = 0;
        int number = 0;
        try {
            String getId = "select Police_id from police_info where username = ?";
            PreparedStatement statement = connection.prepareStatement(getId);
            statement.setString(1, caseBean.getUsername());
            ResultSet executeQuery = statement.executeQuery();
            if (executeQuery.next()) {
                id = executeQuery.getInt("police_id");
            }
            String addCase = "insert into case_details_info(police_id,name,suspect_adhaar_no,suspect_phone,email,address,vehicle_no,time,dates,location,victim_adhaar_no,case_status,case_camands,Case_type) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(addCase);
            preparedStatement.setInt(1, id);
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
        } catch (SQLException ex) {
            Logger.getLogger(CaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return number;

    }
    // get registered case view for admin

    public ArrayList getAllCase() {
        ArrayList list = new ArrayList();
        try {
            String getCase = "select * from case_details_info";
            PreparedStatement preparedStatement = connection.prepareStatement(getCase);
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

    //Admin serch case in case id
    public ArrayList getSearchCase(String value) {
        ArrayList list = new ArrayList();
        try {
            String getCase = "select * from case_details_info where case_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(getCase);
            preparedStatement.setString(1, value);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
                if (!executeQuery.getString("case_status").equals(AppConstants.CLOSED) && !executeQuery.getString("case_status").equals(AppConstants.TO_CORT) && !executeQuery.getString("case_status").equals(AppConstants.SET_PENALTY)) {
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
            Logger.getLogger(CaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    // set penalty admin & court

    public int setPanalty(CaseBean caseBean) {
        int number = 0;
        RegistrationBean bean = new RegistrationBean();
        try {
            String detData = "select * from case_details_info where case_id = ? ";
            PreparedStatement statement = connection.prepareStatement(detData);
            statement.setInt(1, Integer.parseInt(caseBean.getCase_id()));
            ResultSet executeQuery = statement.executeQuery();
            if (executeQuery.next()) {
                bean.setEmail(executeQuery.getString("email"));
                bean.setPhone(executeQuery.getString("suspect_phone"));
                bean.setPassword("send");
            }

            String setPanalty = "insert into case_penalty_info (case_id,penaity_amt,penalty_status,last_date) values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(setPanalty);
            preparedStatement.setInt(1, Integer.parseInt(caseBean.getCase_id()));
            preparedStatement.setString(2, caseBean.getPanalty_atm());
            preparedStatement.setString(3, caseBean.getPanalty_status());
            preparedStatement.setString(4, caseBean.getLastDate());
            int executeUpdate = preparedStatement.executeUpdate();
            if (executeUpdate > 0) {
                String setStatus = "update case_details_info set case_status = ? where case_id = ?";
                PreparedStatement ps = connection.prepareStatement(setStatus);
                ps.setString(1, AppConstants.SET_PENALTY);
                ps.setInt(2, Integer.parseInt(caseBean.getCase_id()));
                number = ps.executeUpdate();
            }

            if (number > 0) {
                // send Email
                String sub = "You have set Penanalty in  IPS";
                String message = "Please note down the following details for future references\n"
                        + "Case ID : " + caseBean.getCase_id() + "\n" + "Penalty Amount : Rs." + caseBean.getPanalty_atm()
                        + "\n" + "Last Date of pay : " + caseBean.getLastDate();
                String smsManager = "Please note down the following details for future references"
                        + "Case_Id : " + caseBean.getCase_id() + "Penalty Amount : Rs. " + caseBean.getPanalty_atm()
                        + "Last Date of pay : " + caseBean.getLastDate();
                MailSending mailSending = new MailSending(bean, message, sub);
                new Thread(mailSending).start();

                // send S MS
                SMSSending mSSending = new SMSSending();
                mSSending.sendSMS(smsManager, bean.getPhone());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return number;
    }
    // admin case forwerd to court

    public int caseForwardToCourt(int parseInt, String email) {
        int number = 0;
        RegistrationBean bean = new RegistrationBean();
        bean.setEmail(email);
        bean.setPassword("send");
        try {
            String detData = "select * from case_details_info where case_id = ? ";
            PreparedStatement statement = connection.prepareStatement(detData);
            statement.setInt(1, parseInt);
            ResultSet executeQuery = statement.executeQuery();
            if (executeQuery.next()) {
                bean.setPhone(executeQuery.getString("suspect_phone"));
            }
            String status = "update case_details_info set case_status = ? where case_id = ? ";
            PreparedStatement ps = connection.prepareStatement(status);
            ps.setString(1, AppConstants.TO_CORT);
            ps.setInt(2, parseInt);
            number = ps.executeUpdate();
            //MailSend to people
            if (number > 0) {
                // send Email
                String sub = "Your case reference to Court  in  IPS";
                String message = "Please note down the following details for future references\n"
                        + "Case_Id : " + parseInt;
                  String smsMessage = "Please note down the following details for future references"
                        + "Case_Id : " + parseInt;
                MailSending mailSending = new MailSending(bean, message, sub);
                new Thread(mailSending).start();
                // send S MS
                SMSSending mSSending = new SMSSending();
                mSSending.sendSMS(smsMessage, bean.getPhone());

            }
        } catch (SQLException ex) {
            Logger.getLogger(CaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return number;
    }
    // get penalty seted case

    public ArrayList getPenaltyCases() {
        ArrayList list = new ArrayList();
        try {
            String getCase = "select * from case_details_info where case_status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(getCase);
            preparedStatement.setString(1, AppConstants.SET_PENALTY);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
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
                statement.setString(1, caseBean.getCase_id());
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
        } catch (SQLException ex) {
            Logger.getLogger(CaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public CaseBean getPayPenalty(String id) {
        CaseBean caseBean = new CaseBean();
        try {
            String getCase = "select * from case_details_info where case_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(getCase);
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet executeQuery = preparedStatement.executeQuery();
            String penalty = "select * from case_penalty_info where case_id = ?";
            PreparedStatement statement = connection.prepareStatement(penalty);
            statement.setInt(1, Integer.parseInt(id));
            ResultSet executeQuery1 = statement.executeQuery();
            if (executeQuery.next() && executeQuery1.next()) {
                caseBean.setSuspect_Name(executeQuery.getString("name"));
                caseBean.setCase_id(executeQuery.getString("case_id"));
                caseBean.setEmail(executeQuery.getString("email"));

                caseBean.setPanalty_atm(executeQuery1.getString("penaity_amt"));
                caseBean.setPanalty_status(executeQuery1.getString("penalty_status"));
                caseBean.setLastDate(executeQuery1.getString("last_date"));
                caseBean.setPenalty_id(executeQuery1.getString("penalty_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return caseBean;
    }
    // pay penalty court

    public int payPenalty(CaseBean caseBean) {
        int number = 0;
        String phone = "";
        try {


            String detData = "select * from case_details_info where case_id = ? ";
            PreparedStatement statement = connection.prepareStatement(detData);
            statement.setInt(1, Integer.parseInt(caseBean.getCase_id()));
            ResultSet executeQuery = statement.executeQuery();
            if (executeQuery.next()) {
                phone = executeQuery.getString("suspect_phone");
            }


            String status = "update case_details_info set case_status = ? where case_id = ? ";
            PreparedStatement ps = connection.prepareStatement(status);
            ps.setString(1, AppConstants.CLOSED);
            ps.setInt(2, Integer.parseInt(caseBean.getCase_id()));
            number = ps.executeUpdate();
            if (number > 0) {

                String delete = "delete from case_penalty_info where case_id = ?";
                PreparedStatement preparedStatement1 = connection.prepareStatement(delete);
                preparedStatement1.setString(1, caseBean.getCase_id());
                int executeUpdate = preparedStatement1.executeUpdate();


                // send Email
                String sub = "You have Successfully pay Penanalty in  IPS";
                String message = "Thank you" + caseBean.getSuspect_Name() + "\n Please note down the following details for future references\n"
                        + "Case ID : " + caseBean.getCase_id() + "\n" + "Penalty Amount : " + caseBean.getPanalty_atm()
                        + "\n You have Successfully paid penalty of IPS";

                String smsManager = "Thank you    " + caseBean.getSuspect_Name() + "Please note down the following details for future references"
                        + "Case ID:" + caseBean.getCase_id() + "penalty Amount:" + caseBean.getPanalty_atm()
                        + "You have Successfully paid penalty of IPS ";
                RegistrationBean bean = new RegistrationBean();
                bean.setEmail(caseBean.getEmail());
                bean.setPassword("send");
                MailSending mailSending = new MailSending(bean, message, sub);
                new Thread(mailSending).start();


                // send S MS
                SMSSending mSSending = new SMSSending();
                mSSending.sendSMS(smsManager, phone);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return number;

    }
    // get All cases, under court

    public ArrayList getForwardCase() {
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
        } catch (SQLException ex) {
            Logger.getLogger(CaseManager.class.getName()).log(Level.SEVERE, null, ex);
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
                if (!executeQuery.getString("case_status").equals(AppConstants.CLOSED) && !executeQuery.getString("case_status").equals(AppConstants.TO_CORT) && !executeQuery.getString("case_status").equals(AppConstants.SET_PENALTY)) {
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
            Logger.getLogger(CaseManager.class.getName()).log(Level.SEVERE, null, ex);
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
                if (!executeQuery.getString("case_status").equals(AppConstants.CLOSED) && !executeQuery.getString("case_status").equals(AppConstants.TO_CORT) && !executeQuery.getString("case_status").equals(AppConstants.SET_PENALTY)) {
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
            Logger.getLogger(CaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    // day calculation for set repenalty
    private String getDateDifferance(String lastDate) {
        String dateDiff = "";
        long diffSeconds = 0;
        long diffMinutes = 0;
        long diffHours = 0;
        long diffDays = 0;
        try {
            String str = lastDate;
            //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
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

    // set repenalty
    public int reSetPenalty(CaseBean caseBean) {
        int number = 0;
        try {
            String resetPenalty = "update case_penalty_info set penaity_amt = ?,penalty_status = ?,last_date = ? where case_id = ?  ";
            PreparedStatement preparedStatement = connection.prepareStatement(resetPenalty);
            preparedStatement.setString(1, caseBean.getPanalty_atm());
            preparedStatement.setString(2, caseBean.getPanalty_status());
            preparedStatement.setString(3, caseBean.getLastDate());
            preparedStatement.setString(4, caseBean.getCase_id());
            number = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return number;
    }

    // pay penalty citizen online
    public int payPenaltyCitizen(CaseBean caseBean) {
        int number = 0;
        String email = "";
        String phone = "";
        RegistrationBean bean = new RegistrationBean();
        try {
            String cheack = "select * from case_details_info where case_id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(cheack);
            preparedStatement.setString(1, caseBean.getCase_id());
            ResultSet executeQuery = preparedStatement.executeQuery();
            if (executeQuery.next()) {
                email = executeQuery.getString("email");
                phone = executeQuery.getString("suspect_phone");
                if (executeQuery.getString("case_status").equals("closed")) {
                    number = -1;
                } else {
                    String pay = "update case_details_info set case_status = ? where case_id = ?  ";
                    PreparedStatement statement = connection.prepareStatement(pay);
                    statement.setString(1, AppConstants.CLOSED);
                    statement.setString(2, caseBean.getCase_id());
                    number = statement.executeUpdate();
                    if (number > 0) {
                        String delete = "delete from case_penalty_info where case_id = ?";
                        PreparedStatement preparedStatement1 = connection.prepareStatement(delete);
                        preparedStatement1.setString(1, caseBean.getCase_id());
                        int executeUpdate = preparedStatement1.executeUpdate();
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        // send Email
        String sub = "You have Successfully pay Penanalty in  IPS";
        String message = "Thank you" + caseBean.getSuspect_Name() + "\n Please note down the following details for future references\n"
                + "Case ID:" + caseBean.getCase_id() + "\n"
                + "\n You have Successfully paid penalty of IPS ";

        String smsMessage = "Thank you" + caseBean.getSuspect_Name() + " Please note down the following details for future references"
                + "Case_Id:" + caseBean.getCase_id()
                + " You have Successfully paid penalty of IPS ";
        bean.setEmail(email);
        bean.setPassword("send");
        MailSending mailSending = new MailSending(bean, message, sub);
        new Thread(mailSending).start();

        // send SMS
        SMSSending mSSending = new SMSSending();
        mSSending.sendSMS(smsMessage, phone);

        return number;
    }

    public int registerCase(CaseBean caseBean) throws SQLException {
        int number = 0;
        String addCade = " insert into lost_vehicle_info (vehicle_no,owner_name,email,phone,case_date,time) value(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addCade);
        preparedStatement.setString(1, caseBean.getVehicle_No());
        preparedStatement.setString(2, caseBean.getSuspect_Name());
        preparedStatement.setString(3, caseBean.getEmail());
        preparedStatement.setString(4, caseBean.getPhone());
        preparedStatement.setString(5, caseBean.getDate());
        preparedStatement.setString(6, caseBean.getTime());
        number = preparedStatement.executeUpdate();
        return number;
    }
}
