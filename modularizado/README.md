# Layered Architecture implementation - Auth API

Esta versão da Auth API segue uma organização tradicional em camadas (**Layered Architecture**), ideal para uma compreensão rápida e desenvolvimento ágil com o ecossistema **Spring Boot**.

A aplicação utiliza os padrões clássicos do Spring para separação de responsabilidades (Controller-Service-Repository).

## 📂 Estrutura de Pastas (Arquitetura em Camadas)

Diferente da versão *Clean*, aqui as responsabilidades são separadas por tipo técnico e integradas diretamente ao framework:

- **`controller/`**: Define os endpoints REST e faz a validação dos dados de entrada.
- **`service/`**: Onde as regras de negócio residem. Orquestra a manipulação dos dados entre repositórios e serviços de terceiros.
- **`repository/`**: Interfaces que estendem `JpaRepository` para lidar com a persistência de dados.
- **`model/`**: Entidades representativas do banco de dados (PostgreSQL).
- **`dto/`**: Onde ficam os objetos de entrada e saída (Request/Response), garantindo que a entidade interna não vaze diretamente para a API.
- **`security/`**: Concentra toda a configuração de autenticação JWT e filtros do Spring Security.
- **`exception/`**: Define exceções customizadas e o `GlobalExceptionHandler` para fornecer mensagens de erro amigáveis ao cliente.
- **`config/`**: Classes de configuração do ambiente e definição de Beans.
- **`interfaces/`** & **`implementations/`**: Local para separação entre contratos e suas implementações concretas de serviços genéricos.

## 🚀 Como Executar

A estrutura utiliza Maven como gerenciador de dependências.

1. Navegue até a pasta:
   ```bash
   cd modularizado
   ```

2. Certifique-se de ter um banco **PostgreSQL** rodando (conforme configuração no `application.yaml`).

3. Execute a aplicação usando o Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

## 🛠 Tecnologias
- **Java 17**
- **Spring Boot 3+**
- **Spring Security (JWT)**
- **JPA / Hibernate**
- **PostgreSQL**
