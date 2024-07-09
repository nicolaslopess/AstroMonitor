package br.com.astromonitor.astromonitor.resources.service.api.planetario;

import java.util.Date;

public class PlanetarioAsteroid {
    private int id;
    private String idObjetoNasa;
    private String nomeAsteroid;
    private String nasaJplUrl;
    private float diameterMinM;
    private float diameterMaxM;
    private boolean risco;
    private Date dataAproximacao;
    private float velocidade;
    private float distanciaDaTerra;
    private String orbitando;

    // Getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdObjetoNasa() {
        return idObjetoNasa;
    }

    public void setIdObjetoNasa(String idObjetoNasa) {
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

    public float getDiameterMinM() {
        return diameterMinM;
    }

    public void setDiameterMinM(float diameterMinM) {
        this.diameterMinM = diameterMinM;
    }

    public float getDiameterMaxM() {
        return diameterMaxM;
    }

    public void setDiameterMaxM(float diameterMaxM) {
        this.diameterMaxM = diameterMaxM;
    }

    public boolean isRisco() {
        return risco;
    }

    public void setRisco(boolean risco) {
        this.risco = risco;
    }

    public Date getDataAproximacao() {
        return dataAproximacao;
    }

    public void setDataAproximacao(Date dataAproximacao) {
        this.dataAproximacao = dataAproximacao;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    public float getDistanciaDaTerra() {
        return distanciaDaTerra;
    }

    public void setDistanciaDaTerra(float distanciaDaTerra) {
        this.distanciaDaTerra = distanciaDaTerra;
    }

    public String getOrbitando() {
        return orbitando;
    }

    public void setOrbitando(String orbitando) {
        this.orbitando = orbitando;
    }
}
