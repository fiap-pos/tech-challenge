package br.com.fiap.techchallenge.lanchonete.adapters.out;


import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.OrdenaPedidosPorPrioridadeOutputPort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrdenaPedidosPorPrioridadeAdapter implements OrdenaPedidosPorPrioridadeOutputPort {
    @Override
    public List<PedidoDTO> ordena(List<PedidoDTO> pedidos) {
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
