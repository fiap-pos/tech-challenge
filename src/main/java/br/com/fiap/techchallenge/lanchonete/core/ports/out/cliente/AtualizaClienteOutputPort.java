package br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;

public interface AtualizaClienteOutputPort {
    ClienteDTO atualizar(ClienteDTO cliente, Long id);
}
