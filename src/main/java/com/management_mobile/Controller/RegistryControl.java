/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management_mobile.Controller;

import com.management_mobile.DAO.DAO_Manager;
import com.management_mobile.Model.Account;
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
@WebServlet(name = "RegistryControl", urlPatterns = {"/registry"})
public class RegistryControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private boolean CheckMaCV(String ma){
        DAO_Manager dao = new DAO_Manager();
        List<Manager> list = dao.getAllManager();
        return list.stream().anyMatch(m -> (m.getMANV().equals(ma) && m.getMACV().equals("QLCH")));//neu co thi true, nguoc lai thi false
    }
    private boolean CheckMaNV(String ma){
        DAO_Manager dao = new DAO_Manager();
        List<Manager> list = dao.getAllManager();
        return list.stream().anyMatch(m -> (m.getMANV().equals(ma)));//neu co thi true, nguoc lai thi false
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("Registry.jsp").forward(request, response);
        /*
        nếu cùng printwriter out và forward() sẽ bị exception
        
        */
        
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
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        
        HttpSession ss = request.getSession();
        Account acc = (Account) ss.getAttribute("acc");
        DAO_Manager dao = new DAO_Manager();
        if (!CheckMaCV(acc.getUsername())) {
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Khong co quyen chinh sua!!!');");
                out.println("location='home';");
                out.println("</script>");
            }
            catch(Exception ex){
            }
        }else{
            if (pass.equals(repass)==false) {
                try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Mat khau khong trung nhau!');");
                    out.println("location='registry';");
                    out.println("</script>");
                }
                catch(Exception ex){
                }
            }
//            else if(!CheckMaCV(user)){
//                try (PrintWriter out = response.getWriter()) {
//                /* TODO output your page here. You may use following sample code. */
//                    out.println("<script type=\"text/javascript\">");
//                    out.println("alert('Khong co ma nhan vien nay!');");
//                    out.println("location='registry';");
//                    out.println("</script>");
//                }
//                catch(Exception ex){
//                }
//            }
            else{
                dao.CreateAccount(user, pass);
                response.sendRedirect("managerH");
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
