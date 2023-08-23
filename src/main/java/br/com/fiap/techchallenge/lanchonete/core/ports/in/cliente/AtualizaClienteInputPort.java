package br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;

public interface AtualizaClienteInputPort {
    ClienteDTO atualizar(ClienteDTO cliente, Long id);
}
