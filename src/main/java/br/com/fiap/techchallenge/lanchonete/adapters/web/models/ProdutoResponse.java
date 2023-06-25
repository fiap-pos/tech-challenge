package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.enums.CategoriaEnum;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.ProdutoOut;

import java.math.BigDecimal;

public class ProdutoResponse extends ProdutoOut {

    public ProdutoResponse() {
    }

    public ProdutoResponse(Long id, String nome, CategoriaEnum categoriaEnum, BigDecimal preco, String descricao, byte[] imagem) {
        setId(id);
        setNome(nome);
        setCategoria(categoriaEnum);
        setPreco(preco);
        setDescricao(descricao);
        setImagem(imagem);
    }

}
