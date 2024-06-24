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

public class AtividadeRecente {
    private Date dataDeteccao;
    private int quantidade;

    public Date getDataDeteccao() {
        return dataDeteccao;
    }

    public void setDataDeteccao(Date dataDeteccao) {
        this.dataDeteccao = dataDeteccao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Getters and setters

    public AtividadeRecente(Date dataDeteccao, int quantidade) {
        this.dataDeteccao = dataDeteccao;
        this.quantidade = quantidade;
    }
    
}
