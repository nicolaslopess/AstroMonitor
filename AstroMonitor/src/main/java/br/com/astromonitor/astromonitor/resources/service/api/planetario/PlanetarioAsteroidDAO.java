package br.com.astromonitor.astromonitor.resources.service.api.planetario;

import br.com.astromonitor.astromonitor.utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlanetarioAsteroidDAO {

    public List<PlanetarioAsteroid> getAllAsteroids() {
        List<PlanetarioAsteroid> asteroids = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        try (Connection connection = connectionDB.getConnection()) {
            String query = "SELECT * FROM asteroids";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    PlanetarioAsteroid asteroid = new PlanetarioAsteroid();
                    asteroid.setId(resultSet.getInt("id_asteroids"));
                    asteroid.setIdObjetoNasa(resultSet.getString("id_objeto_nasa"));
                    asteroid.setNomeAsteroid(resultSet.getString("nome_asteroid"));
                    asteroid.setNasaJplUrl(resultSet.getString("nasa_jpl_url"));
                    asteroid.setDiameterMinM(resultSet.getFloat("diameter_min_m"));
                    asteroid.setDiameterMaxM(resultSet.getFloat("diameter_max_m"));
                    asteroid.setRisco(resultSet.getBoolean("risco"));
                    asteroid.setDataAproximacao(resultSet.getDate("data_aproximacao"));
                    asteroid.setVelocidade(resultSet.getFloat("velocidade"));
                    asteroid.setDistanciaDaTerra(resultSet.getFloat("distancia_da_terra"));
                    asteroid.setOrbitando(resultSet.getString("orbitando"));
                    asteroids.add(asteroid);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return asteroids;
    }
}
