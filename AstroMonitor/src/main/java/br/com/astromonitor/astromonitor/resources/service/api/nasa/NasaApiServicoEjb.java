/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.nasa;


import br.com.astromonitor.astromonitor.utils.Token;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Nicolas
 */

public class NasaApiServicoEjb{

    public String cadastrarDadosConsultaApi(String dataInicio, String dataFim, String tokenFront) {
        
        Token t = new Token();
        NasaApiDaoJpa dao = new NasaApiDaoJpa();
        String chaveApi = "";
        try {
            chaveApi = t.getChaveApiByToken(t.removeBearerPrefix(tokenFront));
        } catch (Exception e) {
            return null;
        }
        
        dao.create(getApiNasaAsteroids(dataInicio, dataFim, chaveApi));
        return null;
    }

    public Object[] consulta() {
        NasaApiDaoJpa dao = new NasaApiDaoJpa();
        
        Object[] consulta = dao.read();
  
        return consulta;
    }
    
    private List<NasaApiDto> getApiNasaAsteroids(String dataInicio, String dataFim, String KEY){
        
         try {
            String url = "https://api.nasa.gov/neo/rest/v1/feed?start_date="+ dataInicio + "&end_date="+ dataFim +"&api_key=" + KEY;
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
            
            JSONObject jsonObject = new JSONObject(content.toString());
            
            NasaApiConversorFactory conversor = new NasaApiConversorFactory();
            
            return conversor.converterJsonToNasaApiDto(jsonObject);
        } catch (Exception e) {
            return null;
        }
    }
    
}
