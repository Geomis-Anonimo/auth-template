# Auth API

Esta é uma API de Autenticação construída com **Java 17**, **Spring Boot** e **Spring Security**, oferecendo um sistema robusto de gerenciamento de usuários e controle de acesso baseado em **JWT (JSON Web Token)**.

A aplicação utiliza **PostgreSQL** como banco de dados relacional e gerencia a estrutura do banco usando migrations do **Flyway**. Além disso, o ambiente está totalmente preparado para rodar em containers usando **Docker** e **Docker Compose**, o que facilita a execução do projeto com apenas um comando, sem necessidade de instalar bancos de dados localmente.

## 🚀 Tecnologias Integradas

- **Java 17** 
- **Spring Boot 3+** (Web, Data JPA, Security, Validation)
- **PostgreSQL**
- **Flyway** (Migrations de Banco de Dados)
- **JWT (jjwt)** para Autenticação Restless
- **Lombok** (Para reduzir boilerplates de código)
- **Docker & Docker Compose**

## 📂 Estrutura e Práticas
- **Banco de Dados Seguro:** O projeto não usa `ddl-auto: update` cegamente em produção. Utilizamos instâncias limpas do banco populadas diretamente pelo **Flyway** na subida do container, assegurando confiabilidade.
- **Autenticação:** Tokens JWT são gerados e validados por requisição usando as arquiteturas internas recomendadas pelo Spring Security.

## 🛠 Pré-requisitos
Certifique-se de ter instalado em sua máquina:
- **Docker** e o **Docker Compose**
- *(Opcional)* Java 17 e Maven (caso queira executar a aplicação sem o Docker usando uma IDE)

## 🏃 Como rodar o projeto

Todo o ambiente (inclusive o banco de dados) foi configurado no `compose.yaml`. Siga os passos:

1. Clone este repositório:
```bash
git clone <URL_DO_SEU_REPOSITORIO>
cd auth
```

2. Suba a aplicação e o banco em plano de fundo:
```bash
docker compose up -d --build
```
> O comando de build inicial pode levar alguns segundos, pois ele baixará a imagem do Maven e fará a instalação de todas as dependências do `pom.xml`.

3. A aplicação estará disponível na porta `8080` (A porta local do Postgres estará mapeada pra `5433` no seu host local se precisar se conectar via DBeaver / pgAdmin).

## 🗄 Modelo do Banco (Migrations)
A estrutura das tabelas é definida através dos arquivos `.sql` localizados em `src/main/resources/db/migration/`. O Flyway lerá esses arquivos durante a inicialização para construir o esquema antes mesmo do Spring Data mapeá-los.

## 🛑 Parando a aplicação
Para parar os containers sem perder os dados armazenados:
```bash
docker compose stop
```

Para parar os containers deletando toda a rede criada (atenção, o banco mantem persistência por causa do uso flexível de Volumes gerados pelo Postgres, porém rodar com prunes adicionais apaga dados locais):
```bash
docker compose down
```
