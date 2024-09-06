/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management_mobile.Controller;

import com.management_mobile.DAO.DAO_Product;
import com.management_mobile.Model.CategoryMH;
import com.management_mobile.Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AddControl", urlPatterns = {"/addproduct"})
public class AddProductControl extends HttpServlet {

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
        DAO_Product d = new DAO_Product();
        String cateID = request.getParameter("MALOAI");
        List<CategoryMH> listC = d.getAllCategory();
        
        //b2: set data to jsp
        request.setAttribute("listC", listC);
        request.setAttribute("tag", cateID);
        request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
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
    
    private boolean CheckMaSP(String ma){
        DAO_Product dao = new DAO_Product();
        List<Product> list = dao.getAllProduct();
        return list.stream().noneMatch(p -> (p.getMaMH().equals(ma)));
//        Doan code tren tuong duong voi:
//        for(Product p : list){
//            if(p.getMaMH().equals(ma))
//                return false;
//        }return true;
    }
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
        String maMH = request.getParameter("maMH");
        String tenMH = request.getParameter("tenMH");
        String giaMH = request.getParameter("giaMH");
        String MALOAI = request.getParameter("MALOAI");
        
        DAO_Product dao = new DAO_Product();
        if(!CheckMaSP(maMH)){
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Đã có mã sản phẩm!');");
                out.println("location='addproduct';");
                out.println("</script>");
            }
            catch(Exception ex){
            }
        }else{
            dao.addProduct(maMH, tenMH, giaMH, MALOAI);
            response.sendRedirect("product");
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
