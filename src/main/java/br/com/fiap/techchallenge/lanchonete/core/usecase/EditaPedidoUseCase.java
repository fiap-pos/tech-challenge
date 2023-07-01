package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.port.in.EditarPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.EditarPedidoOutputPort;

public class EditaPedidoUseCase implements EditarPedidoInputPort {

    private final EditarPedidoOutputPort editarPedidoOutputPort;

    public EditaPedidoUseCase(EditarPedidoOutputPort editarPedidoOutputPort) {
        this.editarPedidoOutputPort = editarPedidoOutputPort;
    }

    @Override
    public PedidoOut editar(PedidoIn pedidoIn) {
        return editarPedidoOutputPort.editar(pedidoIn);
    }
}
