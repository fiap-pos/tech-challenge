package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.ItemPedido;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoOut;

import java.util.List;

public interface BuscarItensPorPedidoIdOutputPort {
    List<ItemPedidoOut> buscarItensDoPedido(Long pedidoid);
}
