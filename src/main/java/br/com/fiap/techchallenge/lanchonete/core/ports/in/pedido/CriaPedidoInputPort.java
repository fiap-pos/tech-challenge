package br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CriaPedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;

public interface CriaPedidoInputPort {
    PedidoDTO criar(CriaPedidoDTO pedidoIn);
}
