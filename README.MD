# Documentação da API

## Configuração da Aplicação

### Configuração de Portas e Banco de Dados

A aplicação é configurada através do arquivo `application.properties` localizado em `src/main/resources`. Abaixo estão as principais configurações:

- **Porta da Aplicação**:
  - **Propriedade**: `server.port`
  - **Valor**: `8081`
  - **Descrição**: A aplicação será executada na porta 8081.
  
- **Instruções de Instalação do Banco de Dados**:
Para configurar o banco de dados PostgreSQL para a aplicação, siga os passos abaixo:
  - **1. Instalar PostgreSQL**: Certifique-se de que o PostgreSQL está instalado em sua máquina. Você pode baixar e instalar o PostgreSQL a partir do [site oficial do PostgreSQL](https://www.postgresql.org/download/).
  - **2. Criar o Banco de Dados**: Antes de executar a aplicação, você precisa criar um banco de dados PostgreSQL chamado `gerenciaprojetos`. Utilize o seguinte comando SQL para criar o banco de dados:
```sql
CREATE DATABASE gerenciaprojetos;
```

- **Configuração do Banco de Dados**:
  - **URL**: `spring.datasource.url`
    - **Valor**: `jdbc:postgresql://localhost:5432/gerenciaprojetos`
    - **Descrição**: URL de conexão com o banco de dados PostgreSQL. O banco de dados é acessado no `localhost` na porta `5432`, e o nome do banco é `gerenciaprojetos`.
  - **Usuário**: `spring.datasource.username`
    - **Valor**: `postgres`
    - **Descrição**: Nome de usuário para conexão com o banco de dados.
  - **Senha**: `spring.datasource.password`
    - **Valor**: `root`
    - **Descrição**: Senha para a conexão com o banco de dados.
  - **Driver**: `spring.datasource.driver-class-name`
    - **Valor**: `org.postgresql.Driver`
    - **Descrição**: Driver JDBC para PostgreSQL.
  - **Dialeto Hibernate**: `spring.jpa.properties.hibernate.dialect`
    - **Valor**: `org.hibernate.dialect.PostgreSQLDialect`
    - **Descrição**: Dialeto específico para PostgreSQL, utilizado pelo Hibernate.
  - **Auto Criação do Banco de Dados**: `spring.jpa.hibernate.ddl-auto`
    - **Valor**: `update`
    - **Descrição**: Configuração para atualização do esquema do banco de dados conforme as entidades do JPA.

### Configuração de Frontend

- **Templates**:
  - **Caminho**: `desafio/src/main/resources/templates`
  - **Descrição**: Localização dos arquivos de template Thymeleaf para as páginas web.

- **JavaScript**:
  - **Caminho**: `desafio/src/main/resources/static/js`
  - **Descrição**: Localização dos arquivos JavaScript estáticos utilizados no frontend.

## Dependências

O projeto utiliza as seguintes dependências, definidas no arquivo `pom.xml`:

- **Spring Boot Starter Data JPA**:
  - **Artefato**: `spring-boot-starter-data-jpa`
  - **Descrição**: Fornece suporte para a integração com JPA (Java Persistence API), que é utilizado para a persistência de dados no banco de dados.

- **Spring Boot Starter Validation**:
  - **Artefato**: `spring-boot-starter-validation`
  - **Descrição**: Oferece suporte para validação de dados com anotações do Hibernate Validator.

- **Spring Boot Starter Web**:
  - **Artefato**: `spring-boot-starter-web`
  - **Descrição**: Inclui as dependências necessárias para criar uma aplicação web com Spring MVC e RESTful APIs.

- **PostgreSQL Driver**:
  - **Artefato**: `postgresql`
  - **Descrição**: Driver JDBC necessário para conectar a aplicação ao banco de dados PostgreSQL.

- **Lombok**:
  - **Artefato**: `lombok`
  - **Descrição**: Biblioteca para reduzir o código boilerplate, como getters, setters, e construtores.

- **Spring Boot Starter Test**:
  - **Artefato**: `spring-boot-starter-test`
  - **Descrição**: Inclui as dependências necessárias para realizar testes com JUnit e outras bibliotecas de testes.

- **Spring Boot Starter Thymeleaf**:
  - **Artefato**: `spring-boot-starter-thymeleaf`
  - **Descrição**: Suporte para usar Thymeleaf como motor de templates para renderização de páginas web.
  
- **Flyway**:
  - **Artefato**: `flyway-core`
  - **Descrição**: Dependência principal do Flyway para gerenciar migrações de banco de dados.
  
- **Flyway para PostgreSQL**:
  - **Artefato**: `spring-boot-starter-thymeleaf`
  - **Descrição**: Suporte específico do Flyway para migrações em bancos de dados PostgreSQL.

## Endpoints para `Projeto`

### 1. Listar Todos os Projetos

- **Método**: `GET`
- **URI**: `http://localhost:8081/api/projetos`
- **Descrição**: Retorna a lista de todos os projetos.

### 2. Obter um Projeto por ID

- **Método**: `GET`
- **URI**: `http://localhost:8081/api/projetos/{id}`
- **Descrição**: Retorna os detalhes de um projeto específico pelo seu ID.

### 3. Criar um Novo Projeto

- **Método**: `POST`
- **URI**: `http://localhost:8081/api/projetos`
- **Descrição**: Cria um novo projeto.
- **Body**: JSON com os dados do novo projeto

    ```json
    {
      "titulo": "Novo Projeto",
      "descricao": "Descrição do novo projeto",
      "dataInicio": "2024-08-14"
    }
    ```

### 4. Atualizar um Projeto Existente

- **Método**: `PUT`
- **URI**: `http://localhost:8081/api/projetos/{id}`
- **Descrição**: Atualiza as informações de um projeto existente.
- **Body**: JSON com os dados atualizados do projeto

    ```json
    {
      "titulo": "Projeto Atualizado",
      "descricao": "Descrição atualizada do projeto",
      "dataInicio": "2024-09-01"
    }
    ```

### 5. Deletar um Projeto

- **Método**: `DELETE`
- **URI**: `http://localhost:8081/api/projetos/{id}`
- **Descrição**: Deleta um projeto pelo seu ID.

## Endpoints para `Tarefa`

### 1. Listar Todas as Tarefas

- **Método**: `GET`
- **URI**: `http://localhost:8081/api/tarefas`
- **Descrição**: Retorna a lista de todas as tarefas.

### 2. Obter uma Tarefa por ID

- **Método**: `GET`
- **URI**: `http://localhost:8081/api/tarefas/{id}`
- **Descrição**: Retorna os detalhes de uma tarefa específica pelo seu ID.

### 3. Criar uma Nova Tarefa

- **Método**: `POST`
- **URI**: `http://localhost:8081/api/tarefas`
- **Descrição**: Cria uma nova tarefa.
- **Body**: JSON com os dados da nova tarefa

    ```json
    {
      "titulo": "Nova Tarefa",
      "descricao": "Descrição da nova tarefa",
      "prioridade": "ALTA",
      "estimativaHoras": 5,
      "projeto": {
        "idProjeto": 1
      }
    }
    ```

### 4. Atualizar uma Tarefa Existente

- **Método**: `PUT`
- **URI**: `http://localhost:8081/api/tarefas/{id}`
- **Descrição**: Atualiza as informações de uma tarefa existente.
- **Body**: JSON com os dados atualizados da tarefa

    ```json
    {
      "titulo": "Tarefa Atualizada",
      "descricao": "Descrição atualizada da tarefa",
      "prioridade": "BAIXA",
      "estimativaHoras": 3
    }
    ```

### 5. Deletar uma Tarefa

- **Método**: `DELETE`
- **URI**: `http://localhost:8081/api/tarefas/{id}`
- **Descrição**: Deleta uma tarefa pelo seu ID.

## Notas Adicionais

- **Para Projetos**: Também é possível visualizar e gerenciar projetos através da interface web acessando `http://localhost:8081/web/projetos`.
- **Para Tarefas**: Não há uma interface web para gerenciamento de tarefas; a interação é feita exclusivamente através da API.
