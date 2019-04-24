# Locadora-API

## Visão Geral

Locadora-API é a API de um sistema de locação de filmes.

Este sistema utiliza JSON sobre requisições HTTP para executar as seguintes tarefas:
- Criar usuário
- Fazer login
- Fazer logout
- Listar filmes disponíveis
- Pesquisar filmes por título
- Locar filme
- Devolver filme

## Criar usuário

Para criar um novo usuário faça a requisição:

`POST` /users/create

enviando um JSON no formato:

```javascript
{
    "name": "Fulano de Tal",
    "email": "meuemail@xmail.com",
    "pass": "9876543210"
}
```

Caso a requisição seja bem-sucedida, retornará um JSON com status `201` no formato:
```javascript
{
    "id": 3,
    "name": "Fulano de Tal",
    "email": "meuemail@xmail.com",
    "pass": "$2a$10$42LIw1ol.QcyRw/L3jY/R.mys8Q8u0XJYpLoO45VtYv69E.5FEWc2"
}
```

Caso ocorra algum erro, retornará um JSON com status `400` no formato:
```javascript
{
    "code": 1,
    "message": "Não foi possível criar o usuário."
}
```

## Fazer login

Para fazer login no sistema faça a requisição:

`POST` /auth/login

enviando um JSON no formato:

```javascript
{
    "email": "meuemail@xmail.com",
    "pass": "9876543210"
}
```

Caso a requisição seja bem-sucedida, retornará um JSON com status `200` no formato:
```javascript
{
    "id": 3,
    "name": "Fulano de Tal",
    "email": "meuemail@xmail.com",
    "pass": "$2a$10$42LIw1ol.QcyRw/L3jY/R.mys8Q8u0XJYpLoO45VtYv69E.5FEWc2"
}
```

Caso ocorra algum erro, retornará um JSON com status `401` no formato:
```javascript
{
    "code": 2,
    "message": "Não foi possível fazer o login."
}
```

## Fazer logout

Para fazer logout no sistema faça a requisição:

`GET` /auth/login


Caso a requisição seja bem-sucedida, retornará uma mensagem vazia com status `200`.

Caso ocorra algum erro, retornará um JSON com status `400` no formato:
```javascript
{
    "code": 3,
    "message": "Não foi possível fazer o logout."
}
```

## Listar filmes disponíveis

Para listar os filmes disponíveis para locação faça a requisição:

`GET` /movies/search/available

Caso a requisição seja bem-sucedida, retornará um JSON com status `200` no formato:

```javascript
[
    {
        "id": 3,
        "title": "O Senhor dos Anéis - O Retorno do Rei",
        "director": "Peter Jackson",
        "stock": 2
    },
    {
        "id": 4,
        "title": "O Hobbit: Uma Jornada Inesperada",
        "director": "Peter Jackson",
        "stock": 5
    },
    {
        "id": 5,
        "title": "O Hobbit: A Desolação de Smaug",
        "director": "Peter Jackson",
        "stock": 4
    },
    {
        "id": 6,
        "title": "O Hobbit: A Batalha dos Cinco Exércitos",
        "director": "Peter Jackson",
        "stock": 4
    }
]
```

Caso ocorra algum erro, retornará um JSON com status `400` no formato:
```javascript
{
    "code": 4,
    "message": "Não foi possível pesquisar filmes."
}
```

    
## Pesquisar filmes por título

Para pesquisar filmes pelo título faça a requisição:

`GET` /movies/search/title/*{hobbit}*

Caso a requisição seja bem-sucedida, retornará um JSON com status `200` no formato:
```javascript
[
    {
        "id": 4,
        "title": "O Hobbit: Uma Jornada Inesperada",
        "director": "Peter Jackson",
        "stock": 5
    },
    {
        "id": 5,
        "title": "O Hobbit: A Desolação de Smaug",
        "director": "Peter Jackson",
        "stock": 4
    },
    {
        "id": 6,
        "title": "O Hobbit: A Batalha dos Cinco Exércitos",
        "director": "Peter Jackson",
        "stock": 4
    }
]
```

Caso ocorra algum erro, retornará um JSON com status `400` no formato:
```javascript
{
    "code": 4,
    "message": "Não foi possível pesquisar filmes."
}
```


## Locar filme

Para locar um filme, **é necessário estar logado.** Depois, faça a requisição:

`POST` /locations/start

enviando um JSON no formato:

```javascript
{
    "user": {
        "id": 1
    },
    "movies": [
        {
            "movie": {
                "id": 4
            },
            "quant": 1
        },
        {
            "movie": {
                "id": 5
            },
            "quant": 1
        }
    ]
}
```

Caso a requisição seja bem-sucedida, retornará uma mensagem vazia com status `200`.

Caso ocorra algum erro, retornará um JSON com status `400` no formato:
```javascript
{
    "code": 5,
    "message": "Não foi possível iniciar a locação."
}
```

Caso o usuário não esteja logado, retornará um JSON com status `403` no formato:
```javascript
{
    "timestamp": "2019-04-24T15:36:19.704+0000",
    "status": 403,
    "error": "Forbidden",
    "message": "Access Denied",
    "path": "/locations/start"
}
``` 


## Devolver filme

Para devolver um filme locado, **é necessário estar logado.** Depois, faça a requisição:

`POST` /locations/finish

enviando um JSON no formato:

```javascript
{
    "id": 2
}
```

Caso a requisição seja bem-sucedida, retornará uma mensagem vazia com status `200`.

Caso ocorra algum erro, retornará um JSON com status `400` no formato:
```javascript
{
    "code": 6,
    "message": "Não foi possível encerrar a locação."
}
```

Caso o usuário não esteja logado, retornará um JSON com status `403` no formato:
```javascript
{
    "timestamp": "2019-04-24T15:36:19.704+0000",
    "status": 403,
    "error": "Forbidden",
    "message": "Access Denied",
    "path": "/locations/finish"
}
``` 
