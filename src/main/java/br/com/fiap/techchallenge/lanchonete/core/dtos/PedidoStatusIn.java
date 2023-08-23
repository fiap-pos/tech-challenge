package br.com.fiap.techchallenge.lanchonete.core.dtos;

import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusPedidoEnum;

public interface PedidoStatusIn {

    StatusPedidoEnum getStatus();
}
