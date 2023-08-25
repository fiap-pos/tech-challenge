package br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido;

import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;

public interface BuscarPedidoPorIdOutputPort {

    PedidoDTO buscarPorId(Long id);
}
