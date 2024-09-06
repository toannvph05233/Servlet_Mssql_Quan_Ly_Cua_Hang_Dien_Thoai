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
public class CT_HoaDon {
    private String maHD;
    private String maMH;
    private int SL;
    private int DonGia;
    private String maKM;
    private int ThanhTien;

    public CT_HoaDon() {
    }

    public CT_HoaDon(String maHD, String maMH, int SL, int DonGia, String maKM) {
        this.maHD = maHD;
        this.maMH = maMH;
        this.SL = SL;
        this.DonGia = DonGia;
        this.maKM = maKM;
    }
    
    public CT_HoaDon(String maHD, String maMH, int SL, int DonGia, String maKM, int ThanhTien) {
        this.maHD = maHD;
        this.maMH = maMH;
        this.SL = SL;
        this.DonGia = DonGia;
        this.maKM = maKM;
        this.ThanhTien = ThanhTien;
    }
    
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    

    @Override
    public String toString() {
        return "CT_HoaDon{" + "maHD=" + maHD  + "maMH=" + maMH + ", SL=" + SL + ", DonGia=" + DonGia + ", maKM=" + maKM + '}';
    }
}
