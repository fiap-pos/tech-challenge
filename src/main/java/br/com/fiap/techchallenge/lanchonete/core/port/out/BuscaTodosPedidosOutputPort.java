package br.com.fiap.techchallenge.lanchonete.core.port.out;

import java.util.List;

public interface BuscaTodosPedidosOutputPort {
    List<PedidoOut> buscarTodos();
}
