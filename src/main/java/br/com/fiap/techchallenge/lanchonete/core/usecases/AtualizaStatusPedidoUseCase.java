package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoStatusIn;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.AtualizaStatusPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.AtualizaStatusPedidoOutputPort;

public class AtualizaStatusPedidoUseCase implements AtualizaStatusPedidoInputPort {
    private final AtualizaStatusPedidoOutputPort atualizaStatusPedidoOutputPort;

    public AtualizaStatusPedidoUseCase(AtualizaStatusPedidoOutputPort atualizaStatusPedidoOutputPort) {
        this.atualizaStatusPedidoOutputPort = atualizaStatusPedidoOutputPort;
    }

    @Override
    public PedidoOut atualizarStatus(Long id, PedidoStatusIn pedidoStatusIn) {
        return atualizaStatusPedidoOutputPort.atualizarStatus(id, pedidoStatusIn.getStatus());
    }
}
