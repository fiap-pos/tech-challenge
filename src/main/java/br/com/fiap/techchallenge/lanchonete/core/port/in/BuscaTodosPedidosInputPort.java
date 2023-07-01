package br.com.fiap.techchallenge.lanchonete.core.port.in;

import java.util.List;

public interface BuscaTodosPedidosInputPort {
    List<PedidoOut> buscarTodos();
}
