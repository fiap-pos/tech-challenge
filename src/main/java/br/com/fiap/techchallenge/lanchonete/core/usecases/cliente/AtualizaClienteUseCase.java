package br.com.fiap.techchallenge.lanchonete.core.usecases.cliente;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente.AtualizaClienteInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.AtualizaClienteOutputPort;

public class AtualizaClienteUseCase implements AtualizaClienteInputPort {

    private final AtualizaClienteOutputPort atualizaClienteOutputPort;

    public AtualizaClienteUseCase(AtualizaClienteOutputPort atualizaClienteOutputPort) {
        this.atualizaClienteOutputPort = atualizaClienteOutputPort;
    }

    @Override
    public ClienteDTO atualizar(ClienteDTO cliente, Long id) {
        return atualizaClienteOutputPort.atualizar(cliente, id);
    }
}
