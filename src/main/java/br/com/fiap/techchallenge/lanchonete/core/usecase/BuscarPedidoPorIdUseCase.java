package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscarPedidoPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscarPedidoPorIdOutputPort;

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
