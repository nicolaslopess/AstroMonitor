/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.nasa;

import br.com.astromonitor.astromonitor.utils.ConnectionDB;
import br.com.astromonitor.astromonitor.utils.StandardResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nicolas
 */
public class NasaApiDaoJpa {
    
    private ConnectionDB connectionDB;
    
    public NasaApiDaoJpa() {
        this.connectionDB = new ConnectionDB();
    }

    public StandardResponse create(String someData) {
        String sql = "INSERT INTO your_table_name (column_name) VALUES (?)";
        
        try (Connection connection = connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setString(1, someData);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return new StandardResponse("Success");
            } else {
                return new StandardResponse("Error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new StandardResponse("Database error: " + e.getMessage());
        }
    }
    
    public Object[] read() {
        String sql = "SELECT * FROM asteroids";
        
        try (Connection connection = connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

           if (resultSet.next()) {
                int columnCount = resultSet.getMetaData().getColumnCount();
                Object[] result = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    result[i - 1] = resultSet.getObject(i);
                }
                return result;
            } else {
                return new Object[]{"No record found with ID: "};
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new Object[]{"Database error: " + e.getMessage()};
        }
    }
    
    
    
    
    
    
    
    
    
}
