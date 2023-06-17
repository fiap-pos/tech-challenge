package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import java.math.BigDecimal;

public interface ProdutoOut {

    Long getId();

    String getNome();

    Categoria getCategoria();

    BigDecimal getPreco();

    String getDescricao();

    byte[] getImagem();

}
