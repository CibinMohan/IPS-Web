/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ips.servlet;

import com.ips.bean.CaseBean;
import com.ips.manager.CaseManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 
 */
public class CaseRegistrationServlet extends HttpServlet {
   
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
            caseBean.setSuspect_Name(request.getParameter("name"));
            caseBean.setVehicle_No(request.getParameter("number"));
            caseBean.setEmail(request.getParameter("email"));
            caseBean.setPhone(request.getParameter("phone"));
            caseBean.setTime(new SimpleDateFormat("hh:mm:ss").format(new Date()));
            caseBean.setDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
            int number = new CaseManager().registerCase(caseBean);
            if(number > 0) {
                response.sendRedirect("CaseRegistration.jsp?status=true");
            } else {
                response.sendRedirect("CaseRegistration.jsp?status=false");
            }
         
        } catch (SQLException ex) {
            Logger.getLogger(CaseRegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
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

}
