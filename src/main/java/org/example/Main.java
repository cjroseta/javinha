package org.example;

public class Main {
    public static void main(String[] args) {
        OrdemBase ordem1 = new OrdemProducao("042", 2026, 8);
        OrdemBase ordem2 = new OrdemVeiculacao("015", 2026, 8);

        System.out.println(ordem1.getSequenciaCompleta());
        System.out.println(ordem2.getSequenciaCompleta());

        OrdemBase[] ordens = { ordem1, ordem2 };

        for (OrdemBase ordem : ordens) {
            System.out.println("Tipo: " + ordem.getTipo() + " -> " + ordem.getSequenciaCompleta());
        }
    }
}