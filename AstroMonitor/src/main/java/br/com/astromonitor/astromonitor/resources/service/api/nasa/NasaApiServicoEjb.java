/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.nasa;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ejb.Stateless;

/**
 *
 * @author Nicolas
 */

public class NasaApiServicoEjb implements NasaApiServicoLocal{

   
    @Override
    public String cadastrarDadosConsultaApi() {
        try {
            String url = "https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=DEMO_KEY";
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
            
            return content.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public Object[] consulta() {
        NasaApiDaoJpa dao = new NasaApiDaoJpa();
        
        Object[] consulta = dao.read();
        
        return consulta;
//        return null;

    }
    
}
