package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteOut;

import java.util.List;

public interface BuscaTodosClientesOutputPort {
    List<ClienteOut> buscarTodos();
}
