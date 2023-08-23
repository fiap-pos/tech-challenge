package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;

public interface BuscarPedidoPorIdOutputPort {

    PedidoOut buscarPorId(Long id);
}
