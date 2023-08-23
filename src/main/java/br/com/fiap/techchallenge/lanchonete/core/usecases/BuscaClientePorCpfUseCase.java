package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.entities.ClienteOut;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.BuscaClientePorCpfInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.BuscaClientePorCpfOutputPort;

public class BuscaClientePorCpfUseCase implements BuscaClientePorCpfInputPort {

    private final BuscaClientePorCpfOutputPort buscaClientePorCpfOutputPort;

    public BuscaClientePorCpfUseCase(BuscaClientePorCpfOutputPort buscaClientePorCpfOutputPort) {
        this.buscaClientePorCpfOutputPort = buscaClientePorCpfOutputPort;
    }

    @Override
    public ClienteOut buscar(String cpf) {
        return buscaClientePorCpfOutputPort.buscar(cpf);
    }
}
