package br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido;

import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;

public interface BuscarPedidoPorIdInputPort {
    PedidoDTO buscarPorId(Long id);
}
