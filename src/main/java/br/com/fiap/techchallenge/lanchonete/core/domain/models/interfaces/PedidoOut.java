package br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;

import java.math.BigDecimal;

public interface PedidoOut {
    Long getId();
    StatusPedidoEnum getStatus();
//    LocalDateTime getDataCriacao();
//    Long getCliente();
//    List<ItemPedidoResponse> getItens();
    BigDecimal getValorTotal();

}
