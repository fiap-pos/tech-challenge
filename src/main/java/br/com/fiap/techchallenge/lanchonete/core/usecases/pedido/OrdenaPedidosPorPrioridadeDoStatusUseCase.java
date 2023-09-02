package br.com.fiap.techchallenge.lanchonete.core.usecases.pedido;

import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.OrdenaPedidosPorPrioridadeInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.OrdenaPedidosPorPrioridadeOutputPort;

import java.util.List;

public class OrdenaPedidosPorPrioridadeDoStatusUseCase implements OrdenaPedidosPorPrioridadeInputPort {

    private final OrdenaPedidosPorPrioridadeOutputPort ordenaPedidosPorPrioridadeOututPort;

    public OrdenaPedidosPorPrioridadeDoStatusUseCase(OrdenaPedidosPorPrioridadeOutputPort ordenaPedidosPorPrioridadeOututPort) {
        this.ordenaPedidosPorPrioridadeOututPort = ordenaPedidosPorPrioridadeOututPort;
    }

    @Override
    public List<PedidoDTO> ordena(List<PedidoDTO> pedidos) {
        return ordenaPedidosPorPrioridadeOututPort.ordena(pedidos);
    }
}
