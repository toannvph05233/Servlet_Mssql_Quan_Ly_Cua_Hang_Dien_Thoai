/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management_mobile.Model;

import java.util.Date;

/**
 *
 * @author admin
 */
public class HoaDon {
    private String maHD;
    private String NgayLapHD;
    private String maKH;
    private String maNV;
    private int TongTien;

    public HoaDon() {
    }

    public HoaDon(String maHD, String NgayLapHD, String maKH, String maNV, int TongTien) {
        this.maHD = maHD;
        this.NgayLapHD = NgayLapHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.TongTien = TongTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayLapHD() {
        return NgayLapHD;
    }

    public void setNgayLapHD(String NgayLapHD) {
        this.NgayLapHD = NgayLapHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHD=" + maHD + ", NgayLapHD=" + NgayLapHD + ", maKH=" + maKH + ", maNV=" + maNV + ", TongTien=" + TongTien + '}';
    }

}
