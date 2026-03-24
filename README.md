# Auth API - Estudo de Arquiteturas

Este repositório contém diferentes implementações de uma API de Autenticação construída com **Java 17**, **Spring Boot** e **Spring Security**. O objetivo é servir como um laboratório para comparar padrões de organização de código e práticas de desenvolvimento.

## 📂 Arquiteturas Disponíveis

Atualmente, o projeto está dividido em duas abordagens principais:

### 1. [Arquitetura Limpa (clean_arq)](./clean_arq/)
Uma implementação seguindo os princípios de **Clean Architecture**, focada em manter as regras de negócio desacopladas de frameworks e detalhes de infraestrutura (como banco de dados e APIs externas).

- **Principais Pastas:** `domain`, `application`, `infra`.
- **Ideal para:** Sistemas complexos que precisam de testes de unidade robustos e flexibilidade para trocar componentes de infra sem afetar o core.

### 2. [Arquitetura em Camadas (modularizado)](./modularizado/)
Uma implementação seguindo o padrão tradicional **Layered Architecture** (Camadas), que é o padrão "de fato" em muitos projetos Spring Boot devido à sua simplicidade e agilidade de desenvolvimento.

- **Principais Pastas:** `controller`, `service`, `repository`, `model`.
- **Ideal para:** MVPs e aplicações de pequeno a médio porte onde a velocidade de entrega é prioridade.

---

## � Tecnologias Utilizadas
Em ambas as versões, as tecnologias core são as mesmas:
- **Java 17**
- **Spring Boot 3+**
- **Spring Security (JWT)**
- **PostgreSQL / Flyway**
- **Docker & Docker Compose**

## � Como Rodar
Cada pasta possui seu próprio ambiente isolado. Para instruções detalhadas de como executar cada versão, acesse o `README.md` dentro de sua respectiva pasta:

- [Instruções para clean_arq](./clean_arq/README.md)
- [Instruções para modularizado](./modularizado/README.md)
