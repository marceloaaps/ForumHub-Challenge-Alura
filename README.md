# <img width="28px" margin="0px"  src="https://img.icons8.com/?size=100&id=103407&format=png&color=000000"> Alura Challenge - Forumhub <img width="28px" margin="0px"  src="https://img.icons8.com/?size=100&id=103407&format=png&color=000000">

Feito totalmente por mim, esse projeto vem do desafio final 
da formação Oracle Next Education, apresentado pela Alura em Java 
com Spring Framework. O objetivo é criar um fórum como API Stateless, 
contendo funções como: Perfis de usuários, Tópicos, Respostas desses tópicos e 
diversos outros endpoints.


## Ferramentas Utilizadas <img width="25px" src="https://img.icons8.com/?size=100&id=600MeI55fCza&format=png&color=000000">
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


## Conceitos Utilizados <img width="25px" src="https://img.icons8.com/?size=100&id=81348&format=png&color=000000">
- Clean Architecture 
- Clean Code
- Single Responsibility Principle (SRP)
- Migrations-Based Versioning (MBV)
- Domain Driven Design (DDD)
- Soft Delete
- REST API

## Funcionalidades <img width="25px" src="https://img.icons8.com/?size=100&id=SqtU1cqaoDxt&format=png&color=000000">

- Criação de Usuários
- Criação de Tópicos
- Adição de Resposta a esses tópicos
- Listagem de Usuários, Tópicos e Respostas
- Deleção e alteração de tópicos e respostas.
- Deleção de Usuários

## Screenshots <img width="26px"  src="https://img.icons8.com/?size=100&id=nevTPff0KmQx&format=png&color=000000">

- Springdoc com Swagger
![App Screenshot](https://i.imgur.com/kgGr9F9.png)

- Exemplo de documentação.
![App Screenshot](https://i.imgur.com/pkNWamM.png)

- Exemplo Request para Retornar todos tópicos.
![App Screenshot](https://i.imgur.com/aZF9sDR.png)

- Diagrama Banco de Dados MySQL
![App Screenshot](https://i.imgur.com/ikHPAfd.png)



## Variáveis de Ambiente <img width="26px"  src="https://img.icons8.com/?size=100&id=55167&format=png&color=000000">

Para rodar esse projeto, você vai precisar adicionar as seguintes variáveis de ambiente no seu sistema.

`DB_NAME` - Nome do Banco de Dados

`DB_USER` - Nome do usuário do Banco de Dados.

`DB_PASSWORD` - Senha do usuário com acesso ao Banco de Dados.

`SERVER_PORT` - Porta do servidor de acesso. Padrão será 8080.

`JWT_SECRET` - Security token do JWT.



## Aprendizados <img width="26px"  src="https://img.icons8.com/?size=100&id=103808&format=png&color=000000">

Nesse projeto foi agregado a mim muito conhecimento em relação ao framework Spring, especialmente Spring Security do porquê utilizar de forma Stateless, quando utilizar, como utilizar e manipular para o funcionamento de forma correta. Aprendi também sobre a utilização das bibliotecas Lombok, MapStruct e também da utilização do Flyway para migração de banco de dados. 

## Documentação da API <img width="26px"  src="https://img.icons8.com/?size=100&id=AWNz4SeVAd8y&format=png&color=000000">

Documentação de cada endpoint, cada desejado, está mais detalhado na documentação Swagger na aplicação.

- Topico

    #### Retorna todos os tópicos

    ```http
  GET /topicos/buscar-todos
    ```

    | Parâmetro   | Tipo       | Descrição                           |
    | :---------- | :--------- | :---------------------------------- |
    | null | null | **Obrigatório**. Bearer Token de autenticação. |

    #### Retorna um tópico

    ```http
    GET /topicos/buscar-topico/${id}
    ```

    | Parâmetro   | Tipo       | Descrição                                   |
    | :---------- | :--------- | :------------------------------------------ |
    | `id`      | `Long` | **Obrigatório**. O ID do item que você quer |



    #### Atualiza o tópico	
    ```http
    GET /topicos/buscar-topico/${id}
    ```
    

    | Parâmetro   | Tipo       | Corpo                                   |
    | :---------- | :--------- | :------------------------------------------ |
    | `id`      | `Long` | O ID do tópico que deseja atualizar |
    | `Mensagem`      | `String` | Mensagem desejada a atualizar.|



    ```http
    GET /topicos/buscar-topico/${id}
    ```
    | Parâmetro   | Tipo       | Descrição                                   |
    | :---------- | :--------- | :------------------------------------------ |
    | `id`      | `Long` | **Obrigatório**. O ID do item que você quer |









## Documentação <img width="26px"  src="https://img.icons8.com/?size=100&id=LxtV1REKsCa5&format=png&color=000000">

[Documentação](https://link-da-documentação)

