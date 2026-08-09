package org.example;

public class Playlist {
    private String nome;
    private long duracaoMs;

    public Playlist(String nome, long duracaoMs) {
        this.nome = nome;
        this.duracaoMs = duracaoMs;
    }

    public String getNome() {
        return nome;
    }

    public long getDuracaoMs() {
        return duracaoMs;
    }

    @Override
    public String toString() {
        return nome + " (" + duracaoMs + "ms)";
    }
}
