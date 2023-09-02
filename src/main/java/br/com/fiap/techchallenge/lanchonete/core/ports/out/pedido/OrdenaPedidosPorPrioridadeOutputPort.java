package br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido;

import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;

import java.util.List;

public interface OrdenaPedidosPorPrioridadeOutputPort {

    List<PedidoDTO> ordena(List<PedidoDTO> pedidos);

}
