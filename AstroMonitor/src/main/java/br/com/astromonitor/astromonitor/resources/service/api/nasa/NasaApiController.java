/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.nasa;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

/**
 *
 * @author Nicolas
 */
@Path("/recurso")
public class NasaApiController {
    
    @GET
    @Path("/nasa")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNasaData(@QueryParam("dateinicio") String dateInicio,@QueryParam("datefim") String dateFim, @Context HttpHeaders headers) { //http://localhost:8080/api/recurso/nasa?dateinicio=2024-07-07&datefim=2024-07-07
        
        String token = headers.getHeaderString("Authorization");

        if (token == null || !token.startsWith("Bearer ")) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Token inválido ou ausente").build();
        }
        
        try {
            
            NasaApiServicoEjb nasaApiServico = new NasaApiServicoEjb();
            
            String retorno = nasaApiServico.cadastrarDadosConsultaApi(dateInicio, dateFim, token);

            return Response.ok(retorno).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
    
    @GET
    @Path("/nasa_auto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNasaData(@Context HttpHeaders headers) {
        
        String token = headers.getHeaderString("Authorization");

        if (token == null || token.isEmpty()) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Token invalido").build();
        }
        
        try { 
            
            NasaApiServicoEjb nasaApiServico = new NasaApiServicoEjb();
            
           String retorno = nasaApiServico.cadastrarDadosConsultaApiAuto(token);//4 dias no futuro e 7 dias no passado

            return Response.ok(retorno).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
