# language: pt
Funcionalidade: Criar Pedido

  Cenário: Criar Pedido com Lanche e Bebida e Cliente Cadastrados
    Quando criar um novo pedido com cliente
    Então o pedido é criado com sucesso com cliente apresentado
    E deve ser apresentado com cliente

  Cenário: Criar Pedido com Lanche e Bebida cadastrados e sem Cliente
    Quando criar um novo pedido sem informar o cliente
    Então o pedido é criado com sucesso sem cliente apresentado
    E deve ser apresentado sem cliente

