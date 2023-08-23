package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.entities.ItemPedidoOut;

import java.util.List;

public interface BuscarItensPorPedidoIdOutputPort {
    List<ItemPedidoOut> buscarItensDoPedido(Long pedidoid);
}
