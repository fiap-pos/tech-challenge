package br.com.fiap.techchallenge.lanchonete.core.dtos;

import java.math.BigDecimal;

public interface CriaItemPedidoIn {
    Long getProdutoId();
    Integer getQuantidade();
    BigDecimal getValorUnitario();
}
