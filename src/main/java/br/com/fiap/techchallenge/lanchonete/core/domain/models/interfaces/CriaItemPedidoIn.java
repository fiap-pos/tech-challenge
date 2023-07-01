package br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoIn;

import java.math.BigDecimal;

public interface CriaItemPedidoIn {

    Long getId();
    Integer getQuantidade();
    BigDecimal getValorUnitario();
}
