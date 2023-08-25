package br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido;

import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusPedidoEnum;

public interface AtualizaStatusPedidoOutputPort {
    PedidoDTO atualizarStatus(Long id, StatusPedidoEnum status);
}
