package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoOut;

public interface BuscarPedidoPorIdOutputPort {

    PedidoOut buscarPorId(Long id);
}
