package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.CategoriaEnum;

import java.math.BigDecimal;

public class ProdutoResponse extends ProdutoOut {

    public ProdutoResponse() {
    }

    public ProdutoResponse(Long id, String nome, CategoriaEnum categoriaEnum, BigDecimal preco, String descricao, byte[] imagem) {
        super(id, nome, categoriaEnum, preco, descricao, imagem);
    }

}
