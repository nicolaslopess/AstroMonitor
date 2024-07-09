/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.usuario;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolas
 */
public class UsuarioServicoEjb {

    public void create(UsuarioDto usuarioDto) throws Exception {
        try {
            UsuarioDaoJpa dao = new UsuarioDaoJpa();
            dao.create(usuarioDto);
        } catch (Exception e) {
            throw e;
        }
    }

    public String authenticate(LoginDto loginDto){
        try {
            UsuarioDaoJpa dao = new UsuarioDaoJpa();
            return dao.authenticate(loginDto);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServicoEjb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
