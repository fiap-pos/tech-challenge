package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.CriaPedidoOutputPort;

public class CriaPedidoUseCase implements CriaPedidoInputPort {

    private final CriaPedidoOutputPort criaPedidoOutputPort;

    public CriaPedidoUseCase(CriaPedidoOutputPort criaPedidoOutputPort) {
        this.criaPedidoOutputPort = criaPedidoOutputPort;
    }

    @Override
    public PedidoOut criar(PedidoIn pedidoIn) {
        return criaPedidoOutputPort.criar(pedidoIn);
    }
}
