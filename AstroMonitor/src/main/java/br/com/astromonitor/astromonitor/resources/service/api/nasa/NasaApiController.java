/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.nasa;

import br.com.astromonitor.astromonitor.resources.service.api.controller.AstroMonitorController;
import br.com.astromonitor.astromonitor.utils.StandardResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

/**
 *
 * @author Nicolas
 */
@Path("/recurso")
public class NasaApiController extends AstroMonitorController{
    
    @GET
    @Path("/nasa")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNasaData(@QueryParam("dateinicio") String dateInicio,@QueryParam("datefim") String dateFim, @Context HttpHeaders headers) { //http://localhost:8080/api/recurso/nasa?dateinicio=2024-07-07&datefim=2024-07-07
        
        String token = headers.getHeaderString("Authorization");

        if (token == null || token.isEmpty()) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Token is missing").build();
        }
        
        try {
            
            NasaApiServicoEjb nasaApiServico = new NasaApiServicoEjb();
            
            nasaApiServico.cadastrarDadosConsultaApi(dateInicio, dateFim, token);

            return Response.ok("Dados Atualizado").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
