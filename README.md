# digital-business-api
Repositório referente a api em Spring boot
### Versão do Java: 17.0.5

### Cadastrar Usuário

Endpoint: `POST /usuarios`

Este endpoint é usado para cadastrar um novo usuário.

Requisição:
POST /usuarios HTTP/1.1
Content-Type: application/json

      [
            {
              "nome": "Nome do Usuário",
              "email": "email@example.com",
              "senha": "senha123"
            }
      ]

Resposta:
HTTP/1.1 201 Created
Location: /usuarios/{id}
Content-Type: text/plain

Usuario Cadastrado

Listar Usuários Ativos

Endpoint: GET /usuarios/ativos
Este endpoint é usado para listar os usuários ativos.

Requisição:
GET /usuarios/ativos HTTP/1.1

Resposta:
HTTP/1.1 200 OK
Content-Type: application/json

      [
        {
          "id": 1,
          "nome": "Nome do Usuário",
          "email": "email@example.com"
        },
        {
          "id": 2,
          "nome": "Outro Usuário",
          "email": "outro@example.com"
        }
      ]


Listar Todos os Usuários
Endpoint: GET /usuarios/todos
Este endpoint é usado para listar todos os usuários, incluindo os ativos e inativos.

Requisição:
GET /usuarios/todos HTTP/1.1

Resposta:
HTTP/1.1 200 OK
Content-Type: application/json

    [
      {
        "id": 1,
        "nome": "Nome do Usuário",
        "email": "email@example.com"
      },
      {
        "id": 2,
        "nome": "Outro Usuário",
        "email": "outro@example.com"
      },
      {
        "id": 3,
        "nome": "Usuário Inativo",
        "email": "inativo@example.com"
      }
    ]


Atualizar Usuário
Endpoint: PUT /usuarios
Este endpoint é usado para atualizar as informações de um usuário.

Requisição:
PUT /usuarios HTTP/1.1
Content-Type: application/json

    {
      "id": 1,
      "nome": "Nome Atualizado",
      "email": "email@example.com"
    }

Resposta:
HTTP/1.1 200 OK
Content-Type: text/plain
Usuário atualizado com sucesso

Deletar Usuário
Endpoint: DELETE /usuarios/{id}
Este endpoint é usado para deletar um usuário pelo seu ID.

Requisição:
DELETE /usuarios/1 HTTP/1.1

Resposta:
HTTP/1.1 200 OK
Content-Type: text/plain

Usuário deletado com sucesso!


### Categoria Software

gerenciamento de categorias de software.

Cadastrar Categoria Software [POST]

Cadastra uma nova categoria de software.

    URL: /api/v1/categorias
    Método: POST
    Corpo da Requisição: JSON contendo os dados da categoria a ser cadastrada
        Exemplo:

        {
          "nome": "Categoria 1",
          "descricao": "Descrição da Categoria 1"
        }

    Resposta de Sucesso:
        Código: 201 CREATED
        Corpo da Resposta: "Categoria Cadastrada"

Listar Categorias Ativas [GET]

Obtém uma lista paginada das categorias de software ativas.

    URL: /categorias/ativos
    Método: GET
    Parâmetros da URL:
        page (opcional): número da página desejada (padrão: 0)
        size (opcional): número de itens por página (padrão: 20)
    Resposta de Sucesso:
        Código: 200 OK
        Corpo da Resposta: JSON contendo a lista paginada das categorias de software ativas
            Exemplo:

            {
              "content": [
                {
                  "id": 1,
                  "nome": "Categoria 1",
                  "descricao": "Descrição da Categoria 1"
                },
                {
                  "id": 2,
                  "nome": "Categoria 2",
                  "descricao": "Descrição da Categoria 2"
                }
              ],
              "pageable": {
                "pageNumber": 0,
                "pageSize": 20
              },
              "totalPages": 1,
              "totalElements": 2
            }

Listar Todas as Categorias [GET]

