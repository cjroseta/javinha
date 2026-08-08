package org.example;

public class OrdemVeiculacao extends OrdemBase {

    public OrdemVeiculacao(String sequencia, int ano, int mes) {
        super(sequencia, ano, mes);
    }

    @Override
    public String getTipo() {
        return "VEIC";
    }
}