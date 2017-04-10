/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ips.manager;

import com.ips.bean.CaseBean;
import com.ips.util.AppVariable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * 
 */
public class ObjectConvertManager {

    public String getString(Object obj) {
        String str = "";
        byte[] data = null;
        try {
            ObjectOutputStream oos = null;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();
            bos.close();
            data = bos.toByteArray();
            BASE64Encoder aSE64Encoder = new BASE64Encoder();
            str = aSE64Encoder.encodeBuffer(data);

        } catch (IOException ex) {
            Logger.getLogger(ObjectConvertManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }

    public Object getObject(String value) {
        Object placeObject = null;
        try {
            ObjectInputStream inputStream = null;
            String response = value;
            BASE64Decoder aSE64Decoder = new BASE64Decoder();
            byte[] decode = aSE64Decoder.decodeBuffer(value);
            ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(decode);
            inputStream = new ObjectInputStream(arrayInputStream);
            placeObject = inputStream.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObjectConvertManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ObjectConvertManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return placeObject;
    }

    public void saveImageAndVidio(CaseBean caseBean) {
        try {
            FileOutputStream fileOutputStream = null;
            File file = new File(AppVariable.Filefolder_path + caseBean.getVehicle_No() + "video.mp4");
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(caseBean.getVideo());
            File file1 = new File(AppVariable.Filefolder_path + caseBean.getVehicle_No() + "image.jpg");
            fileOutputStream = new FileOutputStream(file1);
            fileOutputStream.write(caseBean.getImage());
        } catch (IOException ex) {
            Logger.getLogger(ObjectConvertManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public byte[] getByte(String value) throws IOException {

            BASE64Decoder aSE64Decoder = new BASE64Decoder();
            byte[] decode = aSE64Decoder.decodeBuffer(value);
           return decode;

    }
     public String getByteToString(byte[] bs) {
        byte[] beanBytes = bs;
        BASE64Encoder encoder = new BASE64Encoder();
        String result = encoder.encode(beanBytes);
        return result;
    }
}
