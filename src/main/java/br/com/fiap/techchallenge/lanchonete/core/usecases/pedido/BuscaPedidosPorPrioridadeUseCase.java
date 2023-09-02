package br.com.fiap.techchallenge.lanchonete.core.usecases.pedido;

import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.BuscaPedidosOrdenadosPorPrioridadeInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.BuscaPedidosOrdenadosPorPrioridadeOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.BuscaTodosPedidosOutputPort;

import java.util.List;

public class BuscaPedidosPorPrioridadeUseCase implements BuscaPedidosOrdenadosPorPrioridadeInputPort {

    private final BuscaPedidosOrdenadosPorPrioridadeOutputPort buscaPedidosPorPrioridadeOutputPort;

    private final BuscaTodosPedidosOutputPort buscaTodosPedidosOutputPort;

    public BuscaPedidosPorPrioridadeUseCase(BuscaPedidosOrdenadosPorPrioridadeOutputPort buscaPedidosPorPrioridadeOutputPort, BuscaTodosPedidosOutputPort buscaTodosPedidosOutputPort) {
        this.buscaPedidosPorPrioridadeOutputPort = buscaPedidosPorPrioridadeOutputPort;
        this.buscaTodosPedidosOutputPort = buscaTodosPedidosOutputPort;
    }

    @Override
    public List<PedidoDTO> buscarPorPrioridade() {
        var todosPedidos = buscaTodosPedidosOutputPort.buscarTodos();
        return buscaPedidosPorPrioridadeOutputPort.buscarTodosPorPrioridade(todosPedidos);
    }
}
