/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.nasa;

import javax.ejb.Local;



/**
 *
 * @author Nicolas
 */
@Local
public interface NasaApiServicoLocal {
    
    public String cadastrarDadosConsultaApi(String dataInicio);
}
