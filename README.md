
# Alura Challenge - Forumhub

Feito totalmente por mim, esse projeto vem do desafio final 
da formação Oracle Next Education, apresentado pela Alura em Java 
com Spring Framework. O objetivo é criar um fórum como API Stateless, 
contendo funções como: Perfis de usuários, Tópicos, Respostas desses tópicos e 
diversos outros endpoints.


## Ferramentas Utilizadas
- Java 17
- Maven 
- Hibernate
- Spring Boot 3
- Spring Data JPA
- Spring Security
- Spring Test
- JWT
- Lombok
- MySQL
- Flyway Migrations
- MapStruct
- Springdoc / Swagger
- Insomnia


## Conceitos Utilizados
- Clean Architecture 
- Clean Code
- Single Responsibility Principle (SRP)
- Migrations-Based Versioning (MBV)
- Domain Driven Design (DDD)
- Soft Delete
- REST API

## Funcionalidades

- Criação de Usuários
- Criação de Tópicos
- Adição de Resposta a esses tópicos
- Listagem de Usuários, Tópicos e Respostas
- Deleção e alteração de tópicos e respostas.
- Deleção de Usuários

## Screenshots

- Springdoc com Swagger
![App Screenshot](https://i.imgur.com/kgGr9F9.png)

- Exemplo de documentação.
![App Screenshot](https://i.imgur.com/pkNWamM.png)

- Exemplo Request para Retornar todos tópicos.
![App Screenshot](https://i.imgur.com/aZF9sDR.png)

- Diagrama Banco de Dados MySQL
![App Screenshot](https://i.imgur.com/ikHPAfd.png)



## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar adicionar as seguintes variáveis de ambiente no seu sistema.

`DB_NAME` - Nome do Banco de Dados

`DB_USER` - Nome do usuário do Banco de Dados.

`DB_PASSWORD` - Senha do usuário com acesso ao Banco de Dados.

`SERVER_PORT` - Porta do servidor de acesso. Padrão será 8080.

`JWT_SECRET` - Security token do JWT.



## Aprendizados

O que você aprendeu construindo esse projeto? Quais desafios você enfrentou e como você superou-os?

## Documentação da API

#### Retorna todos os itens

```http
  GET /api/items
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `api_key` | `string` | **Obrigatório**. A chave da sua API |

#### Retorna um item

```http
  GET /api/items/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer |

#### add(num1, num2)

Recebe dois números e retorna a sua soma.
## Documentação

[Documentação](https://link-da-documentação)

