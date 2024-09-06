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
public class User {
    private String MAKH;
    private String TENKH;
    private String SDT;

    public User(){
    }
    public User(String MAKH, String TENKH, String SDT) {
        this.MAKH = MAKH;
        this.TENKH = TENKH;
        this.SDT = SDT;
    }

    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
    }

    public String getTENKH() {
        return TENKH;
    }

    public void setTENKH(String TENKH) {
        this.TENKH = TENKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    
}