Obtém uma lista paginada de todas as categorias de software (ativas e inativas).

    URL: /categorias/todos
    Método: GET
    Parâmetros da URL:
        page (opcional): número da página desejada (padrão: 0)
        size (opcional): número de itens por página (padrão: 20)
    Resposta de Sucesso:
        Código: 200 OK
        Corpo da Resposta: JSON contendo a lista paginada de todas as categorias de software
            Exemplo:
            {
              "content": [
                {
                  "id": 1,
                  "nome": "Categoria 1",
                  "descricao": "Descrição da Categoria 1"
                },
                {
                  "id": 2,
                  "nome": "Categoria 2",
                  "descricao": "Descrição da Categoria 2"
                }
              ],
              "pageable": {
                "pageNumber": 0,
                "pageSize": 20
              },
              "totalPages": 1,
              "totalElements": 2
            }

Atualizar Categoria Software [PUT]

Atualiza os dados de uma categoria de software existente.

    URL: /v1/categorias
    Método: PUT
    Corpo da Requisição: JSON contendo os dados atualizados da categoria
        Exemplo:


        {
          "id": 1,
          "nome": "Categoria 1 Atualizada",
          "descricao": "Nova descrição da Categoria 1"
        }

    Resposta de Sucesso:
        Código: 200 OK
        Corpo da Resposta: "Categoria atualizada com sucesso"

Deletar Categoria Software [DELETE]

Deleta uma categoria de software existente.

    URL: /categorias/{id}
    Método: DELETE
    Parâmetros da URL:
        id: identificador único da categoria
    Resposta de Sucesso:
        Código: 200 OK
        Corpo da Resposta: "Categoria deletada com sucesso"



### Recurso Software

Cadastrar Recurso Software [POST]

Cadastra um novo recurso de software.

    URL: /recursos
    Método: POST
    Corpo da Requisição: JSON contendo os dados do recurso a ser cadastrado
        Exemplo:

        

        {
          "nome": "Recurso 1",
          "descricao": "Descrição do Recurso 1"
        }

    Resposta de Sucesso:
        Código: 201 CREATED
        Corpo da Resposta: "Recurso Cadastrado"

Listar Recursos Ativos [GET]

Obtém uma lista paginada dos recursos de software ativos.

    URL: /recursos/ativos
    Método: GET
    Parâmetros da URL:
        page (opcional): número da página desejada (padrão: 0)
        size (opcional): número de itens por página (padrão: 20)
    Resposta de Sucesso:
        Código: 200 OK
        Corpo da Resposta: JSON contendo a lista paginada dos recursos de software ativos
            Exemplo:


            {
              "content": [
                {
                  "id": 1,
                  "nome": "Recurso 1",
                  "descricao": "Descrição do Recurso 1"
                },
                {
                  "id": 2,
                  "nome": "Recurso 2",
                  "descricao": "Descrição do Recurso 2"
                }
              ],
              "pageable": {
                "pageNumber": 0,
                "pageSize": 20
              },
              "totalPages": 1,
              "totalElements": 2
            }

Listar Todos os Recursos [GET]

Obtém uma lista paginada de todos os recursos de software (ativos e inativos).

    URL: /recursos/todos
    Método: GET
    Parâmetros da URL:
        page (opcional): número da página desejada (padrão: 0)
        size (opcional): número de itens por página (padrão: 20)
    Resposta de Sucesso:
        Código: 200 OK
        Corpo da Resposta: JSON contendo a lista paginada de todos os recursos de software
            Exemplo:

            

            {
              "content": [
                {
                  "id": 1,
                  "nome": "Recurso 1",
                  "descricao": "Descrição do Recurso 1"
                },
                {
                  "id": 2,
                  "nome": "Recurso 2",
                  "descricao": "Descrição do Recurso 2"
                }
              ],
              "pageable": {
                "pageNumber": 0,
                "pageSize": 20
              },
              "totalPages": 1,
              "totalElements": 2
            }

Atualizar Recurso Software [PUT]

