/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.nasa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Nicolas
 */
public class NasaApiConversorFactory {

    public List<NasaApiDto> converterJsonToNasaApiDto(JSONObject josnAPI) {

        List<NasaApiDto> retorno = new ArrayList<>();

        JSONObject nearEarthObjects = josnAPI.getJSONObject("near_earth_objects");

        for (String dateKey : nearEarthObjects.keySet()) {
            JSONArray dateArray = nearEarthObjects.getJSONArray(dateKey);
            for (int i = 0; i < dateArray.length(); i++) {
                JSONObject asteroid = dateArray.getJSONObject(i);

                NasaApiDto nasaApiDto = new NasaApiDto();
                nasaApiDto.setIdObjetoNasa(asteroid.getInt("id"));
                nasaApiDto.setNomeAsteroid(asteroid.getString("name"));
                nasaApiDto.setNasaJplUrl(asteroid.getString("nasa_jpl_url"));
                nasaApiDto.setRisco(asteroid.getBoolean("is_potentially_hazardous_asteroid"));

                JSONObject closeApproachData = asteroid.getJSONArray("close_approach_data").getJSONObject(0);
                String closeApproachDateStr = closeApproachData.getString("close_approach_date");
                Date closeApproachDate = Date.valueOf(closeApproachDateStr);
                nasaApiDto.setDataAproximacao(closeApproachDate);

                nasaApiDto.setDistanciaDaTerra(closeApproachData.getJSONObject("miss_distance").getDouble("kilometers"));
                nasaApiDto.setVelocidade(closeApproachData.getJSONObject("relative_velocity").getDouble("kilometers_per_hour"));

                JSONObject estimatedDiameter = asteroid.getJSONObject("estimated_diameter").getJSONObject("meters");
                nasaApiDto.setDiameterMinM(estimatedDiameter.getDouble("estimated_diameter_min"));
                nasaApiDto.setDiameterMaxM(estimatedDiameter.getDouble("estimated_diameter_max"));

                nasaApiDto.setOrbitando(closeApproachData.getString("orbiting_body"));

                retorno.add(nasaApiDto);
            }
        }
        return retorno;
    }
}
