# Blogging Platform API

Projeto feito seguindo o roadmap de projetos do [roadmap.sh](https://roadmap.sh/projects/blogging-platform-api), com o objetivo de praticar Java, Spring Boot e desenvolvimento de APIs REST completas.

## Descrição

O **Blogging Platform API** é uma aplicação backend que permite gerenciar posts de um blog.  
A API permite criar, listar, buscar, atualizar e deletar posts, além de filtrar por palavras-chave.

## Tecnologias utilizadas

- **Java** – Linguagem principal
- **Spring Boot** – Framework para construção da API
- **Maven** – Gerenciador de dependências
- **REST API** – Interface de comunicação baseada em HTTP
- **Postman** – Testes dos endpoints
- **MySQL** – Banco de dados

## Como rodar o projeto

### 1. Baixe ou clone o repositório

```bash
git clone https://github.com/JessicaLorenzon/blogging-platform-api.git
cd target
```

### 2. Execute o aplicativo:

```bash
java -jar blogging-platform-api-0.0.1.jar
```

## Endpoints disponíveis

### 1. Buscar todos os posts

```http
GET /posts
```

### 2. Buscar post único

```http
GET /posts/{postId}
```

### 3. Criar novo post

```http
POST /posts
```

#### Payload (JSON):

```json
{
  "title": "My First Blog Post",
  "content": "This is the content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"]
}
```

### 4. Atualizar post

```http
PUT /posts/{postId}
```

#### Payload (JSON):

```json
{
  "title": "My Updated Blog Post",
  "content": "This is the updated content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"]
}
```

### 5. Deletar post

```http
DELETE /posts/{postId}
```

### 6. Filtrar por palavra-chave

```http
GET /posts?term={keyword}
```
