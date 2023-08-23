package br.com.fiap.techchallenge.lanchonete.core.ports.in;

import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;

public interface BuscarPedidoPorIdInputPort {
    PedidoOut buscarPorId(Long id);
}
