/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management_mobile.DAO;

import com.management_mobile.Model.Account;
import com.management_mobile.context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author admin
 */
public class DAO_Login {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Account checkLogin(String user, String pass){
        try {
            String query = "select * from TaiKhoan where MATK=? and PASSWORD=?";
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                Account a = new Account(rs.getString(1), rs.getString(2));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
