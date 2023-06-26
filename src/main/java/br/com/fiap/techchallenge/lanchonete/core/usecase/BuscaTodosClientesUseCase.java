package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaTodosClientesInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaTodosClientesOutputPort;

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
