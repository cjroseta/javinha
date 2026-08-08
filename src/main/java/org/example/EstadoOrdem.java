package org.example;

public enum EstadoOrdem {
    RASCUNHO("Em preparação"),
    CONFIRMADA("Confirmada, aguarda produção"),
    CONCLUIDA("Finalizada com sucesso");

    private final String descricao;

    EstadoOrdem(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}