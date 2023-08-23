package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;

import java.util.List;

public interface BuscaTodosPedidosOutputPort {
    List<PedidoOut> buscarTodos();
}
