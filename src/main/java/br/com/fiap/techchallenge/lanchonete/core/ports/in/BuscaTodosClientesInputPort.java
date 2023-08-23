package br.com.fiap.techchallenge.lanchonete.core.ports.in;

import br.com.fiap.techchallenge.lanchonete.core.entities.ClienteOut;

import java.util.List;

public interface BuscaTodosClientesInputPort {
    List<ClienteOut> buscarTodos();
}
