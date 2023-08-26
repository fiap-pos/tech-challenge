package br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido;


import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;

import java.util.List;

public interface BuscaTodosPedidosPorStatusInputPort {
    List<PedidoDTO> buscarTodosStatus(StatusPedidoEnum status);
}
