package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.ports.in.RemoverPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.RemoverPedidoOutputPort;

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
