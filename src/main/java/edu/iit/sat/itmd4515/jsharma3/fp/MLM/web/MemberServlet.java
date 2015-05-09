/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.fp.MLM.web;

import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Customer;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Members;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.service.CustomerService;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.service.MembersService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jay
 */
@WebServlet(name = "MemberServlet", urlPatterns = {"/MemberServlet","/MemberServlet/"})
public class MemberServlet extends HttpServlet {

    @EJB
    private MembersService memberService;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MemberServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MemberServlet at " + request.getContextPath() + "</h1>");
             
            if (request.isUserInRole("member")) {
                
                Members me = memberService.findByUsername(request.getRemoteUser());
                out.println("<table border=1>");
                out.println("<tr><td><b>First Name</b></td><td><b>Last Name</b></h2></td><td><b>Email</b></td><td><b>Birthdate</b></td><td><b>Referance_Code</b></td></tr>");
                out.println("<tr><td>" + me.getFirstName() + "</td><td>" + me.getLastName() + "</td><td>" +me.getEmail() + "</td><td>" + me.getBirthDate() + "</td><td>"+ me.getReferance_code()+"</td></tr>");
                out.println("</table>");
               
               
               
            }

            out.println("<a href=\"" + request.getContextPath() + "/Logout\">Logout</a>");

            out.println("</body>");
            out.println("</html>");
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
