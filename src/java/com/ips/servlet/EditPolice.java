/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ips.servlet;

import com.ips.bean.RegistrationBean;
import com.ips.manager.PoliceManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 *
 */
public class EditPolice extends HttpServlet {

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
            RegistrationBean policeBean = new RegistrationBean();
            policeBean.setName(request.getParameter("name"));
            policeBean.setUsername(request.getParameter("username"));
            policeBean.setEmail(request.getParameter("email"));
            policeBean.setPhone(request.getParameter("phone"));
            policeBean.setAddress(request.getParameter("address"));
            PoliceManager policeManager= new PoliceManager();
            int number = policeManager.updatePolice(policeBean);
            if(number > 0) {
                response.sendRedirect("viewPolice.jsp?status=updatepolice");
            } else {
                 response.sendRedirect("viewPolice.jsp?status=notupdatepolice");
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
}
