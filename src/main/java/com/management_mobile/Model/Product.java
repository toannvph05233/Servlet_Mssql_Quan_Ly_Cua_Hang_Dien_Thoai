/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management_mobile.Model;

/**
 *
 * @author admin
 */
public class Product {
    private String maMH;
    private String tenMH;
    private int giaMH;
    private String maLoai;
    
    public Product(){}

    public Product(String maMH, String tenMH, int giaMH, String maLoai) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.giaMH = giaMH;
        this.maLoai = maLoai;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public int getGiaMH() {
        return giaMH;
    }

    public void setGiaMH(int giaMH) {
        this.giaMH = giaMH;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    @Override
    public String toString() {
        return "Product{" + "maMH=" + maMH + ", tenMH=" + tenMH + ", giaMH=" + giaMH + ", maLoai=" + maLoai + '}';
    }

    
    
}
