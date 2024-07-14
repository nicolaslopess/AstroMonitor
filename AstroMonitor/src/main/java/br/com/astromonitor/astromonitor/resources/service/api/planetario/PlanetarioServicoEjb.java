/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.planetario;

import br.com.astromonitor.astromonitor.resources.service.api.nasa.NasaApiDto;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class PlanetarioServicoEjb {

    public Integer getObjetosProximosTerra() {
        PlanetarioDaoJpa dao = new PlanetarioDaoJpa();

        Integer count = dao.getAsteroidesProximosTerra();
        
        return count;
    }

    public List<NasaApiDto> getListaAproximacoesFuturas() {
        PlanetarioDaoJpa dao = new PlanetarioDaoJpa();

        List<NasaApiDto> lista;
        lista  = dao.getListaAproximacoesFuturas();
        
        return lista;
    }
    
}
