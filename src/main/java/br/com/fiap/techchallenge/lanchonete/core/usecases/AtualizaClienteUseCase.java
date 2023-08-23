package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.entities.ClienteIn;
import br.com.fiap.techchallenge.lanchonete.core.entities.ClienteOut;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.AtualizaClienteInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.AtualizaClienteOutputPort;

public class AtualizaClienteUseCase implements AtualizaClienteInputPort {

    private final AtualizaClienteOutputPort atualizaClienteOutputPort;

    public AtualizaClienteUseCase(AtualizaClienteOutputPort atualizaClienteOutputPort) {
        this.atualizaClienteOutputPort = atualizaClienteOutputPort;
    }

    @Override
    public ClienteOut atualizar(ClienteIn cliente, Long id) {
        return atualizaClienteOutputPort.atualizar(cliente, id);
    }
}
