package br.com.fiap.techchallenge.lanchonete.core.ports.in;

import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoStatusIn;

public interface AtualizaStatusPedidoInputPort {
    PedidoOut atualizarStatus(Long id, PedidoStatusIn pedidoStatusIn);
}
