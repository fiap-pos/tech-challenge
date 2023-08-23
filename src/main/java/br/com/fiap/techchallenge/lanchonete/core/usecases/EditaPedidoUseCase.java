package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.EditarPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.EditarPedidoOutputPort;

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
