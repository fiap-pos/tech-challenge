package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.CategoriaEnum;

import java.math.BigDecimal;

public class ProdutoOut extends ProdutoBase {

    public ProdutoOut() {
        super();
    }

    public ProdutoOut(Long id, String nome, CategoriaEnum categoriaEnum, BigDecimal preco, String descricao, byte[] imagem) {
        super(id, nome, categoriaEnum, preco, descricao, imagem);
    }

}
