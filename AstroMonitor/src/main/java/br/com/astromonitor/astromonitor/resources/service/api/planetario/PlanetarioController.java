/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.planetario;

import br.com.astromonitor.astromonitor.resources.service.api.controller.AstroMonitorController;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Nicolas
 */
@Path("/planetario")
public class PlanetarioController extends AstroMonitorController {// classe desenvolvida para fornecer toda a parte de orientação de asteroides ao redor da terra
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfo() {
        return "{\"message\":\"Teste Planetario\"}";
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

}
