/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.nasa;

import br.com.astromonitor.astromonitor.utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class NasaApiDaoJpa {

    private ConnectionDB connectionDB;

    public NasaApiDaoJpa() {
        this.connectionDB = new ConnectionDB();
    }

    public void create(List<NasaApiDto> dto) {
        String sql = "INSERT INTO asteroids (id_objeto_nasa, nome_asteroid, nasa_jpl_url, diameter_min_m, diameter_max_m, "
                + "risco, data_aproximacao, velocidade, distancia_da_terra, orbitando) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
                + "ON DUPLICATE KEY UPDATE nome_asteroid=VALUES(nome_asteroid), nasa_jpl_url=VALUES(nasa_jpl_url),"
                + "diameter_min_m=VALUES(diameter_min_m), diameter_max_m=VALUES(diameter_max_m),"
                + "risco=VALUES(risco), velocidade=VALUES(velocidade), distancia_da_terra=VALUES(distancia_da_terra),"
                + "orbitando=VALUES(orbitando)";

        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            for (NasaApiDto nasaApiDto : dto) {
                preparedStatement.setInt(1, nasaApiDto.getIdObjetoNasa());
                preparedStatement.setString(2, nasaApiDto.getNomeAsteroid());
                preparedStatement.setString(3, nasaApiDto.getNasaJplUrl());
                preparedStatement.setDouble(4, nasaApiDto.getDiameterMinM());
                preparedStatement.setDouble(5, nasaApiDto.getDiameterMaxM());
                preparedStatement.setBoolean(6, nasaApiDto.getRisco());
                preparedStatement.setDate(7, nasaApiDto.getDataAproximacao());
                preparedStatement.setDouble(8, nasaApiDto.getVelocidade());
                preparedStatement.setDouble(9, nasaApiDto.getDistanciaDaTerra());
                preparedStatement.setString(10, nasaApiDto.getOrbitando());
                
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object[] read() {
        String sql = "SELECT * FROM asteroids;";

        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int columnCount = resultSet.getMetaData().getColumnCount();
                Object[] result = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    result[i - 1] = resultSet.getObject(i);
                }
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new Object[]{"Database error: " + e.getMessage()};
        }
        return null;
    }

}
