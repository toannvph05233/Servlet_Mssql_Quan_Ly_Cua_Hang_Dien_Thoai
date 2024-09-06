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
public class Manager {
    private String MANV;
    private String TENNV;
    private String CMND;
    private String DIACHI;
    private String SDT;
    private String MACV;
    private String TENCV;

    public Manager() {
    }

    public Manager(String MANV, String TENNV, String CMND, String DIACHI, String SDT, String MACV, String TENCV) {
        this.MANV = MANV;
        this.TENNV = TENNV;
        this.CMND = CMND;
        this.DIACHI = DIACHI;
        this.SDT = SDT;
        this.MACV = MACV;
        this.TENCV = TENCV;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getTENNV() {
        return TENNV;
    }

    public void setTENNV(String TENNV) {
        this.TENNV = TENNV;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMACV() {
        return MACV;
    }

    public void setMACV(String MACV) {
        this.MACV = MACV;
    }

    public String getTENCV() {
        return TENCV;
    }

    public void setTENCV(String TENCV) {
        this.TENCV = TENCV;
    }

    @Override
    public String toString() {
        return "Manager{" + "MANV=" + MANV + ", TENNV=" + TENNV + ", CMND=" + CMND + ", DIACHI=" + DIACHI + ", SDT=" + SDT + ", MACV=" + MACV + ", TENCV=" + TENCV + '}';
    }
    
}
