package br.com.fiap.techchallenge.lanchonete.core.usecases.cliente;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente.BuscaClientePorCpfInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.BuscaClientePorCpfOutputPort;

public class BuscaClientePorCpfUseCase implements BuscaClientePorCpfInputPort {

    private final BuscaClientePorCpfOutputPort buscaClientePorCpfOutputPort;

    public BuscaClientePorCpfUseCase(BuscaClientePorCpfOutputPort buscaClientePorCpfOutputPort) {
        this.buscaClientePorCpfOutputPort = buscaClientePorCpfOutputPort;
    }

    @Override
    public ClienteDTO buscar(String cpf) {
        return buscaClientePorCpfOutputPort.buscar(cpf);
    }
}
