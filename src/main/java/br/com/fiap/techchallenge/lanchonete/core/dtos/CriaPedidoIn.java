package br.com.fiap.techchallenge.lanchonete.core.dtos;

import br.com.fiap.techchallenge.lanchonete.core.entities.CriaItemPedido;
import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusPedidoEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface CriaPedidoIn {

    Long getClienteId();
    StatusPedidoEnum getStatus();
    LocalDateTime getDataCriacao();
    List<CriaItemPedido> getItens();
    BigDecimal getValorTotal();
}
