package br.com.fiap.techchallenge.lanchonete.core.usecases.cliente;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente.BuscaTodosClientesInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.BuscaTodosClientesOutputPort;

import java.util.List;

public class BuscaTodosClientesUseCase implements BuscaTodosClientesInputPort {

    private final BuscaTodosClientesOutputPort buscaTodosClientesOutputPort;

    public BuscaTodosClientesUseCase(BuscaTodosClientesOutputPort buscaTodosClientesOutputPort) {
        this.buscaTodosClientesOutputPort = buscaTodosClientesOutputPort;
    }

    @Override
    public List<ClienteDTO> buscarTodos() {
        return buscaTodosClientesOutputPort.buscarTodos();
    }
}
