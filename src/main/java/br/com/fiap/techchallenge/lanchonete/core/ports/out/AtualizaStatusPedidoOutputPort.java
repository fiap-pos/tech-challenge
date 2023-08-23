package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusPedidoEnum;

public interface AtualizaStatusPedidoOutputPort {
    PedidoOut atualizarStatus(Long id, StatusPedidoEnum status);
}
