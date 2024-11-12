# TODO List

API para gerenciar tarefas (CRUD) simples do dia a dia. Com um sistema de 
organização pela prioridade da tarefa.

### Tecnologias
* Spring Boot
* Spring MVC
* Spring Data JPA
* MySQL
* Maven

### Práticas Adotadas
* SOLID, DRY, YAGNI, KISS
* API REST
* Consultas com Spring Data JPA
* Injeção de Dependências
* Tratamento de respostas de erro
* Geração automática do Swagger

### Como Executar
* Clonar repositório git
* Construir o projeto

A API poderá ser acessada em [localhost:8080]().

O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html]().
 
### API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [postman]():

* Criar Tarefa
```
POST http://localhost:8080/todos

    {
        "nome": "Ir no parque",
        "descricao": "ir no parque com a irmã",
        "realizacao": false,
        "prioridade": 10
    }
```
* Listar Tarefas

````
GET http://localhost:8080/todos

[
    {
        "id": 2,
        "nome": "Passeio",
        "descricao": "passear com a mel",
        "realizacao": false,
        "prioridade": 2
    },
    {
        "id": 3,
        "nome": "Dança Treino",
        "descricao": "treinar dança por 1:30hr",
        "realizacao": false,
        "prioridade": 7
    },
    {
        "id": 11,
        "nome": "Ir no parque",
        "descricao": "ir no parque com a irmã",
        "realizacao": false,
        "prioridade": 10
    }
]
````

* Deletar Tarefa

````
DEL http://localhost:8080/todos/11

    {
        "id": 11,
        "nome": "Ir no parque",
        "descricao": "ir no parque com a irmã",
        "realizacao": false,
        "prioridade": 10
    }
````
