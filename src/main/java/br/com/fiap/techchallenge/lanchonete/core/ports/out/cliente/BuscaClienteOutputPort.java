package br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;

public interface BuscaClienteOutputPort {
    ClienteDTO buscarPorId(String id);

    ClienteDTO buscarPorToken(String authorization);
}
