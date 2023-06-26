package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaClientePorCpfInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaClientePorCpfOutputPort;

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
