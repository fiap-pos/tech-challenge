package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.OrdenaPedidosPorPrioridadeInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.OrdenaPedidosPorPrioridadeOututPort;

import java.util.List;

public class OrdenaPedidosPorPrioridadeDoStatusUseCase implements OrdenaPedidosPorPrioridadeInputPort {

    private final OrdenaPedidosPorPrioridadeOututPort ordenaPedidosPorPrioridadeOututPort;

    public OrdenaPedidosPorPrioridadeDoStatusUseCase(OrdenaPedidosPorPrioridadeOututPort ordenaPedidosPorPrioridadeOututPort) {
        this.ordenaPedidosPorPrioridadeOututPort = ordenaPedidosPorPrioridadeOututPort;
    }

    @Override
    public List<PedidoOut> ordena(List<PedidoOut> pedidos) {
        return ordenaPedidosPorPrioridadeOututPort.ordena(pedidos);
    }
}
