/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.planetario;

import br.com.astromonitor.astromonitor.resources.service.api.nasa.NasaApiDto;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author VitorM
 */
@Path("/planetario")
public class PlanetarioController {

    @GET
    @Path("/proximos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjetosProximosTerra() {//Objetos Proximos a terra no momento

       PlanetarioServicoEjb servico = new PlanetarioServicoEjb();
       
       Integer count = servico.getObjetosProximosTerra();
        
       return Response.ok(count).build();
    }

    @GET
    @Path("/futuras")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListaAproximacoesFuturas() {//Aproximações futuras
        PlanetarioServicoEjb servico = new PlanetarioServicoEjb();
        List<NasaApiDto> lista;
        
        lista = servico.getListaAproximacoesFuturas();
        return Response.ok(lista).build();
    }

    @GET
    @Path("/recentes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAtividadesRecentes() {//Atividade recentes

        PlanetarioDaoJpa dao = new PlanetarioDaoJpa();

        List<PlanetarioAtividadesRecentesDto> lista;
        try {
            lista = dao.getAtividadesRecentes();
            return Response.ok(lista).build();
        } catch (SQLException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }
}
