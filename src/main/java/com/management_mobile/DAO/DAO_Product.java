/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management_mobile.DAO;

import com.management_mobile.Model.CategoryMH;
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
public class DAO_Product {
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Product> getAllProduct(){
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM MatHang";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    public List<CategoryMH> getAllCategory(){
        List<CategoryMH> list = new ArrayList<>();
        String query = "SELECT * FROM LoaiHang";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new CategoryMH(rs.getString(1), rs.getString(2)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    public List<Product> getAllProductByCategory(String CID){
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM MatHang where MALOAI = ?";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(query);
            ps.setString(1, CID);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public void delProduct(String id){
        String sql = "delete from MatHang where MAMH=?";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void addProduct(String maMH, String tenMH, String price, String maLoai){
        String sql = "insert into MatHang values (?, ?, ?, ?)";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(sql);
            ps.setString(1, maMH);
            ps.setString(2, tenMH);
            ps.setString(3, price);
            ps.setString(4, maLoai);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public Product getProductByID(String maMH){
        String query = "select * from MatHang where MAMH = ?";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(query);
            ps.setString(1, maMH);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void updateProduct(String maMH, String tenMH, String giaMH){
        String query = "update MatHang\n" +
                        "set TENMH = ?, DONGIA = ?\n" +
                        "where MAMH = ?";
        try {
            conn = new DBContext().getCon();
            ps=conn.prepareStatement(query);
            ps.setString(1, tenMH);
            ps.setString(2, giaMH);
            ps.setString(3, maMH);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
