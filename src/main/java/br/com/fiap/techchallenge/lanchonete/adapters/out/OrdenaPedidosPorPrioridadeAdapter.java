package br.com.fiap.techchallenge.lanchonete.adapters.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.port.out.OrdenaPedidosPorPrioridadeOututPort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrdenaPedidosPorPrioridadeAdapter implements OrdenaPedidosPorPrioridadeOututPort {
    @Override
    public List<PedidoOut> ordena(List<PedidoOut> pedidos) {
        List<PedidoOut> pedidosOrdenadosPorPrioridade = new ArrayList<PedidoOut>();

        pedidos.forEach(
                pedidoOut -> {
                    if (pedidoOut.getStatus().equals(StatusPedidoEnum.PRONTO)) {
                        pedidosOrdenadosPorPrioridade.add(pedidoOut);
                    }
                }
        );

        pedidos.forEach(
                pedidoOut -> {
                    if (pedidoOut.getStatus().equals(StatusPedidoEnum.EM_PREPARACAO)) {
                        pedidosOrdenadosPorPrioridade.add(pedidoOut);
                    }
                }
        );

        pedidos.forEach(
                pedidoOut -> {
                    if (pedidoOut.getStatus().equals(StatusPedidoEnum.RECEBIDO)) {
                        pedidosOrdenadosPorPrioridade.add(pedidoOut);
                    }
                }
        );

        return pedidosOrdenadosPorPrioridade;
    }
}
