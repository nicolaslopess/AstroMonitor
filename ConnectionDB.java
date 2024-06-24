package br.com.astromonitor.astromonitor.utils;

import java.sql.Connection;
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
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}
