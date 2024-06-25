/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author m120949
 */
public class ConnectionDB {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/astro_monitor";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";
    
//    public static ConnectionDB getConnection() throws SQLException {
//        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//    }
    
}
