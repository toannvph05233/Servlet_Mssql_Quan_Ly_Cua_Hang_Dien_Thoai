/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management_mobile.DAO;

import com.management_mobile.Model.ChucVu;
import com.management_mobile.Model.Manager;
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
public class DAO_Manager {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Manager> getAllManager(){
        List<Manager> list = new ArrayList<>();
        String query = "SELECT a.MANV, a.TENNV, a.CMND, a.DIACHI, a.SDT, b.MACV, b.TENCV\n" +
                        "FROM NhanVien a, ChucVu b\n" +
                        "where a.MACV = b.MACV";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Manager(rs.getString(1), rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<ChucVu> getAllCV(){
        List<ChucVu> list = new ArrayList<>();
        String query = "SELECT * FROM ChucVu";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new ChucVu(rs.getString(1), rs.getString(2)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    public List<Manager> getAllManagerByMACV(String CID){
        List<Manager> list = new ArrayList<>();
        String query = "SELECT a.MANV, a.TENNV, a.CMND, a.DIACHI, a.SDT, b.MACV, b.TENCV\n" +
                        "FROM NhanVien a, ChucVu b\n" +
                        "where a.MACV = b.MACV and a.MACV = ?";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(query);
            ps.setString(1, CID);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Manager(rs.getString(1), rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public Manager getManagerByID(String maNV){
        String query = "SELECT a.MANV, a.TENNV, a.CMND, a.DIACHI, a.SDT, b.MACV, b.TENCV\n" +
                        "FROM NhanVien a, ChucVu b\n" +
                        "where a.MACV = b.MACV and a.MANV=?";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(query);
            ps.setString(1, maNV);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Manager(rs.getString(1), rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Manager getQL(String maNV){
        String query = "SELECT MANV, TENNV, CMND, DIACHI, SDT, MACV\n" +
                        "FROM NhanVien\n" +
                        "where MACV = 'QLCH' AND MANV = ?";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(query);
            ps.setString(1, maNV);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Manager(rs.getString(1), rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void addManager(String MANV, String TENNV, String CMND, String DIACHI, String SDT, String MACV){
        String sql = "insert into NhanVien values (?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(sql);
            ps.setString(1, MANV);
            ps.setString(2, TENNV);
            ps.setString(3, CMND);
            ps.setString(4, DIACHI);
            ps.setString(5, SDT);
            ps.setString(6, MACV);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateManager(String MANV, String TENNV, String CMND, String DIACHI, String SDT, String MACV){
        String query = "update NhanVien\n" +
                        "set TENNV = ?, CMND = ?, DIACHI = ?, SDT = ?, MACV = ?\n" +
                        "where MANV = ?";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(query);
            ps.setString(1, TENNV);
            ps.setString(2, CMND);
            ps.setString(3, DIACHI);
            ps.setString(4, SDT);
            ps.setString(5, MACV);
            ps.setString(6, MANV);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void delManager(String id){
        String sql = "delete from NhanVien where MANV=?";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void CreateAccount(String user, String pass){
        String sql = "insert into TaiKhoan values(?, ?)";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
