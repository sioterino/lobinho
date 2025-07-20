> [!IMPORTANT]
> Ler 'Como Executar' antes de iniciar o programa.

> [!INFO]
> Programa desenvolvido com Java 21. Mas apto a rodar em Java 17.

# Lobinho - Sistema de Gestão de Escoteiros via Terminal

**Lobinho** é um sistema de gerenciamento de escoteiros projetado para funcionar em ambiente de terminal, utilizando entrada de dados via `Scanner`. A aplicação foi construída com ênfase no uso de Spring Boot e JPA para reforçar conceitos de persistência e arquitetura em camadas, aplicada a um cenário didático.

## Objetivo

Este projeto tem como objetivo principal a aplicação prática dos conceitos de **Spring Boot** e **JPA (Java Persistence API)**, com integração a banco de dados relacional e estruturação do código segundo princípios de orientação a objetos e funcional, seguindo um padrão arquitetural em camadas.

## Arquitetura

A aplicação segue a **arquitetura em camadas**, com as seguintes divisões:

* `Model`: representação das entidades do domínio.
* `Repository`: abstração da camada de persistência com Spring Data JPA.
* `Service`: implementação das regras de negócio.
* `Controller`: controle de fluxo da aplicação e ponto de entrada via terminal.

A estrutura do projeto mistura paradigmas **orientado a objetos** e **funcional**, promovendo clareza e reusabilidade do código.

## Ferramentas Utilizadas

* **Java 21**
* **Spring Boot**
* **Spring Data JPA**
* **Lombok**
* **MySQL**
* **MySQL Workbench**
* **Docker**
* **IntelliJ IDEA**

## Como Executar

Para executar corretamente o sistema, siga os seguintes passos:

1. **Subir o container do banco de dados via Docker**:
   Certifique-se de que o container com o banco MySQL esteja ativo.

```bash
docker run -d --rm -p 3306:3306 -e MYSQL_ROOT_PASSWORD=senhaRoot -e MYSQL_DATABASE=bcd -e MYSQL_USER=aluno -e MYSQL_PASSWORD=aluno -e MYSQL_ROOT_HOST='%' --name meumysql mysql/mysql-server:latest
```

2. **Executar o script SQL**:

   * Abra o MySQL Workbench.
   * Conecte-se ao container do banco.
   * Execute o arquivo `ddl-dml.sql` para criar e popular o banco de dados `sofiadb`.

3. **Conectar o projeto ao banco de dados**:

   * Configure a conexão ao banco `sofiadb` nas propriedades do projeto.

4. **Executar a aplicação**:

   * **Preferencialmente execute pela interface do IntelliJ IDEA**, visto que o uso do `System.in` pode apresentar conflito com o console padrão quando executado por outros meios no Spring Boot.

## Desenvolvedora

Projeto desenvolvido por **Sofia Alves Toreti**, estudante do **3º semestre de Análise e Desenvolvimento de Sistemas (2025.1)**, sob orientação da professora **Ana Luiza Scharf**, na disciplina de **Banco de Dados**.

## Considerações Finais

Este projeto foi desenvolvido com foco educacional para consolidar conhecimentos em desenvolvimento Java com persistência de dados, organização modular de código e boas práticas de desenvolvimento com frameworks modernos.
