/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management_mobile.DAO;

import com.management_mobile.Model.Product;
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
public class DAO_Home {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Product> getProduct(){
        List<Product> list = new ArrayList<>();
        String queryProduct = "SELECT * FROM MatHang";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(queryProduct);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    public int getAllUser(){
        String queryUser = "SELECT COUNT(MAKH) FROM KHACHHANG";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(queryUser);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }
    public int getAllProduct(){
        String queryUser = "SELECT COUNT(MAMH) FROM MATHANG";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(queryUser);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }
    public int getAllOrder(){
        String queryOrder = "SELECT COUNT(MAHDBH) \n" +
                            "FROM HOADONBANHANG\n" +
                            "where TONGTIEN is not null";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(queryOrder);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }

    public int getAllMoney() {
        String queryOrder = "select sum(b.SL * b.DONGIA) as[TONGTIEN]\n" +
                                "from HoaDonBanHang a, CT_HDBH b\n" +
                                "where a.MAHDBH = b.MAHDBH";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(queryOrder);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }
}
