package br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;

public interface BuscaClientePorIdInputPort {
    ClienteDTO buscar(String cpf);

    ClienteDTO buscar(Long id);
}
