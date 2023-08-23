package br.com.fiap.techchallenge.lanchonete.core.ports.in;


import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;

import java.util.List;

public interface BuscaTodosPedidosInputPort {
    List<PedidoOut> buscarTodos();
}
