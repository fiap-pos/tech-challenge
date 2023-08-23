package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CriaPedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;

public interface CriaPedidoOutputPort {
    PedidoOut criar(CriaPedidoIn criaPedidoIn);
}
