package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;

public interface AtualizaStatusPedidoOutputPort {
    PedidoOut atualizarStatus(Long id, StatusPedidoEnum status);
}
