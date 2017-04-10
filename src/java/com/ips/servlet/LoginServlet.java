
package com.ips.servlet;

import com.ips.bean.LoginBean;
import com.ips.manager.LoginManager;
import com.ips.util.AppConstants;
import com.ips.util.AppVariable;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * 
 */
public class LoginServlet extends HttpServlet {

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
            LoginBean loginBean = new LoginBean();
            loginBean.setPassword(request.getParameter("password"));
            loginBean.setUsername(request.getParameter("username"));
            LoginManager loginManager = new LoginManager();
            String type = loginManager.checkLogin(loginBean);
            System.out.println("   type  :" + type);
            loginBean.setUserType(type);
            HttpSession session = request.getSession();
            session.setAttribute(AppConstants.USER_BEAN, loginBean);
            AppVariable.Filefolder_path = getServletContext().getRealPath("Filefolder");        
            File file = new File(AppVariable.Filefolder_path);
            if (!file.exists()) {
                file.mkdirs();
            }
            System.out.println("path :" + AppVariable.Filefolder_path);
            if (type.equals("admin")) {
                response.sendRedirect("Police.jsp");
            } else if (type.equals("court")) {
                response.sendRedirect("Court.jsp");
            } else {
                response.sendRedirect("index.jsp?status=false");
                session.invalidate();
            }



        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
