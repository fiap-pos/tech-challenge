package br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Cliente;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.CriaItemPedido;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;

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