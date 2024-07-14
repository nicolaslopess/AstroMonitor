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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
            String tokenAlterado = t.removeBearerPrefix(tokenFront);
            chaveApi = t.getChaveApiByToken(tokenAlterado);
        } catch (Exception e) {
            return "Tokn invalido";
        }
        
        dao.create(getApiNasaAsteroids(dataInicio, dataFim, chaveApi));
        return "Dados Atualizado";
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

    public String cadastrarDadosConsultaApiAuto(String token) {
        LocalDate today = LocalDate.now();
        
        LocalDate startDate = today.minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String dataInicio = startDate.format(formatter);
        String dataFim = today.format(formatter);
        
        String retorno = cadastrarDadosConsultaApi(dataInicio, dataFim, token);
        
        startDate = today.plusDays(4);
        dataInicio = today.format(formatter);
        dataFim = startDate.format(formatter);
        
        retorno = cadastrarDadosConsultaApi(dataInicio, dataFim, token);
        
        return retorno;
    }
}
