package br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;

public interface BuscaClienteOutputPort {
    ClienteDTO buscar(String cpf);

    ClienteDTO buscar(Long id);
}
