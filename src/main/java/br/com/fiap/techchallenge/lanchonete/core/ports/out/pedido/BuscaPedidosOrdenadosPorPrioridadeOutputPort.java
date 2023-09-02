package br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido;

import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;

import java.util.List;

public interface BuscaPedidosOrdenadosPorPrioridadeOutputPort {

    List<PedidoDTO> buscarTodosPorPrioridade(List<PedidoDTO> pedidos);

}
