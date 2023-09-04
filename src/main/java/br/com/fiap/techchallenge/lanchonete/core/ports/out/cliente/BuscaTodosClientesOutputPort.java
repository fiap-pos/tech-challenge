package br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import java.util.List;

public interface BuscaTodosClientesOutputPort {
    List<ClienteDTO> buscarTodos();
}
