package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;

public interface AtualizaStatusPedidoInputPort {
    PedidoOut atualizarStatus(Long id, StatusPedidoEnum status);
}
