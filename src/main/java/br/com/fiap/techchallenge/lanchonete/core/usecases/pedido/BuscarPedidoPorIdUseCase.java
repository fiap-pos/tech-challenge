package br.com.fiap.techchallenge.lanchonete.core.usecases.pedido;

import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.BuscarPedidoPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.BuscarPedidoPorIdOutputPort;

public class BuscarPedidoPorIdUseCase implements BuscarPedidoPorIdInputPort {
    private final BuscarPedidoPorIdOutputPort buscarPedidoPorIdOutputPort;
    public BuscarPedidoPorIdUseCase(BuscarPedidoPorIdOutputPort buscarPedidoPorIdOutputPort) {
        this.buscarPedidoPorIdOutputPort = buscarPedidoPorIdOutputPort;
    }
    @Override
    public PedidoDTO buscarPorId(Long id) {
        return buscarPedidoPorIdOutputPort.buscarPorId(id);
    }
}
