package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CadastraClienteInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.CadastraClienteOutputPort;


public class CadastraClienteUseCase implements CadastraClienteInputPort {

    private final CadastraClienteOutputPort cadastraClienteOutputPort;

    public CadastraClienteUseCase(CadastraClienteOutputPort cadastraClienteOutputPort) {
        this.cadastraClienteOutputPort = cadastraClienteOutputPort;
    }

    @Override
    public ClienteOut cadastrar(ClienteIn cliente) {
        return cadastraClienteOutputPort.cadastrar(cliente);
    }
}
