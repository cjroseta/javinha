package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes da formula de ocupacao, cobrindo o caso normal e os casos-limite
 * combinados no roteiro #aprendendoJava: playlist vazia, duracao superior
 * a 1 hora, e valores invalidos (negativos).
 */
class OcupacaoCalculatorTest {

    // Instancia da classe a testar - reutilizada em todos os metodos de teste
    private final OcupacaoCalculator calculator = new OcupacaoCalculator();

    @Test
    void ocupacaoDeveSer100PorcentoParaUmaHoraExata() {
        // 1 playlist de exatamente 1 hora (3.600.000 ms) -> deve dar 100%
        List<Playlist> playlists = List.of(
                new Playlist("Playlist-1", 3_600_000)
        );

        double resultado = calculator.calcularOcupacao(playlists);

        // assertEquals com "delta" (0.001) porque comparar doubles exatamente
        // pode falhar por arredondamentos internos da JVM - nunca comparar
        // doubles com "==" ou assertEquals sem delta
        assertEquals(100.0, resultado, 0.001);
    }

    @Test
    void ocupacaoDeveSerZeroParaListaVazia() {
        // Lista vazia - caso-limite: nenhuma playlist agendada
        List<Playlist> playlists = List.of();

        double resultado = calculator.calcularOcupacao(playlists);

        assertEquals(0.0, resultado, 0.001);
    }

    @Test
    void ocupacaoDeveSerSuperiorA100PorcentoQuandoDuracaoExcedeUmaHora() {
        // 2 playlists de 1 hora cada = 2 horas de conteudo -> deve dar 200%
        List<Playlist> playlists = List.of(
                new Playlist("Playlist-1", 3_600_000),
                new Playlist("Playlist-2", 3_600_000)
        );

        double resultado = calculator.calcularOcupacao(playlists);

        assertEquals(200.0, resultado, 0.001);
    }

    @Test
    void ocupacaoDeveIgnorarPlaylistsComDuracaoInvalida() {
        // Uma playlist valida (1h) + uma com duracao negativa (dado corrompido/invalido)
        // O filter() dentro de calcularOcupacao deve ignorar a negativa
        List<Playlist> playlists = List.of(
                new Playlist("Playlist-Valida", 3_600_000),
                new Playlist("Playlist-Corrompida", -500)
        );

        double resultado = calculator.calcularOcupacao(playlists);

        // Resultado deve refletir apenas a playlist valida: 100%
        assertEquals(100.0, resultado, 0.001);
    }
}