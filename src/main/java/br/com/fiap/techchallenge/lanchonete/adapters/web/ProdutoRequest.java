package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.Categoria;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoIn;

import java.math.BigDecimal;

public record ProdutoRequest(String nome, Categoria categoria, BigDecimal preco, String descricao) implements ProdutoIn {

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
}
