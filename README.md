# aprendendoJava (javinha)

Projeto de aprendizagem estruturada de Java, seguindo o roteiro #aprendendoJava.
Recria conceitos e problemas reais do ecossistema Dalima (dalima_ordens,
dalima_scala_api) em Java, como forma de consolidar aprendizagem.

## Configuração local — Base de Dados (Fase 5)

- **Motor**: PostgreSQL 18 (instalação nativa no Windows)
- **Host**: localhost
- **Porta**: 5432
- **Base de dados**: aprendendojava
- **Utilizador**: postgres
- **Password**: guardada localmente, não documentada aqui

## Estrutura de branches

Cada fase do roteiro tem a sua própria branch (fase-N-descricao), sempre
mesclada (merge) para a `master` no final, e mantida como registo histórico
(nunca apagada).

## Fases concluídas

- [x] Fase 0 — Setup do ambiente (JDK 25, IntelliJ IDEA)
- [x] Fase 1 — Fundamentos da linguagem
- [x] Fase 2 — POO (herança, interfaces, polimorfismo, enums)
- [x] Fase 3 — Streams, lambdas, Optional, coleções
- [x] Fase 4 — Maven avançado + JUnit 5
- [ ] Fase 5 — JDBC e JPA/Hibernate (em curso)