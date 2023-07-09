package br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces;

import java.math.BigDecimal;

public interface CriaItemPedidoIn {
    Long getProdutoId();
    Integer getQuantidade();
    BigDecimal getValorUnitario();
}
