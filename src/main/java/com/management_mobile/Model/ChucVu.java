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
public class ChucVu {
    private String MACV;
    private String TENCV;

    public ChucVu(){
        
    }
    public ChucVu(String MACV, String TENCV) {
        this.MACV = MACV;
        this.TENCV = TENCV;
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
        return "ChucVu{" + "MACV=" + MACV + ", TENCV=" + TENCV + '}';
    }
    
    
}
