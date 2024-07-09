package br.com.astromonitor.astromonitor.resources.service.api.planetario;

import java.util.Date;

public class PlanetarioRecentActivity {
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
