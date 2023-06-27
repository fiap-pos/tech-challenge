package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;

public interface AtualizaStatusPedidoInputPort {
    PedidoOut atualizarStatus(Long id, StatusPedidoEnum status);
}
