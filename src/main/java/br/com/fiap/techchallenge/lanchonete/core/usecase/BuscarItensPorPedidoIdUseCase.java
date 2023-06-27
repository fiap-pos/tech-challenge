package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.ItemPedido;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscarItensPorPedidoIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscarItensPorPedidoIdOutputPort;

import java.util.List;

public class BuscarItensPorPedidoIdUseCase implements BuscarItensPorPedidoIdInputPort {
    private final BuscarItensPorPedidoIdOutputPort buscarItensPorPedidoIdOutputPort;

    public BuscarItensPorPedidoIdUseCase(BuscarItensPorPedidoIdOutputPort buscarItensPorPedidoIdOutputPort) {
        this.buscarItensPorPedidoIdOutputPort = buscarItensPorPedidoIdOutputPort;
    }

    @Override
    public List<ItemPedidoOut> buscarItensDoPedido(Long pedidoid) {
        return buscarItensPorPedidoIdOutputPort.buscarItensDoPedido(pedidoid);
    }
}
