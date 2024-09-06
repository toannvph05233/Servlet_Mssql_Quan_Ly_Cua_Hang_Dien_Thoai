/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management_mobile.DAO;

import com.management_mobile.Model.HoaDon;
import com.management_mobile.context.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class DAO_Invoice {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<HoaDon> getAllHoaDon(){
        List<HoaDon> list = new ArrayList<>();
        String query = "SELECT * FROM HOADONBANHANG";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public void addProduct(String maHD, String NgayLapHD, String maKH, String maNV, int TongTien) throws ParseException {
        String sql = "insert into HoaDonBanHang values (?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(sql);
            ps.setString(1, maHD);
            ps.setString(2, NgayLapHD);
            ps.setString(3, maKH);
            ps.setString(4, maNV);
            ps.setInt(5, TongTien);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public HoaDon getInvoiceByID(String maHD) {
        String query = "select * from HoaDonBanHang where MAHDBH=?";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(query);
            ps.setString(1, maHD);
            rs = ps.executeQuery();
            while(rs.next()){
                return new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void delInvoice(String id) {
        String sqlDeleteCT_HDBH = "DELETE FROM CT_HDBH WHERE MAHDBH=?";
        String sqlDeleteHoaDonBanHang = "DELETE FROM HoaDonBanHang WHERE MAHDBH=?";

        try {
            conn = new DBContext().getCon();
            conn.setAutoCommit(false); // Bắt đầu một transaction

            // Xoá từ bảng CT_HDBH
            try (PreparedStatement ps = conn.prepareStatement(sqlDeleteCT_HDBH)) {
                ps.setString(1, id);
                ps.executeUpdate();
            }

            // Xoá từ bảng HoaDonBanHang
            try (PreparedStatement ps = conn.prepareStatement(sqlDeleteHoaDonBanHang)) {
                ps.setString(1, id);
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

}
