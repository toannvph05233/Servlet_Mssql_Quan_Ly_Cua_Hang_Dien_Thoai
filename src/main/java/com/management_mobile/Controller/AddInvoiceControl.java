/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management_mobile.Controller;

import com.management_mobile.DAO.DAO_Invoice;
import com.management_mobile.Model.Account;
import com.management_mobile.Model.HoaDon;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "AddInvoiceControl", urlPatterns = {"/addinvoice"})
public class AddInvoiceControl extends HttpServlet {

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
        HttpSession ss = request.getSession();
        Account a = (Account) ss.getAttribute("acc");
        
        ss.setAttribute("acc", a);
        request.getRequestDispatcher("AddInvoice.jsp").forward(request, response);
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
    private boolean CheckMaHD(String ma){
        DAO_Invoice dao = new DAO_Invoice();
        List<HoaDon> list = dao.getAllHoaDon();
        return list.stream().noneMatch(p -> (p.getMaHD().equals(ma)));
//        Doan code tren tuong duong voi:
//        for(Product p : list){
//            if(p.getMaMH().equals(ma))
//                return false;
//        }return true;
    }
    
   
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maHD = request.getParameter("maHD");
        String NgayLapHD = request.getParameter("NgayLapHD");
        String maKH = request.getParameter("maKH");
        String maNV = request.getParameter("maNV");
        int TongTien = Integer.valueOf(request.getParameter("TongTien"));
        
        DAO_Invoice dao = new DAO_Invoice();
        if(!CheckMaHD(maHD)){
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Da co ma hoa don!');");
                out.println("location='addinvoice';");
                out.println("</script>");
            }
            catch(Exception ex){
            }
        }else{
            try {
                dao.addProduct(maHD, NgayLapHD, maKH, maNV, TongTien);
                response.sendRedirect("invoice");
            } catch (ParseException ex) {
                Logger.getLogger(AddInvoiceControl.class.getName()).log(Level.SEVERE, null, ex);
            }
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
