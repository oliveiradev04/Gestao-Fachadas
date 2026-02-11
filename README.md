# 📌 Gestão de Fachadas --- API Backend

API REST desenvolvida utilizando **Java**, **Spring Boot** e
**PostgreSQL** para gerenciamento de clientes e projetos de fachadas
através de operações CRUD.

Este projeto foi criado com finalidade de estudo e prática em
desenvolvimento backend, aplicando conceitos de:

-   Programação Orientada a Objetos (POO)
-   Spring Boot
-   REST API
-   JPA / Hibernate
-   PostgreSQL
-   DTO Pattern
-   Relacionamentos entre entidades

------------------------------------------------------------------------

## 🚀 Funcionalidades

### 👤 Gestão de Clientes

-   Criar clientes
-   Listar todos os clientes
-   Buscar cliente por ID
-   Atualizar cliente
-   Deletar cliente

Campos:

-   id
-   nome
-   telefone
-   empresa
-   endereco

------------------------------------------------------------------------

### 🏗️ Gestão de Projetos de Fachada

CRUD completo de projetos relacionados a clientes.

Relacionamento:

-   Um cliente pode possuir vários projetos (ManyToOne).

Campos:

-   id
-   nomeProjeto
-   tipoFachada
-   dataInicio
-   cliente (chave estrangeira)

------------------------------------------------------------------------

## 🧱 Estrutura do Projeto

    com.oliveiradev.gestao_fachadas
    │
    ├── controller
    │   ├── ClientesController
    │   └── ProjetoFachadaController
    │
    ├── model
    │   ├── Clientes
    │   └── ProjetoFachada
    │
    ├── dto
    │   ├── ClientesDto
    │   └── ProjetoFachadaDto
    │
    └── repository
        ├── ClientesRepository
        └── ProjetoFachadaRepository

------------------------------------------------------------------------

## 🔗 Relacionamento entre entidades

    Clientes (1)  --------  (N) ProjetoFachada

Um cliente pode possuir vários projetos associados.

------------------------------------------------------------------------

## ⚙️ Tecnologias Utilizadas

-   Java
-   Spring Boot
-   Spring Web
-   Spring Data JPA
-   Hibernate
-   PostgreSQL
-   Maven
-   Jakarta Persistence API

------------------------------------------------------------------------

## ▶️ Como executar o projeto

### 1️⃣ Clonar o repositório

    git clone <URL_DO_REPOSITORIO>

------------------------------------------------------------------------

### 2️⃣ Configurar banco PostgreSQL

Criar banco:

    gestao_fachadas

Configurar no arquivo `application.properties`:

    spring.datasource.url=jdbc:postgresql://localhost:5432/gestao_fachadas
    spring.datasource.username=SEU_USUARIO
    spring.datasource.password=SUA_SENHA

------------------------------------------------------------------------

### 3️⃣ Executar aplicação

Via IDE (IntelliJ / Eclipse) ou usando Maven:

    mvn spring-boot:run

------------------------------------------------------------------------

## 📡 Endpoints

### Clientes

    GET    /clientes
    GET    /clientes/{id}
    POST   /clientes
    PUT    /clientes/{id}
    DELETE /clientes/{id}

------------------------------------------------------------------------

### Projeto Fachada

    GET    /projeto-fachada
    GET    /projeto-fachada/{id}
    POST   /projeto-fachada
    PUT    /projeto-fachada/{id}
    DELETE /projeto-fachada/{id}

------------------------------------------------------------------------

## 🧪 Exemplo JSON --- Criar Projeto

    {
      "nomeProjeto": "Fachada ACM Loja X",
      "tipoFachada": "ACM",
      "dataInicio": "2026-02-10",
      "clienteId": 1
    }

------------------------------------------------------------------------

## 🎯 Objetivo

Projeto desenvolvido para prática de desenvolvimento backend utilizando
Java e Spring Boot, focando em construção de APIs REST, modelagem de
banco de dados relacional e relacionamento entre entidades.
