package br.com.fiap.techchallenge.lanchonete.core.usecases.cliente;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente.BuscaClientePorInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.BuscaClienteOutputPort;

public class BuscaClientePorUseCase implements BuscaClientePorInputPort {

    private final BuscaClienteOutputPort buscaClienteOutputPort;

    public BuscaClientePorUseCase(BuscaClienteOutputPort buscaClienteOutputPort) {
        this.buscaClienteOutputPort = buscaClienteOutputPort;
    }

    @Override
    public ClienteDTO buscar(String cpf) {
        return buscaClienteOutputPort.buscar(cpf);
    }

    @Override
    public ClienteDTO buscar(Long id) {
        return buscaClienteOutputPort.buscar(id);
    }
}
