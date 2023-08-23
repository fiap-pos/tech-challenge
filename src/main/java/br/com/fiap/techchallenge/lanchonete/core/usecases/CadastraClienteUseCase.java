package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.entities.ClienteIn;
import br.com.fiap.techchallenge.lanchonete.core.entities.ClienteOut;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.CadastraClienteInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.CadastraClienteOutputPort;


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
