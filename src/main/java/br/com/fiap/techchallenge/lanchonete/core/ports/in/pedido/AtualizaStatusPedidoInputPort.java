package br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;

public interface AtualizaStatusPedidoInputPort {
    PedidoDTO atualizarStatus(Long id, StatusPedidoEnum pedidoStatusIn);
}
