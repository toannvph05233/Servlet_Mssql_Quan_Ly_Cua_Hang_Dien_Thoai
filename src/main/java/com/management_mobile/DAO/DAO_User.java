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
import java.sql.SQLException;
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
    public void delUser(String maKH) {
        String sqlDeleteTheThanhVien = "DELETE FROM TheThanhVien WHERE MAKH=?";
        String sqlUpdateHoaDonBanHang = "UPDATE HoaDonBanHang SET MAKH = NULL WHERE MAKH=?";
        String sqlDeleteKhachHang = "DELETE FROM KhachHang WHERE MAKH=?";

        try {
            conn = new DBContext().getCon();
            conn.setAutoCommit(false); // Bắt đầu một transaction

            // Xoá từ bảng TheThanhVien
            try (PreparedStatement ps = conn.prepareStatement(sqlDeleteTheThanhVien)) {
                ps.setString(1, maKH);
                ps.executeUpdate();
            }

            if (checkHD(maKH)) {
                // Cập nhật bảng HoaDonBanHang nếu cần
                try (PreparedStatement ps = conn.prepareStatement(sqlUpdateHoaDonBanHang)) {
                    ps.setString(1, maKH);
                    ps.executeUpdate();
                }
            }

            // Xoá từ bảng KhachHang
            try (PreparedStatement ps = conn.prepareStatement(sqlDeleteKhachHang)) {
                ps.setString(1, maKH);
                ps.executeUpdate();
            }

            conn.commit(); // Commit transaction nếu mọi thứ thành công
        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback(); // Rollback nếu có lỗi
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace(); // In lỗi ra để dễ dàng kiểm tra
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); // Đặt lại chế độ auto commit
                    conn.close(); // Đóng kết nối
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
