package br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido;


import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import java.util.List;

public interface BuscaTodosPedidosInputPort {
    List<PedidoDTO> buscarTodos();
}
