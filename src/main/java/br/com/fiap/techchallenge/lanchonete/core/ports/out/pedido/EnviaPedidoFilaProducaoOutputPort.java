package br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido;

import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;

public interface EnviaPedidoFilaProducaoOutputPort {
    void enviarPedido(PedidoDTO pedidoDTO);
}
