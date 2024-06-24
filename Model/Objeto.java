/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LarissaJoanaHelfer
 */
import java.sql.Date;

public class Objeto {
    private String nome;
    private Date dataAproximacao;
    private double distancia;
    private double velocidade;
    private double tamanho;
    private boolean potencialRisco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataAproximacao() {
        return dataAproximacao;
    }

    public void setDataAproximacao(Date dataAproximacao) {
        this.dataAproximacao = dataAproximacao;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isPotencialRisco() {
        return potencialRisco;
    }

    public void setPotencialRisco(boolean potencialRisco) {
        this.potencialRisco = potencialRisco;
    }

    public Objeto(String nome, Date dataAproximacao, double distancia, boolean potencialRisco) {
        this.nome = nome;
        this.dataAproximacao = dataAproximacao;
        this.distancia = distancia;
        this.potencialRisco = potencialRisco;
    }
    
}