Atualiza os dados de um recurso de software existente.

    URL: /recursos
    Método: PUT
    Corpo da Requisição: JSON contendo os dados atualizados do recurso
        Exemplo:

        

        {
          "id": 1,
          "nome": "Recurso 1 Atualizado",
          "descricao": "Nova descrição do Recurso 1"
        }

    Resposta de Sucesso:
        Código: 200 OK
        Corpo da Resposta: "Recurso atualizado com sucesso"

Deletar Recurso Software [DELETE]

Deleta um recurso de software existente.

    URL: /recursos/{id}
    Método: DELETE
    Parâmetros da URL:
        id: identificador único do recurso
    Resposta de Sucesso:
        Código: 200 OK
        Corpo da Resposta: "Recurso deletado com sucesso"

### Software Gestão
Cadastrar Software Gestão [POST]

Cadastra um novo software de gestão.

    URL: /softwares
    Método: POST
    Corpo da Requisição: JSON contendo os dados do software a ser cadastrado
        Exemplo:

        {
          "nome": "Software 1",
          "versao": "1.0",
          "descricao": "Descrição do Software 1"
        }

    Resposta de Sucesso:
        Código: 201 CREATED
        Corpo da Resposta: "Software Cadastrado"

Listar Softwares Gestão Ativos [GET]

Obtém uma lista paginada dos softwares de gestão ativos.

    URL: /softwares/ativos
    Método: GET
    Parâmetros da URL:
        page (opcional): número da página desejada (padrão: 0)
        size (opcional): número de itens por página (padrão: 20)
    Resposta de Sucesso:
        Código: 200 OK
        Corpo da Resposta: JSON contendo a lista paginada dos softwares de gestão ativos
            Exemplo:


            {
              "content": [
                {
                  "id": 1,
                  "nome": "Software 1",
                  "versao": "1.0",
                  "descricao": "Descrição do Software 1"
                },
                {
                  "id": 2,
                  "nome": "Software 2",
                  "versao": "2.0",
                  "descricao": "Descrição do Software 2"
                }
              ],
              "pageable": {
                "pageNumber": 0,
                "pageSize": 20
              },
              "totalPages": 1,
              "totalElements": 2
            }

Listar Todos os Softwares Gestão [GET]

Obtém uma lista paginada de todos os softwares de gestão (ativos e inativos).

    URL: /softwares/todos
    Método: GET
    Parâmetros da URL:
        page (opcional): número da página desejada (padrão: 0)
        size (opcional): número de itens por página (padrão: 20)
    Resposta de Sucesso:
        Código: 200 OK
        Corpo da Resposta: JSON contendo a lista paginada de todos os softwares de gestão
            Exemplo:


            {
              "content": [
                {
                  "id": 1,
                  "nome": "Software 1",
                  "versao": "1.0",
                  "descricao": "Descrição do Software 1"
                },
                {
                  "id": 2,
                  "nome": "Software 2",
                  "versao": "2.0",
                  "descricao": "Descrição do Software 2"
                }
              ],
              "pageable": {
                "pageNumber": 0,
                "pageSize": 20
              },
              "totalPages": 1,
              "totalElements": 2
            }

Atualizar Software Gestão [PUT]

Atualiza os dados de um software de gestão existente.

    URL: /softwares
    Método: PUT
    Corpo da Requisição: JSON contendo os dados atualizados do software
        Exemplo:


        {
          "id": 1,
          "nome": "Software 1 Atualizado",
          "versao": "2.0",
          "descricao": "Nova descrição do Software 1"
        }

    Resposta de Sucesso:
        Código: 200 OK
        Corpo da Resposta: "Software atualizado com sucesso"

Deletar Software Gestão [DELETE]

Deleta um software de gestão existente.

    URL: /softwares/{id}
    Método: DELETE
    Parâmetros da URL:
        id: identificador único do software
    Resposta de Sucesso:
        Código: 200 OK
        Corpo da Resposta: "Software deletado com sucesso"


