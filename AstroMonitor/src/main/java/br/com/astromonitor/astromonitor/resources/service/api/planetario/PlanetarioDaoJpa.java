/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.planetario;

import br.com.astromonitor.astromonitor.resources.service.api.nasa.NasaApiDto;
import br.com.astromonitor.astromonitor.utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class PlanetarioDaoJpa {

    private ConnectionDB connectionDB;

    public PlanetarioDaoJpa() {
        this.connectionDB = new ConnectionDB();
    }

    public List<PlanetarioAtividadesRecentesDto> getAtividadesRecentes() throws SQLException {

        String sql = "SELECT "
                + "    data_aproximacao, "
                + "    COUNT(*) AS numero_de_objetos_detectados "
                + "FROM "
                + "    asteroids "
                + "WHERE "
                + "    data_aproximacao BETWEEN CURDATE() - INTERVAL 5 DAY AND CURDATE() + INTERVAL 5 DAY "
                + "GROUP BY "
                + "    data_aproximacao "
                + "ORDER BY "
                + "    data_aproximacao ASC";

        List<PlanetarioAtividadesRecentesDto> lista = new ArrayList<>();

        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PlanetarioAtividadesRecentesDto frequency = new PlanetarioAtividadesRecentesDto();
                frequency.setDataAproximacao(resultSet.getString("data_aproximacao"));
                frequency.setNumeroDeObjetosDetectados(resultSet.getInt("numero_de_objetos_detectados"));
                lista.add(frequency);
            }
        }
        return lista;
    }

    public Integer getAsteroidesProximosTerra() {
        String sql = "SELECT count(*) as total_objetos_proximos FROM asteroids WHERE data_aproximacao  = DATE_FORMAT(NOW(), '%Y-%m-%d')";
        
        Integer count = 0;
       
        try ( Connection connection = connectionDB.getConnection()) {

            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                try ( ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        count = resultSet.getInt("total_objetos_proximos");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<NasaApiDto> getListaAproximacoesFuturas() {
        String sql = "SELECT * FROM asteroids WHERE data_aproximacao >= now()";

        List<NasaApiDto> asteroids = new ArrayList<>();
        try ( Connection connection = connectionDB.getConnection()) {

            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                try ( ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        NasaApiDto asteroid = new NasaApiDto();
                        asteroid.setIdObjetoNasa(resultSet.getInt("id_objeto_nasa"));
                        asteroid.setNomeAsteroid(resultSet.getString("nome_asteroid"));
                        asteroid.setNasaJplUrl(resultSet.getString("nasa_jpl_url"));
                        asteroid.setDiameterMinM(resultSet.getDouble("diameter_min_m"));
                        asteroid.setDiameterMaxM(resultSet.getDouble("diameter_max_m"));
                        asteroid.setRisco(resultSet.getBoolean("risco"));
                        asteroid.setDataAproximacao(resultSet.getDate("data_aproximacao"));
                        asteroid.setVelocidade(resultSet.getDouble("velocidade"));
                        asteroid.setDistanciaDaTerra(resultSet.getDouble("distancia_da_terra"));
                        asteroid.setOrbitando(resultSet.getString("orbitando"));
                        asteroids.add(asteroid);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return asteroids;
    }
}
