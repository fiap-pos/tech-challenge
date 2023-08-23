package br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;

public interface BuscaClientePorCpfInputPort {
    ClienteDTO buscar(String cpf);
}
