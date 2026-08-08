package org.example;

public abstract class OrdemBase {
    protected String sequencia;
    protected int ano;
    protected int mes;

    public OrdemBase(String sequencia, int ano, int mes) {
        this.sequencia = sequencia;
        this.ano = ano;
        this.mes = mes;
    }

    public abstract String getTipo();

    public String getSequenciaCompleta() {
        return getTipo() + "/" + ano + "/" + String.format("%02d", mes) + "/" + sequencia;
    }
}