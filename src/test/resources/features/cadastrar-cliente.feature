# language: pt
Funcionalidade: Cadastrar Cliente

  Cenário: Cadastrar um Cliente
    Quando cadastrar um novo cliente
    Então o cliente cadastrado deve retornar sucesso
    E este cliente deve ser apresentado
