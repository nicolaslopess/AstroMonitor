/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.nasa;

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
/**
 *
 * @author Nicolas
 */
@Path("/recurso")

public class NasaApiController {


    @GET
    @Path("/mensagem")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMensagem() {
        return Response.ok(new StandardResponse("Teste api nicolas")).build();
    }

    @GET
    @Path("/dados")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDados() {
//        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
//            String query = "SELECT * FROM sua_tabela";
//            PreparedStatement statement = connection.prepareStatement(query);
//            ResultSet resultSet = statement.executeQuery();
//            // Processar o resultado e retornar como JSON
//            // ...
//            return Response.ok(/* seus dados processados */).build();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
//        }
            return Response.ok("restosta").build();
    }

    @GET
    @Path("/nasa")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNasaData() {
        try {
            String url = "https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=";
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            connection.disconnect();
            return Response.ok(content.toString()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
    
    @GET
    @Path("/get-api-nasa-asteroids-neows")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getApiNasaAsteroids() {
        try {
            String url = "https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=QoSXBccl5ZBDpnd66M7xwLq6I0Ake0hiV7hdZsTV";
            
            
            
            
            
            
            
            
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            connection.disconnect();
            return Response.ok(content.toString()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


}
