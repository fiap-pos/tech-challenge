package br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido;

import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface EnviaPedidoFilaProducaoOutputPort {
    void enviarPedido(PedidoDTO pedidoDTO);
}
