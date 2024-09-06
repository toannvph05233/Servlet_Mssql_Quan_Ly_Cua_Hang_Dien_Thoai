/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management_mobile.DAO;

import com.management_mobile.Model.CT_HoaDon;
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
public class DAO_ChiTietHD {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<CT_HoaDon> getAllCTHD(String maHD){
        List<CT_HoaDon> list = new ArrayList<>();
        String query = "select * from CT_HDBH where MAHDBH=?";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(query);
            ps.setString(1, maHD);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new CT_HoaDon(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    public void AddCTHD(String maHD, String maMH, String SL, String DonGia, String maKM){
        int TT = Integer.valueOf(SL)*Integer.valueOf(DonGia);
        String sql = "insert into CT_HDBH values (?, ?, ?, ?, ?, ?)\n" +
                "update HoaDonBanHang set TONGTIEN = a.THANHTIEN\n" +
                "from HoaDonBanHang , (select MAHDBH, SUM(THANHTIEN) as THANHTIEN\n" +
                "						from CT_HDBH\n" +
                "						group by MAHDBH) a\n" +
                "where a.MAHDBH = HoaDonBanHang.MAHDBH";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(sql);
            ps.setString(1, maHD);
            ps.setString(2, maMH);
            ps.setString(3, SL);
            ps.setString(4, DonGia);
            ps.setNull(5, java.sql.Types.NULL, maKM);
            ps.setInt(6, TT);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
