# Clean Architecture implementation - Auto-Auth API

Esta versão da Auth API foi construída seguindo os princípios de **Clean Architecture**, focada em manter as regras de negócio puras e totalmente desacopladas de frameworks e detalhes externos (**DB**, **Security** etc).

A aplicação utiliza **PostgreSQL** como banco de dados relacional e gerencia a estrutura do banco usando migrations do **Flyway**. Além disso, o ambiente está totalmente preparado para rodar em containers usando **Docker** e **Docker Compose**.

## 🚀 Tecnologias Integradas

- **Java 17** 
- **Spring Boot 3+** (Web, Data JPA, Security, Persistence)
- **PostgreSQL**
- **Flyway** (Migrations de Banco de Dados)
- **JWT (jjwt)** para Autenticação Stateless
- **Lombok** (Para reduzir boilerplate)
- **Docker & Docker Compose**

## 📂 Estrutura de Pastas (Clean Architecture)

A organização do código segue a separação em camadas concêntricas:

### 1. `domain/`
O núcleo da aplicação. Contém as **Entidades** e regras de negócio puras que não dependem de nenhum framework ou detalhe externo.
- `User.java`: Entidade de domínio principal.

### 2. `application/`
Orquestra o fluxo de dados entre o domínio e o mundo externo.
- **`usecase/`**: Implementações das lógicas de negócio específicas da aplicação, como autenticação.
- **`providers/`**: Interfaces que definem os contratos que o mundo externo (infra) deve implementar (Dependency Inversion).

### 3. `infra/`
A camada externa que lida com todos os detalhes técnicos e frameworks.
- **`controller/`**: Adaptadores para a API REST.
- **`repository/`**: Implementações concretas de acesso ao banco (JpaUserRepository).
- **`security/`**: Toda a configuração do Spring Security e tratamento de tokens JWT.
- **`mapper/`**: Conversores entre as Entidades de Domínio e as Entidades de Infra/DTOs.

## 🛠 Pré-requisitos
Certifique-se de ter instalado em sua máquina:
- **Docker** e o **Docker Compose**
- *(Opcional)* Java 17 e Maven (para execução local)

## 🏃 Como rodar o projeto

Todo o ambiente está configurado no `compose.yaml`. Siga os passos:

1. Acesse a pasta `clean_arq`:
   ```bash
   cd clean_arq
   ```

2. Suba os containers:
   ```bash
   docker compose up -d --build
   ```

3. A aplicação estará disponível na porta `8080`.

## 🗄 Modelo do Banco (Migrations)
A estrutura das tabelas é definida através dos arquivos `.sql` localizados em `src/main/resources/db/migration/`. O Flyway lerá esses arquivos durante a inicialização para construir o esquema.

## 🛑 Parando a aplicação
```bash
docker compose stop
```
ou 
```bash
docker compose down
```
