# Movieflix

Movieflix é uma aplicação de gerenciamento de filmes e categorias, construída com Spring Boot. A aplicação permite que os usuários registrem, autentiquem e gerenciem filmes, categorias e streamings.

## Funcionalidades

- Registro e autenticação de usuários.
- Gerenciamento de filmes, categorias e streamings.
- Relacionamento entre filmes, categorias e streamings.
- API RESTful com validação de dados.
- Segurança com autenticação JWT.
- Integração com banco de dados PostgreSQL usando JPA e Flyway.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4.0**
- **Spring Security**
- **JWT (JSON Web Token)**
- **PostgreSQL**
- **Flyway**
- **Lombok**
- **Maven**

## Estrutura do Projeto

```plaintext
src/
├── main/
│   ├── java/
│   │   └── dev.movie.Movieflix/
│   │       ├── config/          # Configurações de segurança e JWT
│   │       ├── controller/      # Controladores REST
│   │       ├── entity/          # Entidades JPA
│   │       ├── exceptions/      # Exceções personalizadas
│   │       ├── mapper/          # Mapeadores de DTOs
│   │       ├── repository/      # Repositórios JPA
│   │       └── service/         # Lógica de negócios
│   └── resources/
│       ├── application.yaml     # Configurações da aplicação
│       └── db/
│           └── migration/       # Scripts de migração Flyway
└── test/
    └── java/                    # Testes unitários
``` 



## Endpoints Principais

- Autenticação
POST /auth/register - Registro de usuário.
POST /auth/login - Login e geração de token JWT.
- Filmes
POST /movieflix/movie - Adicionar um novo filme.
GET /movieflix/movie - Listar todos os filmes.
GET /movieflix/movie/{id} - Buscar filme por ID.
PUT /movieflix/movie/{id} - Atualizar um filme.
DELETE /movieflix/movie/{id} - Deletar um filme.
- Categorias
POST /movieflix/category - Adicionar uma nova categoria.
GET /movieflix/category - Listar todas as categorias.
GET /movieflix/category/{id} - Buscar categoria por ID.
DELETE /movieflix/category/{id} - Deletar uma categoria.
- Streamings
POST /movieflix/streaming - Adicionar um novo streaming.
GET /movieflix/streaming - Listar todos os streamings.
GET /movieflix/streaming/{id} - Buscar streaming por ID.
DELETE /movieflix/streaming/{id} - Deletar um streaming.
Testes
Para rodar os testes, execute:

```bash
./mvnw test
```