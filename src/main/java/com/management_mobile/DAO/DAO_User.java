/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management_mobile.DAO;

import com.management_mobile.Model.User;
import com.management_mobile.context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class DAO_User {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<User> getAllUser(){
        List<User> list = new ArrayList<>();
        String query = "SELECT * FROM KhachHang";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new User(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    public void addUser(String MAKH, String TENKH, String SDT){
        String sql = "insert into KhachHang values(?, ?, ?)";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(sql);
            ps.setString(1, MAKH);
            ps.setString(2, TENKH);
            ps.setString(3, SDT);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void updateUser(String MAKH,String TENKH, String SDT){
        String sql = "update KhachHang \n" +
                        "set TENKH = ?, SDT = ?\n" +
                        "where MAKH = ?";
        try {
            conn = new DBContext().getCon();
            ps = conn.prepareStatement(sql);
            ps.setString(1, TENKH);
            ps.setString(2, SDT);
            ps.setString(3, MAKH);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
    public boolean checkHD(String maKH){
        String sql = "select * from HoaDonBanHang where MAKH = ?";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(sql);
            ps.setString(1, maKH);
            rs = ps.executeQuery();
            if(rs != null)
                return true;
        } catch (Exception e) {
        }
        return false;
    }
    public void delUser(String maKH){
        String sql = "";
        try {
            if (checkHD(maKH)== false) {
                sql = "delete from TheThanhVien where MAKH = ? \n" +
                        "delete from KhachHang where MAKH=?";
                conn = new DBContext().getCon();
                ps=conn.prepareStatement(sql);
                ps.setString(1, maKH);
                ps.setString(2, maKH);
                ps.executeUpdate();
            }
            else{
                sql = "delete from TheThanhVien where MAKH = ? \n" +
                        "update HoaDonBanHang set MAKH = null where MAKH = ? \n" +
                        "delete from KhachHang where MAKH=?" ;
                conn = new DBContext().getCon();
                ps=conn.prepareStatement(sql);
                ps.setString(1, maKH);
                ps.setString(2, maKH);
                ps.setString(3, maKH);
                ps.executeUpdate();
            }
            
        } catch (Exception e) {
        }
    }

    public User getUserByID(String maKH) {
        String query = "select * from KhachHang where MAKH = ?";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(query);
            ps.setString(1, maKH);
            rs = ps.executeQuery();
            while(rs.next()){
                return new User(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
        }
        return null;
    }
}
