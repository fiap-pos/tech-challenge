package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.AtualizaStatusPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.AtualizaStatusPedidoOutputPort;

public class AtualizaStatusPedidoUseCase implements AtualizaStatusPedidoInputPort {
    private final AtualizaStatusPedidoOutputPort atualizaStatusPedidoOutputPort;
    public AtualizaStatusPedidoUseCase(AtualizaStatusPedidoOutputPort atualizaStatusPedidoOutputPort) {
        this.atualizaStatusPedidoOutputPort = atualizaStatusPedidoOutputPort;
    }
    @Override
    public PedidoOut atualizarStatus(PedidoIn pedidoIn) {
        return atualizaStatusPedidoOutputPort.atualizarStatus(pedidoIn);
    }
}
