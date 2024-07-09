/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.planetario;

import br.com.astromonitor.astromonitor.resources.service.api.controller.AstroMonitorController;
import br.com.astromonitor.astromonitor.resources.service.api.nasa.NasaApiServicoEjb;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/planetario")
public class PlanetarioController extends AstroMonitorController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfo() {
        PlanetarioAsteroidDAO asteroidDAO = new PlanetarioAsteroidDAO();
        List<PlanetarioAsteroid> asteroids = asteroidDAO.getAllAsteroids();
        return Response.ok(asteroids).build();
    }

    @GET
    @Path("/nasa")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNasaData() {
        try {
            NasaApiServicoEjb nasaApiServico = new NasaApiServicoEjb();
            nasaApiServico.cadastrarDadosConsultaApi("");
            return Response.ok("Dados Atualizado").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}

   
    
//    select para pegar todos os objetos proximos a terra
//    select * from asteroids
//where data_aproximacao between '2024-07-05' and '2024-07-06'
    
    
//    consulta da lista de proximas aproximações de hoje ate tres dias no futuro
//    SELECT * FROM asteroids
//WHERE data_aproximacao BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 3 DAY)
//ORDER BY data_aproximacao ASC;
    
//    Atividade recentes
//    SELECT 
//    data_aprocimacao,
//    COUNT(*) AS numero_de_objetos_detectados
//FROM 
//    asteroids
//WHERE 
//    data_aprocimacao BETWEEN CURDATE() - INTERVAL 5 DAY AND CURDATE()
//GROUP BY 
//    data_aprocimacao
//ORDER BY 
//    data_aprocimacao DESC;
