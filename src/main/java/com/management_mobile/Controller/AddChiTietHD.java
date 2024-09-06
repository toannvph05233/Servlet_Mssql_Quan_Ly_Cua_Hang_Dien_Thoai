/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management_mobile.Controller;

import com.management_mobile.DAO.DAO_ChiTietHD;
import com.management_mobile.DAO.DAO_Invoice;
import com.management_mobile.DAO.DAO_Product;
import com.management_mobile.Model.CT_HoaDon;
import com.management_mobile.Model.HoaDon;
import com.management_mobile.Model.Product;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "AddChiTietHD", urlPatterns = {"/addchitiethd"})
public class AddChiTietHD extends HttpServlet {

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
        
        request.getRequestDispatcher("AddChiTietHD.jsp").forward(request, response);
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
        String maHD = request.getParameter("iid");
        
        DAO_Invoice dao = new DAO_Invoice();
        HoaDon hd = dao.getInvoiceByID(maHD);
        
        DAO_ChiTietHD d = new DAO_ChiTietHD();
        List<CT_HoaDon> list = d.getAllCTHD(maHD);
        
        DAO_Product daoP = new DAO_Product();
        List<Product> listP = daoP.getAllProduct();
        //b2: set data to jsp
        request.setAttribute("listP", listP);
        request.setAttribute("upI", hd);
        request.setAttribute("listCT", list);
        request.getRequestDispatcher("AddChiTietHD.jsp").forward(request, response);
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
        String maHD = request.getParameter("maHD");
        String maMH = request.getParameter("maMH");
        String SL = request.getParameter("SL");
        String DonGia = request.getParameter("DonGia");
        String maKM = request.getParameter("maKM");
        
        if(maKM.equals("")) maKM = "NULL";
        DAO_ChiTietHD dao = new DAO_ChiTietHD();
        
        dao.AddCTHD(maHD, maMH, SL, DonGia, maKM);
        response.sendRedirect("invoice");
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
