/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management_mobile.Controller;

import com.management_mobile.DAO.DAO_Manager;
import com.management_mobile.Model.Account;
import com.management_mobile.Model.ChucVu;
import com.management_mobile.Model.Manager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
@WebServlet(name = "UpdateManagerControl", urlPatterns = {"/updatemanager"})
public class UpdateManagerControl extends HttpServlet {

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
            out.println("<title>Servlet UpdateManagerControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateManagerControl at " + request.getContextPath() + "</h1>");
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
    
    private boolean CheckMaCV(String ma){
        DAO_Manager dao = new DAO_Manager();
        List<Manager> list = dao.getAllManager();
        return list.stream().noneMatch(p -> (p.getMANV().equals(ma) && p.getMACV().equals("QLCH")));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession ss = request.getSession();
        Account acc = (Account) ss.getAttribute("acc");
        if(CheckMaCV(acc.getUsername())){
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Khong phai quan ly!!!');");
                out.println("location='home';");
                out.println("</script>");
            }
        }else{
        String maNV = request.getParameter("eid");
        DAO_Manager dao = new DAO_Manager();
        Manager m = dao.getManagerByID(maNV);
//        String cateID = request.getParameter("MALOAI");
        List<ChucVu> listCV = dao.getAllCV();
        
        //b2: set data to jsp
        request.setAttribute("listCV", listCV);
        request.setAttribute("upM", m);
        request.getRequestDispatcher("UpdateManager.jsp").forward(request, response);
        }
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
        String id = request.getParameter("MANV");
        String name = request.getParameter("TENNV");
        String cmnd = request.getParameter("CMND");
        String diachi = request.getParameter("DIACHI");
        String sdt = request.getParameter("SDT");
        String cv = request.getParameter("MACV");
        
        DAO_Manager dao = new DAO_Manager();
        dao.updateManager(id, name, cmnd, diachi, sdt, cv);
        response.sendRedirect("managerH");
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
