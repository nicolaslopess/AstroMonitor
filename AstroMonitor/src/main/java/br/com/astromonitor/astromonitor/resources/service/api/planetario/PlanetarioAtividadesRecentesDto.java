/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.astromonitor.astromonitor.resources.service.api.planetario;

import java.sql.Date;

/**
 *
 * @author Nicolas
 */
public class PlanetarioAtividadesRecentesDto {
    private Date dataAproximacao;
    private int numeroDeObjetosDetectados;

    public Date getDataAproximacao() {
        return dataAproximacao;
    }

    public void setDataAproximacao(Date dataAproximacao) {
        this.dataAproximacao = dataAproximacao;
    }

    public int getNumeroDeObjetosDetectados() {
        return numeroDeObjetosDetectados;
    }

    public void setNumeroDeObjetosDetectados(int numeroDeObjetosDetectados) {
        this.numeroDeObjetosDetectados = numeroDeObjetosDetectados;
    }
    
    
}