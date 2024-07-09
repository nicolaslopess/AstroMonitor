/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.usuario;

import br.com.astromonitor.astromonitor.utils.ConnectionDB;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nicolas
 */
public class UsuarioDaoJpa {
    private ConnectionDB connectionDB;

    public UsuarioDaoJpa() {
        this.connectionDB = new ConnectionDB();
    }

    public void create(UsuarioDto usuarioDto) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, login, senha, chave_api) VALUES (?, ?, MD5(?), ?)";
        
        try (Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, usuarioDto.getNome());
                preparedStatement.setString(2, usuarioDto.getLogin());
                preparedStatement.setString(3, usuarioDto.getSenha());
                preparedStatement.setString(4, usuarioDto.getChaveApi());
                preparedStatement.executeUpdate();
            }
    }
    
    public String authenticate(LoginDto loginDto) throws SQLException{
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = MD5(?)";
        
//        try (Connection connection = connectionDB.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            preparedStatement.setString(1, loginDto.getLogin());
//            preparedStatement.setString(2, loginDto.getSenha());
//            
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                // Autenticação bem-sucedida, gerar token
////                String token = generateToken(loginDto.getLogin());
//                return null;
//            } else {
//                throw new IllegalArgumentException("Login ou senha inválidos");
//            }
//        }
        return null;
    
}
}
