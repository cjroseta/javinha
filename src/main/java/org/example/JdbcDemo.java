package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Demonstracao de JDBC "puro" - o nivel mais baixo de acesso a base de dados
 * em Java, sem nenhuma abstracao (ORM) por cima. Serve para perceber o que
 * o JPA/Hibernate vai automatizar mais tarde nesta mesma Fase 5.
 */
public class JdbcDemo {

    // URL de ligacao: protocolo jdbc:postgresql, seguido de host:porta/base de dados
    // Este e o mesmo formato que vimos no campo "URL" do Database Tool do IntelliJ
    private static final String URL = "jdbc:postgresql://localhost:5432/aprendendojava";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin2600";

    public static void main(String[] args) {
        // try-with-resources: a Connection e fechada automaticamente no final
        // do bloco try, mesmo que ocorra um erro - evita ligacoes "esquecidas"
        // abertas, algo que em Python farias com "with psycopg2.connect(...) as conn:"
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("Ligacao estabelecida com sucesso!");

            // Inserir uma playlist de teste
            String sqlInsert = "INSERT INTO playlist (nome, duracao_ms) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sqlInsert)) {
                // "?" sao placeholders - PreparedStatement evita SQL Injection,
                // substituindo os valores de forma segura, nunca concatenando texto diretamente
                stmt.setString(1, "Playlist-JDBC-Teste");
                stmt.setLong(2, 3_600_000L);
                stmt.executeUpdate();
                System.out.println("Playlist inserida com sucesso.");
            }

            // Ler todas as playlists gravadas
            String sqlSelect = "SELECT id, nome, duracao_ms FROM playlist";
            try (PreparedStatement stmt = conn.prepareStatement(sqlSelect);
                 ResultSet rs = stmt.executeQuery()) {

                System.out.println("Playlists na base de dados:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    long duracaoMs = rs.getLong("duracao_ms");
                    System.out.println(id + " | " + nome + " | " + duracaoMs + "ms");
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao ligar/consultar a base de dados: " + e.getMessage());
        }
    }
}