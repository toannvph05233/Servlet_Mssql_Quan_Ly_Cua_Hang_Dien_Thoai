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
    private final String dbName = "QLCHDD";
    private final String userName = "sa";
    private final String passWord = "Password.1";
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;";

    public Connection getCon() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userName, passWord);
    }

}
