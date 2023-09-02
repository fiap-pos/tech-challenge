package br.com.fiap.techchallenge.lanchonete.core.usecases.pedido;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.BuscaPedidosOrdenadosPorPrioridadeInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.BuscaTodosPedidosOutputPort;

import java.util.ArrayList;
import java.util.List;

public class BuscaPedidosPorPrioridadeUseCase implements BuscaPedidosOrdenadosPorPrioridadeInputPort {

    private final BuscaTodosPedidosOutputPort buscaTodosPedidosOutputPort;

    public BuscaPedidosPorPrioridadeUseCase(BuscaTodosPedidosOutputPort buscaTodosPedidosOutputPort) {
        this.buscaTodosPedidosOutputPort = buscaTodosPedidosOutputPort;
    }

    @Override
    public List<PedidoDTO> buscarPorPrioridade() {
        return ordenaPedidosPorPrioridade(buscaTodosPedidosOutputPort.buscarTodos());
    }

    private static List<PedidoDTO> ordenaPedidosPorPrioridade(List<PedidoDTO> pedidos) {
        List<PedidoDTO> pedidosOrdenadosPorPrioridade = new ArrayList<PedidoDTO>();

        pedidos.forEach(
                pedidoOut -> {
                    if (pedidoOut.status().equals(StatusPedidoEnum.PRONTO)) {
                        pedidosOrdenadosPorPrioridade.add(pedidoOut);
                    }
                }
        );

        pedidos.forEach(
                pedidoOut -> {
                    if (pedidoOut.status().equals(StatusPedidoEnum.EM_PREPARACAO)) {
                        pedidosOrdenadosPorPrioridade.add(pedidoOut);
                    }
                }
        );

        pedidos.forEach(
                pedidoOut -> {
                    if (pedidoOut.status().equals(StatusPedidoEnum.RECEBIDO)) {
                        pedidosOrdenadosPorPrioridade.add(pedidoOut);
                    }
                }
        );

        return pedidosOrdenadosPorPrioridade;
    }
}
