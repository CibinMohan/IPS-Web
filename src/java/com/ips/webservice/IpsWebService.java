/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ips.webservice;

import com.ips.bean.CaseBean;
import com.ips.bean.LoginBean;
import com.ips.manager.LoginManager;
import com.ips.manager.ObjectConvertManager;
import com.ips.manager.WebServiceManager;
import com.ips.util.AppVariable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * 
 */
@WebService()
public class IpsWebService {

    /**
     * Web service operation Login
     */
    StringBuilder stringBuilder = new StringBuilder();
    ObjectInputStream objectInputStream = null;

    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        String checkLogin = "false";
        String type = "";
        try {
            LoginBean loginBean = new LoginBean();
            loginBean.setPassword(password);
            loginBean.setUsername(username);
            LoginManager loginManager = new LoginManager();
            type = loginManager.checkLogin(loginBean);
            if (type.equals("police")) {
                checkLogin = "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(IpsWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checkLogin;
    }

    /**
     * Web service operation search Vechile No
     */
    @WebMethod(operationName = "SearchVehicleNo")
    public String SearchVehicleNo(@WebParam(name = "value") String value) {

        WebServiceManager manager = new WebServiceManager();
        System.out.println("value :" + value);
        ArrayList<CaseBean> searchCaseVehicleNo = manager.getSearchCaseVehicleNo(value);
        String respons = new ObjectConvertManager().getString(searchCaseVehicleNo);
        return respons;

    }

    /**
     * Web service operation search Aadhaar No
     */
    @WebMethod(operationName = "searchAadhaarNo")
    public String searchAadhaarNo(@WebParam(name = "value") String value) {
        WebServiceManager manager = new WebServiceManager();
        System.out.println("value :" + value);
        ArrayList<CaseBean> searchCaseAadhaarNo = manager.getSearchCaseAadhaarNo(value);
        String respons = new ObjectConvertManager().getString(searchCaseAadhaarNo);
        return respons;

    }

    /**
     * Web service operation get All cases
     */
    @WebMethod(operationName = "getAllCases")
    public String getAllCases(@WebParam(name = "username") String username) {
        WebServiceManager manager = new WebServiceManager();
        System.out.println("value :" + username);
        ArrayList<CaseBean> allCase = manager.getAllCase(username);
        String respons = new ObjectConvertManager().getString(allCase);
        return respons;
    }

    /**
     * Web service operation Add New Case
     */
    @WebMethod(operationName = "AddNewCase")
    public String AddNewCase(@WebParam(name = "object") String object) {

        CaseBean caseBean = null;
        String addNewCase = "false";
        ObjectConvertManager objectConvertManager = new ObjectConvertManager();

        // get String
        System.out.println("String   :" + object);
        if (!object.equals("ok")) {
            stringBuilder.append(object);
        } else {
            try {

                byte[] aByte = new ObjectConvertManager().getByte(stringBuilder.toString());

                File file = new File(AppVariable.Filefolder_path + File.separator + "Temp");
                if (!file.exists()) {
                    file.mkdir();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsoluteFile() + File.separator + "temp.txt");
                fileOutputStream.write(aByte);

                FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile() + File.separator + "temp.txt");
                byte[] bs = new byte[fileInputStream.available()];
                fileInputStream.read(bs);
                String byteToString = objectConvertManager.getByteToString(aByte);
                Object readObject = objectConvertManager.getObject(byteToString);

                if (readObject instanceof CaseBean) {                                        // check redinig object is instanceof CaseBean

                    caseBean = (CaseBean) readObject;
                    caseBean.setStatus("case");
                    caseBean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                    caseBean.setTime(new SimpleDateFormat("hh:mm:ss").format(new Date()));
                    addNewCase = new WebServiceManager().AddNewCase(caseBean);
                    stringBuilder.delete(0, stringBuilder.length());
//                        new ObjectConvertManager().saveImageAndVidio(caseBean);
//                        if (AddNewCase.equals("ok")) {                                           // check the registered case vehicle losted
//                            String smsMessage = "Your Vechicle number" + caseBean.getVehicle_No() + "has been found.Please contact nearest police station with Id card .";
//                            new SMSSending().sendSMS(smsMessage, caseBean.getPhone());
//                        }
                }
                // }
            } catch (IOException ex) {
                Logger.getLogger(IpsWebService.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
            }
        }

        return addNewCase;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AddImage")
    public String AddImage(@WebParam(name = "id") String id, @WebParam(name = "image") String image) {


        String respones = "false";

        if (!image.equals("ok")) {
            if (!image.equals("")) {
                stringBuilder.append(image);
            } else {
                System.out.println("image is null");
            }
        } else {
            try {
                byte[] aByte = new ObjectConvertManager().getByte(stringBuilder.toString());
                File file = new File(AppVariable.Filefolder_path + File.separator + "Temp");
                if (!file.exists()) {
                    file.mkdir();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsoluteFile() + File.separator + id + ".jpg");
                fileOutputStream.write(aByte);
                FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile() + File.separator + id + ".jpg");
                byte[] bs = new byte[fileInputStream.available()];
                fileInputStream.read(bs);
                respones = new WebServiceManager().addImage(bs, id);
                stringBuilder.delete(0, stringBuilder.length());
            } catch (IOException ex) {
                Logger.getLogger(IpsWebService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return respones;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addVideo")
    public String addVideo(@WebParam(name = "video") String video, @WebParam(name = "id") String id) {

        String respones = "false";
        if (!video.equals("ok")) {
            if (!video.equals("")) {
                System.out.println("Video :" + video);
                stringBuilder.append(video);
            } else {
                System.out.println("image is null");
            }
        } else {
            try {
                byte[] aByte = new ObjectConvertManager().getByte(stringBuilder.toString());
                File file = new File(AppVariable.Filefolder_path + File.separator + "Temp");
                if (!file.exists()) {
                    file.mkdir();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsoluteFile() + File.separator + id + ".mp4");
                fileOutputStream.write(aByte);
                FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile() + File.separator + id + ".mp4");
                byte[] bs = new byte[fileInputStream.available()];
                fileInputStream.read(bs);
                respones = new WebServiceManager().addImage(bs, id);
                respones = new WebServiceManager().checkLostVechile(AppVariable.vechile_No);
                stringBuilder.delete(0, stringBuilder.length());

            } catch (IOException ex) {
                Logger.getLogger(IpsWebService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return respones;
    }
}
