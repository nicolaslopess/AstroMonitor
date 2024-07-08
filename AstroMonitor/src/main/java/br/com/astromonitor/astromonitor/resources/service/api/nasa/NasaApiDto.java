/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.nasa;


import java.sql.Date;

/**
 *
 * @author Nicolas
 */
public class NasaApiDto {
   
    private Integer idObjetoNasa;
    private String nomeAsteroid;
    private String nasaJplUrl;
    private Double diameterMinM;
    private Double diameterMaxM;
    private Boolean risco;
    private Date dataAproximacao;
    private Double velocidade;
    private Double distanciaDaTerra;
    private String orbitando;

    public Integer getIdObjetoNasa() {
        return idObjetoNasa;
    }

    public void setIdObjetoNasa(Integer idObjetoNasa) {
        this.idObjetoNasa = idObjetoNasa;
    }

    public String getNomeAsteroid() {
        return nomeAsteroid;
    }

    public void setNomeAsteroid(String nomeAsteroid) {
        this.nomeAsteroid = nomeAsteroid;
    }

    public String getNasaJplUrl() {
        return nasaJplUrl;
    }

    public void setNasaJplUrl(String nasaJplUrl) {
        this.nasaJplUrl = nasaJplUrl;
    }

    public Double getDiameterMinM() {
        return diameterMinM;
    }

    public void setDiameterMinM(Double diameterMinM) {
        this.diameterMinM = diameterMinM;
    }

    public Double getDiameterMaxM() {
        return diameterMaxM;
    }

    public void setDiameterMaxM(Double diameterMaxM) {
        this.diameterMaxM = diameterMaxM;
    }

    public Boolean getRisco() {
        return risco;
    }

    public void setRisco(Boolean risco) {
        this.risco = risco;
    }

    public Date getDataAproximacao() {
        return dataAproximacao;
    }

    public void setDataAproximacao(Date dataAproximacao) {
        this.dataAproximacao = dataAproximacao;
    }

    public Double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Double velocidade) {
        this.velocidade = velocidade;
    }

    public Double getDistanciaDaTerra() {
        return distanciaDaTerra;
    }

    public void setDistanciaDaTerra(Double distanciaDaTerra) {
        this.distanciaDaTerra = distanciaDaTerra;
    }

    public String getOrbitando() {
        return orbitando;
    }

    public void setOrbitando(String orbitando) {
        this.orbitando = orbitando;
    }

    
    
    
}
