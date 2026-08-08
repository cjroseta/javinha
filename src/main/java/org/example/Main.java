package org.example;

public class Main {
    public static void main(String[] args) {
        int idade = 30;
        double altura = 1.75;

        // Operadores aritmeticos e comparação
        int anoNascimento = 2026 - idade;
        boolean maiorDeIdade = idade >= 18;

        System.out.println("Ano de nascimento aproximado: " + anoNascimento);
        System.out.println("É maior de idade: " + maiorDeIdade);

        // if / else
        if (idade >= 18) {
            System.out.println("Pode assinar contratos.");
        } else {
            System.out.println("Não pode assinar contratos.");
        }

        // Arrays - tamanho fixo
        String[] tecnologias = {"Java", "Python", "Odoo", "PostgreSQL"};
        System.out.println("Número de tecnologias: " + tecnologias.length);

        for (int i = 0; i < tecnologias.length; i++) {
            System.out.println((i + 1) + ". " + tecnologias[i]);
        }
    }
}