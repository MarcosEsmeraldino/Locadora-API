## LocadoraAPI

# Visão Geral
Descrição dos recursos que compõem LocadoraAPI.

LocadoraAPI é a API de um sistema de locação de filmes. Esta API utiliza JSON sobre requisições HTTP para executar as seguintes tarefas:
- Criar usuário
- Fazer login de usuário
- Fazer logoff de usuário
- Listar filmes disponíveis
- Pesquisar filmes por título
- Locar filme
- Devolver filme

# Criar usuário
Para criar um novo usuário faça a requisição:

`POST` /users/create

enviando um JSON no formato:

```javascript
{
    "name": "Nome do Cara",
    "email": "meuemail@xmail.com",
    "pass": "9876543210"
}
```

Caso a requisição seja bem-sucedida, retornará um JSON com status `200` no formato:
```javascript
{
	"id": 123456789,
    "name": "Nome do Cara",
    "email": "meuemail@xmail.com",
    "pass": "$2y$12$p5QhudM1GoO9KvCjQSnVGuhY5nj5Z41fwFHiS59DQ7HhUXFc6NPau"
}
```

Caso ocorra algum erro, retornará um JSON com status `403` no formato:
```javascript
{
	"message": "Descrição do erro ocorrido."
}
```

# Fazer login de usuário
Para fazer login no sistema faça a requisição:
    <pre>POST /clients/login</pre>
passando como parâmetro um JSON no formato:
    <pre>
{
    "email": "joao@xmail.com",
    "senha": "$j0@0"
}
    </pre>
    
Caso a requisição seja bem-sucedida, retornará um JSON no formato:
    <pre>
{
    "status": 200
}
    </pre>
    
Caso ocorra algum erro, retornará um JSON no formato:
    <pre>
{
    "status": 400,
    "message": "Descrição do erro ocorrido."
}
    </pre>


# Fazer logoff de usuário
Para fazer logoff no sistema faça a requisição:
    <pre>POST /clients/logoff</pre>
    
Caso a requisição seja bem-sucedida, retornará um JSON no formato:
    <pre>
{
    "status": 200
}
    </pre>
    
Caso ocorra algum erro, retornará um JSON no formato:
    <pre>
{
    "status": 400,
    "message": "Descrição do erro ocorrido."
}
    </pre>


# Listar filmes disponíveis
Para listar os filmes disponíveis para locação faça a requisição:
    <pre>GET /movies/available</pre>
Esta requisição retornará um JSON no formato:
    <pre>
{
    filmes:
    [
        {
            "id": 1,
            "titulo": "O Senhor dos Anéis - A Sociedade do Anel",
            "diretor": "Peter Jackson",
            "disponiveis": 1
        },
        {
            "id": 2,
            "titulo": "O Senhor dos Anéis - As Duas Torres",
            "diretor": "Peter Jackson",
            "disponiveis": 2
        },
        {
            "id": 3,
            "titulo": "O Senhor dos Anéis - O Retorno do Rei",
            "diretor": "Peter Jackson",
            "disponiveis": 3
        }
    ]
}
    </pre>
    
    
# Pesquisar filmes por título
Para pesquisar filmes pelo título faça a requisição:
    <pre>GET /movies/search/hobbit</pre>
(esse exemplo busca por "hobbit" no título dos filmes)

Esta requisição retornará um JSON no formato:
    <pre>
{
    filmes:
    [
        {
            "id": 4,
            "titulo": "O Hobbit: Uma Jornada Inesperada",
            "diretor": "Peter Jackson",
            "disponiveis": 4
        },
        {
            "id": 5,
            "titulo": "O Hobbit: A Desolação de Smaug",
            "diretor": "Peter Jackson",
            "disponiveis": 5
        },
        {
            "id": 6,
            "titulo": "O Hobbit: A Batalha dos Cinco Exércitos",
            "diretor": "Peter Jackson",
            "disponiveis": 6
        }
    ]
}
    </pre>


# Locar filme
Para locar um filme faça a requisição:
    <pre>POST locations/clients/111/movies/222</pre>
(esse exemplo cria uma locação pelo usuário #111, do filme #222)

Caso a requisição seja bem-sucedida, retornará um JSON no formato:
    <pre>
{
    "status": 200
}
    </pre>
Caso ocorra algum erro, retornará um JSON no formato:
    <pre>
{
    "status": 400,
    "message": "Descrição do erro ocorrido."
}
    </pre>
    

# Devolver filme
Para devolver um filme locado faça a requisição:
    <pre>PUT locations/clients/111/movies/222</pre>
(esse exemplo efetua a devolução do filme #222 pelo usuário #111)

Caso a requisição seja bem-sucedida, retornará um JSON no formato:
    <pre>
{
    "status": 200
}
    </pre>
Caso ocorra algum erro, retornará um JSON no formato:
    <pre>
{
    "status": 400,
    "message": "Descrição do erro ocorrido."
}
    </pre>


# Contato
Dúvidas ou sugestões, entre em contato com <a href="mailto:marcosesmeraldino@gmail.com?Subject=LocadoraFilmes">Marcos Esmeraldino</a>.
