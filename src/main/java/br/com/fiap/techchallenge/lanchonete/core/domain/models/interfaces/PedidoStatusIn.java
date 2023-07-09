package br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;

public interface PedidoStatusIn {

    StatusPedidoEnum getStatus();
}
