package br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;

public interface CadastraClienteInputPort {
    ClienteDTO cadastrar(ClienteDTO cliente);
}
