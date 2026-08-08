package org.example;

public class OrdemProducao extends OrdemBase {

    public OrdemProducao(String sequencia, int ano, int mes) {
        super(sequencia, ano, mes);
    }

    @Override
    public String getTipo() {
        return "PROD";
    }
}