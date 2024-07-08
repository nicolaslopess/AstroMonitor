/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.nasa;

/**
 *
 * @author Nicolas
 */
public class NasaApiDto {
    private String id;
    private String neoReferenceId;
    private String name;
    private String nasaJplUrl;
    private double absoluteMagnitudeH;
//    private EstimatedDiameter estimatedDiameter;
    private boolean isPotentiallyHazardousAsteroid;
//    private List<NEOCloseApproachData> closeApproachData;
    private boolean isSentryObject;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNeoReferenceId() {
        return neoReferenceId;
    }

    public void setNeoReferenceId(String neoReferenceId) {
        this.neoReferenceId = neoReferenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNasaJplUrl() {
        return nasaJplUrl;
    }

    public void setNasaJplUrl(String nasaJplUrl) {
        this.nasaJplUrl = nasaJplUrl;
    }

    public double getAbsoluteMagnitudeH() {
        return absoluteMagnitudeH;
    }

    public void setAbsoluteMagnitudeH(double absoluteMagnitudeH) {
        this.absoluteMagnitudeH = absoluteMagnitudeH;
    }

    public boolean isIsPotentiallyHazardousAsteroid() {
        return isPotentiallyHazardousAsteroid;
    }

    public void setIsPotentiallyHazardousAsteroid(boolean isPotentiallyHazardousAsteroid) {
        this.isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid;
    }

    public boolean isIsSentryObject() {
        return isSentryObject;
    }

    public void setIsSentryObject(boolean isSentryObject) {
        this.isSentryObject = isSentryObject;
    }
    
    
}
