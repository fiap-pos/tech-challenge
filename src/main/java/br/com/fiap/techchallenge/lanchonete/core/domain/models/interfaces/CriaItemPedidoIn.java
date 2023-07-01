package br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces;

import java.math.BigDecimal;
import java.util.List;

public interface CriaItemPedidoIn {
    Long getProdutoId();
    Integer getQuantidade();
    BigDecimal getValorUnitario();
}
