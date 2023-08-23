package br.com.fiap.techchallenge.lanchonete.core.ports.in;

import br.com.fiap.techchallenge.lanchonete.core.entities.ItemPedidoOut;

import java.util.List;

public interface BuscarItensPorPedidoIdInputPort {
    List<ItemPedidoOut> buscarItensDoPedido(Long pedidoid);
}
