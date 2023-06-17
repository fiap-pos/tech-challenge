package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.Categoria;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;

import java.math.BigDecimal;

public record ProdutoResponse(Long id, String nome, Categoria categoria, BigDecimal preco, String descricao,
                              byte[] imagem) implements ProdutoOut {

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public BigDecimal getPreco() {
        return preco;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public byte[] getImagem() {
        return imagem;
    }
}
