package br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import java.util.List;

public interface BuscaTodosClientesInputPort {
    List<ClienteDTO> buscarTodos();
}
