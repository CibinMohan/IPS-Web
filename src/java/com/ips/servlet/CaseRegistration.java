/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ips.servlet;

import com.ips.bean.CaseBean;
import com.ips.bean.LoginBean;
import com.ips.manager.CaseManager;
import com.ips.util.AppConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.Session;

/**
 *
 * 
 */
public class CaseRegistration extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            CaseBean caseBean = new CaseBean();
            caseBean.setUsername(request.getParameter("username"));
            caseBean.setEmail(request.getParameter("email"));
            caseBean.setLocation(request.getParameter("location"));
            caseBean.setPhone(request.getParameter("phone"));
            caseBean.setSuspect_AddarNo(request.getParameter("adhaar"));
            caseBean.setSuspect_Name(request.getParameter("name"));
            caseBean.setVehicle_No(request.getParameter("vhicle"));
            caseBean.setVictim_Adhaar_No(request.getParameter("victimAdhaar"));
            caseBean.setAddress(request.getParameter("address"));//can not be nuull;
            // caseBean.setStatus(request.getParameter("status"));
            caseBean.setCase_Comands("hello");
            caseBean.setCase_type("hai");
            caseBean.setStatus("case");
            caseBean.setDate(getDate());
            caseBean.setTime(getTime());
            CaseManager caseManager = new CaseManager();
            int number = caseManager.registerNewCase(caseBean);
            if (number > 0) {
                response.sendRedirect("AddNewCase.jsp?status=true");
            } else {
                response.sendRedirect("AddNewCase.jsp?status=false");
            }


        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String getTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        return dateFormat.format(new Date());
    }

    private String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }
}
