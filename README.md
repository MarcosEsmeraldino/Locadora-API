# LocadoraAPI

## Visão Geral

LocadoraAPI é a API de um sistema de locação de filmes.

Esta API utiliza JSON sobre requisições HTTP para executar as seguintes tarefas:
- Criar usuário
- Fazer login
- Fazer logoff
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
    "user_id": 123456789
}
```

Caso ocorra algum erro, retornará um JSON com status `400` no formato:
```javascript
{
    "message": "Descrição do erro ocorrido."
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
    "user_id": 123456789
}
```

Caso ocorra algum erro, retornará um JSON com status `400` no formato:
```javascript
{
    "message": "Descrição do erro ocorrido."
}
```

## Fazer logoff

Para fazer logoff no sistema faça a requisição:

`POST` /auth/logoff/

enviando um JSON no formato:

```javascript
{
    "user_id": 123456789
}
```

Caso a requisição seja bem-sucedida, retornará um JSON com status `200` no formato:
```javascript
{
    "status": "ok"
}
```

Caso ocorra algum erro, retornará um JSON com status `400` no formato:
```javascript
{
    "message": "Descrição do erro ocorrido."
}
```

## Listar filmes disponíveis

Para listar os filmes disponíveis para locação faça a requisição:

`GET` /movies/search/available

Caso a requisição seja bem-sucedida, retornará um JSON com status `200` no formato:

```javascript
{
    "data": [
        {
            "id": 1234560,
            "title": "O Senhor dos Anéis - A Sociedade do Anel",
            "director": "Peter Jackson",
            "stock": 10
        },
        {
            "id": 1234561,
            "title": "O Senhor dos Anéis - As Duas Torres",
            "director": "Peter Jackson",
            "stock": 5
        },
        {
            "id": 1234562,
            "title": "O Senhor dos Anéis - O Retorno do Rei",
            "director": "Peter Jackson",
            "stock": 5
        },
        {
            "id": 1234563,
            "title": "O Hobbit: Uma Jornada Inesperada",
            "director": "Peter Jackson",
            "stock": 10
        },
        {
            "id": 1234564,
            "title": "O Hobbit: A Desolação de Smaug",
            "director": "Peter Jackson",
            "stock": 5
        },
        {
            "id": 1234565,
            "title": "O Hobbit: A Batalha dos Cinco Exércitos",
            "director": "Peter Jackson",
            "stock": 5
        }
    ]
}
```

Caso ocorra algum erro, retornará um JSON com status `400` no formato:
```javascript
{
    "message": "Descrição do erro ocorrido."
}
```

    
## Pesquisar filmes por título

Para pesquisar filmes pelo título faça a requisição:

`GET` /movies/search/title/{hobbit}

Caso a requisição seja bem-sucedida, retornará um JSON com status `200` no formato:
```javascript
{
    "data": [
        {
            "id": 1234563,
            "title": "O Hobbit: Uma Jornada Inesperada",
            "director": "Peter Jackson",
            "stock": 10
        },
        {
            "id": 1234564,
            "title": "O Hobbit: A Desolação de Smaug",
            "director": "Peter Jackson",
            "stock": 5
        },
        {
            "id": 1234565,
            "title": "O Hobbit: A Batalha dos Cinco Exércitos",
            "director": "Peter Jackson",
            "stock": 5
        }
    ]
}
```

Caso ocorra algum erro, retornará um JSON com status `400` no formato:
```javascript
{
    "message": "Descrição do erro ocorrido."
}
```


## Locar filme

Para locar um filme, **é necessário estar logado.** Depois, faça a requisição:

`POST` /locations/start

enviando um JSON no formato:

```javascript
{
    "user": {
        "id": 123456789
    },
    "movies": [
        "movie": {
            "id": 1234560,
            "quant": 1
        },
        "movie": {
            "id": 1234561,
            "quant": 1
        },
        "movie": {
            "id": 1234562,
            "quant": 1
        }
    ]
}
```

Caso a requisição seja bem-sucedida, retornará um JSON com status `201` no formato:
```javascript
{
    "status": "OK"
}
```

Caso ocorra algum erro, retornará um JSON com status `400` no formato:
```javascript
{
    "message": "Descrição do erro ocorrido."
}
```


## Devolver filme

Para devolver um filme locado, **é necessário estar logado.** Depois, faça a requisição:

`POST` /locations/finish

enviando um JSON no formato:

```javascript
{
    "location_id": 123456789
}
```

Caso a requisição seja bem-sucedida, retornará um JSON com status `200` no formato:
```javascript
{
    "status": "OK"
}
```

Caso ocorra algum erro, retornará um JSON com status `400` no formato:
```javascript
{
    "message": "Descrição do erro ocorrido."
}
```
