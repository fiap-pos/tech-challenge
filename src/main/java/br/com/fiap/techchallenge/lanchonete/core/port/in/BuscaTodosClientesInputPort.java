package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteOut;

import java.util.List;

public interface BuscaTodosClientesInputPort {
    List<ClienteOut> buscarTodos();
}
