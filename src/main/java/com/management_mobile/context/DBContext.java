/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management_mobile.context;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author admin
 */
public class DBContext {
    public Connection getCon() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/QLCHDD";
        String username = "root";
        String pass = "12345678";
        return DriverManager.getConnection(url,username,pass);
    }

}
