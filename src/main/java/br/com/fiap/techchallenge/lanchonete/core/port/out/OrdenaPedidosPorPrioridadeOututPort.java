package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoOut;

import java.util.List;

public interface OrdenaPedidosPorPrioridadeOututPort {

    List<PedidoOut> ordena(List<PedidoOut> pedidos);

}
