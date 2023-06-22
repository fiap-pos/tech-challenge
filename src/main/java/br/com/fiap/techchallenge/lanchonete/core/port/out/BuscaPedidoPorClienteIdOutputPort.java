package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoOut;

import java.util.List;

public interface BuscaPedidoPorClienteIdOutputPort {
    List<PedidoOut> buscaPedidosDoCliente(Long clienteid);
}
