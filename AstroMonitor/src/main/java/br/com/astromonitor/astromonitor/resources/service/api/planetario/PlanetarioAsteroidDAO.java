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
                    populateAsteroidFromResultSet(resultSet, asteroid);
                    asteroids.add(asteroid);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return asteroids;
    }

    public List<PlanetarioAsteroid> getAsteroidsByDateRange(String startDate, String endDate) {
        List<PlanetarioAsteroid> asteroids = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        try (Connection connection = connectionDB.getConnection()) {
            String query = "SELECT * FROM asteroids WHERE data_aproximacao BETWEEN ? AND ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, startDate);
                statement.setString(2, endDate);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        PlanetarioAsteroid asteroid = new PlanetarioAsteroid();
                        populateAsteroidFromResultSet(resultSet, asteroid);
                        asteroids.add(asteroid);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return asteroids;
    }

    public List<PlanetarioAsteroid> getUpcomingAsteroids() {
        List<PlanetarioAsteroid> asteroids = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        try (Connection connection = connectionDB.getConnection()) {
            String query = "SELECT * FROM asteroids WHERE data_aproximacao BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 3 DAY) ORDER BY data_aproximacao ASC";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    PlanetarioAsteroid asteroid = new PlanetarioAsteroid();
                    populateAsteroidFromResultSet(resultSet, asteroid);
                    asteroids.add(asteroid);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return asteroids;
    }

    public List<PlanetarioRecentActivity> getRecentActivity() {
        List<PlanetarioRecentActivity> activities = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        try (Connection connection = connectionDB.getConnection()) {
            String query = "SELECT data_aproximacao, COUNT(*) AS numero_de_objetos_detectados FROM asteroids WHERE data_aproximacao BETWEEN CURDATE() - INTERVAL 5 DAY AND CURDATE() GROUP BY data_aproximacao ORDER BY data_aproximacao DESC";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    PlanetarioRecentActivity activity = new PlanetarioRecentActivity();
                    activity.setDataAproximacao(resultSet.getDate("data_aproximacao"));
                    activity.setNumeroDeObjetosDetectados(resultSet.getInt("numero_de_objetos_detectados"));
                    activities.add(activity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return activities;
    }

    private void populateAsteroidFromResultSet(ResultSet resultSet, PlanetarioAsteroid asteroid) throws Exception {
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
    }
}
