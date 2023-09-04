package br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido;

import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;

import java.util.List;

public interface BuscaTodosPedidosPorStatusOutputPort {
    List<PedidoDTO> buscarPedidosPorStatus(StatusPedidoEnum status);
}
