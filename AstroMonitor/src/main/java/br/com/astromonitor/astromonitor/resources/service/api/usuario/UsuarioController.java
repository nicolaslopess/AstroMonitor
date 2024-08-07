/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.usuario;

import br.com.astromonitor.astromonitor.utils.StandardResponse;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Nicolas
 */
@Path("/user")
public class UsuarioController {

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(UsuarioDto usuarioDto) {
//  Json que devo receber do front
//    {
//    "nome": "Nome do Usuário",
//    "login": "login_do_usuario",
//    "senha": "senha_secreta",
//    "chaveApi": "chave_api_do_usuario"
//    }
        try {
            UsuarioServicoEjb servico = new UsuarioServicoEjb();
            servico.create(usuarioDto);
            return Response.ok(new StandardResponse("Usuario cadastrado")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new StandardResponse(e.getMessage())).build();
        }
    }
    
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginDto loginDto) {
//  Json que devo receber do front
//    {
//    "login": "login_do_usuario",
//    "senha": "senha_secreta",
//    }
        try {
            UsuarioServicoEjb servico = new UsuarioServicoEjb();
            String token = servico.authenticate(loginDto);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return Response.ok(response).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new StandardResponse(e.getMessage())).build();
        }
    }
    
    @POST
    @Path("/verificar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response verificarUser(@Context HttpHeaders headers) {
        
        String token = headers.getHeaderString("Authorization");

        if (token == null || token.isEmpty()) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Token is missing").build();
        }

        try {
            UsuarioServicoEjb servico = new UsuarioServicoEjb();
            if(servico.verificarToken(token)){
               return Response.ok(new StandardResponse("Token valido")).build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).entity(new StandardResponse("Token Invalido")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new StandardResponse(e.getMessage())).build();
        }
    }
}
