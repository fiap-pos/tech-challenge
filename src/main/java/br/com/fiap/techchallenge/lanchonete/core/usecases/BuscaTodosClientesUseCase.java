package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.entities.ClienteOut;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.BuscaTodosClientesInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.BuscaTodosClientesOutputPort;

import java.util.List;

public class BuscaTodosClientesUseCase implements BuscaTodosClientesInputPort {

    private final BuscaTodosClientesOutputPort buscaTodosClientesOutputPort;

    public BuscaTodosClientesUseCase(BuscaTodosClientesOutputPort buscaTodosClientesOutputPort) {
        this.buscaTodosClientesOutputPort = buscaTodosClientesOutputPort;
    }

    @Override
    public List<ClienteOut> buscarTodos() {
        return buscaTodosClientesOutputPort.buscarTodos();
    }
}
