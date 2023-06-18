package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import java.math.BigDecimal;

public interface ProdutoIn {

    Long getId();

    String getNome();

    Categoria getCategoria();

    BigDecimal getPreco();

    String getDescricao();

    byte[] getImagem();

}
