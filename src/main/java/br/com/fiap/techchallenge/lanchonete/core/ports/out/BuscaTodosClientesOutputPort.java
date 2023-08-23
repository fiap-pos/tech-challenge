package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.entities.ClienteOut;

import java.util.List;

public interface BuscaTodosClientesOutputPort {
    List<ClienteOut> buscarTodos();
}
