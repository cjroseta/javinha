package org.example;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        OrdemBase ordem1 = new OrdemProducao("042", 2026, 8);
        OrdemBase ordem2 = new OrdemVeiculacao("015", 2026, 8);

        System.out.println(ordem1.getSequenciaCompleta());
        System.out.println(ordem2.getSequenciaCompleta());

        OrdemBase[] ordens = { ordem1, ordem2 };

        for (OrdemBase ordem : ordens) {
            System.out.println("Tipo: " + ordem.getTipo() + " --> " + ordem.getSequenciaCompleta());
        }

        ((OrdemProducao) ordem1).enviarNotificacao("Ordem pronta para produção.");

        EstadoOrdem estado = EstadoOrdem.CONFIRMADA;
        System.out.println("Estado: " + estado + " -> " + estado.getDescricao());

        // ---- NOVO: simulação de páginas da API Scala ----
        List<List<Playlist>> paginas = new ArrayList<>();

        List<Playlist> pagina1 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            pagina1.add(new Playlist("Playlist-" + i, 3_600_000));
        }

        List<Playlist> pagina2 = new ArrayList<>();
        for (int i = 11; i <= 18; i++) {
            pagina2.add(new Playlist("Playlist-" + i, 1_800_000));
        }

        paginas.add(pagina1);
        paginas.add(pagina2);

        System.out.println("Total de páginas simuladas: " + paginas.size());
        System.out.println("Playlists na página 1: " + pagina1.size());
        System.out.println("Playlists na página 2: " + pagina2.size());

        // ---- Resolver a paginação: juntar todas as páginas numa lista única ----
        // flatMap "achata" a lista de listas (List<List<Playlist>>) numa lista simples (List<Playlist>)
        // Isto é exatamente o que falta ao teu scala_api_client.py: continuar a agregar
        // páginas em vez de parar nos primeiros 10 resultados.
        List<Playlist> todasAsPlaylists = paginas.stream()
                .flatMap(pagina -> pagina.stream())
                .collect(Collectors.toList());

        System.out.println("Total real de playlists (todas as páginas agregadas): " + todasAsPlaylists.size());

        // ---- Filtrar e somar durações com Streams ----
        // Paralelo direto ao scala_panel_occupancy.py:
        // soma das durações (ms) de todas as playlistItems, para depois calcular a ocupação
        long duracaoTotalMs = todasAsPlaylists.stream()
                .filter(playlist -> playlist.getDuracaoMs() > 0)   // ignora playlists com duração inválida
                .mapToLong(playlist -> playlist.getDuracaoMs())     // extrai só o número (long) de cada playlist
                .sum();                                              // soma tudo

        System.out.println("Duração total (ms): " + duracaoTotalMs);

        // Fórmula de ocupação já usada em scala_panel_occupancy.py:
        // soma das durações (ms) ÷ 3600 × 100, onde 1 hora = 100% de ocupação
        double ocupacaoPercentual = (duracaoTotalMs / 3600000.0) * 100;
        System.out.println("Ocupação calculada: " + ocupacaoPercentual + "%");
    }
}