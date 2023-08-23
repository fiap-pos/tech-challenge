package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.BuscarPedidoPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.BuscarPedidoPorIdOutputPort;

public class BuscarPedidoPorIdUseCase implements BuscarPedidoPorIdInputPort {
    private final BuscarPedidoPorIdOutputPort buscarPedidoPorIdOutputPort;
    public BuscarPedidoPorIdUseCase(BuscarPedidoPorIdOutputPort buscarPedidoPorIdOutputPort) {
        this.buscarPedidoPorIdOutputPort = buscarPedidoPorIdOutputPort;
    }
    @Override
    public PedidoOut buscarPorId(Long id) {
        return buscarPedidoPorIdOutputPort.buscarPorId(id);
    }
}
