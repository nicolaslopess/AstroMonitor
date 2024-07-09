/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.planetario;

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
                frequency.setDataAproximacao(resultSet.getDate("data_aproximacao"));
                frequency.setNumeroDeObjetosDetectados(resultSet.getInt("numero_de_objetos_detectados"));
                lista.add(frequency);
            }
        }
        return lista;
    }

}
