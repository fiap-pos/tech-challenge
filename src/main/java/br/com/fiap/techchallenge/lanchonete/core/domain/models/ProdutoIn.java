package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.CategoriaEnum;

import java.math.BigDecimal;

public class ProdutoIn extends ProdutoBase {

    public ProdutoIn() {
        super();
    }

    public ProdutoIn(Long id, String nome, CategoriaEnum categoriaEnum, BigDecimal preco, String descricao, byte[] imagem) {
        super(id, nome, categoriaEnum, preco, descricao, imagem);
    }

}
