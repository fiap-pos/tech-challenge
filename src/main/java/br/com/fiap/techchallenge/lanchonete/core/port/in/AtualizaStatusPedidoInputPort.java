package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.PedidoStatusIn;

public interface AtualizaStatusPedidoInputPort {
    PedidoOut atualizarStatus(Long id, PedidoStatusIn pedidoStatusIn);
}
