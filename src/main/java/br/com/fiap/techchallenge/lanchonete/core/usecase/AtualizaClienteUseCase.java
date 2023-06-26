package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.AtualizaClienteInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.AtualizaClienteOutputPort;

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
