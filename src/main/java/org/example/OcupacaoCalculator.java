package org.example;

import java.util.List;

/**
 * Calcula a ocupacao percentual de um painel com base na duracao total
 * das playlists agendadas.
 * Formula: (duracao total em ms / 3.600.000 ms) * 100, onde 1 hora = 100% de ocupacao.
 * Paralelo direto a scala_panel_occupancy.py.
 */
public class OcupacaoCalculator {

    // 1 hora = 3.600.000 milissegundos
    private static final double MS_POR_HORA = 3_600_000.0;

    /**
     * Soma as duracoes de uma lista de playlists e devolve a percentagem de ocupacao.
     * @param playlists lista de playlists a considerar
     * @return percentagem de ocupacao (100.0 = exatamente 1 hora de conteudo)
     */
    public double calcularOcupacao(List<Playlist> playlists) {
        long duracaoTotalMs = playlists.stream()
                .filter(playlist -> playlist.getDuracaoMs() > 0)
                .mapToLong(Playlist::getDuracaoMs)
                .sum();

        return (duracaoTotalMs / MS_POR_HORA) * 100;
    }
}
