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
@WebServlet(name = "AddManagerControl", urlPatterns = {"/addmanager"})
public class AddManagerControl extends HttpServlet {

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
        DAO_Manager d = new DAO_Manager();
        String cateID = request.getParameter("MACV");
        List<ChucVu> listCV = d.getAllCV();
        
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
            
            request.setAttribute("listCV", listCV);
            request.setAttribute("tag", cateID);
            request.getRequestDispatcher("AddManager.jsp").forward(request, response);
        }
        //b2: set data to jsp
    }

    private boolean CheckMaNV(String ma){
        DAO_Manager dao = new DAO_Manager();
        List<Manager> list = dao.getAllManager();
        return list.stream().noneMatch(p -> (p.getMANV().equals(ma)));
    }
    private boolean CheckMaCV(String ma){
        DAO_Manager dao = new DAO_Manager();
        List<Manager> list = dao.getAllManager();
        return list.stream().noneMatch(p -> (p.getMANV().equals(ma) && p.getMACV().equals("QLCH")));
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
        String maNV = request.getParameter("MANV");
        String tenNV = request.getParameter("TENNV");
        String CMND = request.getParameter("CMND");
        String DiaChi = request.getParameter("DIACHI");
        String SDT = request.getParameter("SDT");
        String MaCV = request.getParameter("MACV");
        
        DAO_Manager dao = new DAO_Manager();
        if(!CheckMaNV(maNV)){
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Đã có mã nhân viên!');");
                out.println("location='addmanager';");
                out.println("</script>");
            }
            catch(Exception ex){
            }
        }else{
            dao.addManager(maNV, tenNV, CMND, DiaChi, SDT, MaCV);
            response.sendRedirect("managerH");
        }
        
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
