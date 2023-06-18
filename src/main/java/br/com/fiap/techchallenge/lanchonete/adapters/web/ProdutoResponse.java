package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.Categoria;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;

import java.math.BigDecimal;

public class ProdutoResponse extends ProdutoOut {

    public ProdutoResponse() {
    }

    public ProdutoResponse(Long id, String nome, Categoria categoria, BigDecimal preco, String descricao, byte[] imagem) {
        setId(id);
        setNome(nome);
        setCategoria(categoria);
        setPreco(preco);
        setDescricao(descricao);
        setImagem(imagem);
    }

}
