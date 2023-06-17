package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import java.math.BigDecimal;

public interface ProdutoIn {

    String getNome();

    Categoria getCategoria();

    BigDecimal getPreco();

    String getDescricao();

    byte[] getImagem();

}
