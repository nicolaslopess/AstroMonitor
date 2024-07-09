/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.nasa;


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

public class NasaApiServicoEjb implements NasaApiServicoLocal{

   
    @Override
    public String cadastrarDadosConsultaApi(String dataInicio) {
        
        NasaApiDaoJpa dao = new NasaApiDaoJpa();
        
//        String dataInicio = "2024-07-03";
        String dataFim = "";//= "2024-07-04";
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date date;
        try {
            date = (Date) dateFormat.parse(dataInicio);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, -1);

            Date newDate = (Date) calendar.getTime();
            dataFim = dateFormat.format(newDate);
        } catch (ParseException ex) {
            Logger.getLogger(NasaApiServicoEjb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dao.create(getApiNasaAsteroids(dataInicio, dataFim, ""));
       
        return null;
    }

    public Object[] consulta() {
        NasaApiDaoJpa dao = new NasaApiDaoJpa();
        
        Object[] consulta = dao.read();
  
        return consulta;
    }
    
    private List<NasaApiDto> getApiNasaAsteroids(String dataInicio, String dataFim, String KEY){
        
//        String dataInicio = "2024-07-05";
//        String dataFim = "2024-07-06";

            if (KEY.equals("")) {
                KEY = "DEMO_KEY";
            }

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
