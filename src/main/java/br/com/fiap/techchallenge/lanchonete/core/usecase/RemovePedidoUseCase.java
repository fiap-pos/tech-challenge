package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.port.in.RemoverPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.RemoverPedidoOutputPort;

public class RemovePedidoUseCase implements RemoverPedidoInputPort {
    private final RemoverPedidoOutputPort removerPedidoOutputPort;

    public RemovePedidoUseCase(RemoverPedidoOutputPort removerPedidoOutputPort) {
        this.removerPedidoOutputPort = removerPedidoOutputPort;
    }

    @Override
    public void remover(Long id) {
        removerPedidoOutputPort.remover(id);
    }
}
