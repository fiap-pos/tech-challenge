package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoIn;

public interface EditarPedidoOutputPort {
    PedidoOut editar(PedidoIn pedidoIn);
}
