/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Plamen
 */
@WebServlet(urlPatterns = {"/userCheck"})
public class userCheck extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String user = request.getParameter("user");
            String pwd = request.getParameter("pwd");
            Connection conn = null;
            String url = "jdbc:mysql://localhost:3306/";
            String dbName = "login";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String password = "root1";
            try {
                Class.forName(driver).newInstance();
                conn = DriverManager.getConnection(url + dbName, userName, password);
                System.out.println("Database connected.");
 
//                Statement st = conn.createStatement();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM  login where uname=? and pwd=?");
                pst.setString(1, user);
                pst.setString(2, pwd);
//                String query = "SELECT * FROM  login where uname='"+user+"' and pwd='"+pwd+"'";
//                out.println("Query : " + query);
//                System.out.printf(query);
                ResultSet res = pst.executeQuery();
                out.println("Secure entry");
                out.println("Results");
                
                while (res.next()) {
                    String s = res.getString("uname");
                    out.println("\t\t" + s);
                    
                }
                System.out.println("Went through.");
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            out.close();
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
