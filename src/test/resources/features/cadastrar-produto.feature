# language: pt
Funcionalidade: Cadastrar Produto

  Cenário: Cadastrar um Produto do Tipo Lanche
    Quando cadastrar um novo produto do tipo lanche
    Então o produto do tipo lanche retornar sucesso
    E este produto do tipo lanche deve ser apresentado

  Cenário: Cadastrar um Produto do Tipo Bebida
    Quando criar cadastrar um novo produto do tipo bebida
    Então o produto do tipo bebida retornar com sucesso
    E este produto do tipo bebida deve ser apresentado

