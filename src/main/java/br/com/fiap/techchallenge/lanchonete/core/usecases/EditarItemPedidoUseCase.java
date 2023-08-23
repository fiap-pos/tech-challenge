package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.entities.CriaItemPedido;
import br.com.fiap.techchallenge.lanchonete.core.entities.ItemPedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.EditarItemPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.EditarItemPedidoOutputPort;

public class EditarItemPedidoUseCase implements EditarItemPedidoInputPort {
    private final EditarItemPedidoOutputPort editarItemPedidoOutputPort;

    public EditarItemPedidoUseCase(EditarItemPedidoOutputPort editarItemPedidoOutputPort) {
        this.editarItemPedidoOutputPort = editarItemPedidoOutputPort;
    }

    @Override
    public ItemPedidoOut editarItem(CriaItemPedido itemPedidoIn) {
        return editarItemPedidoOutputPort.editarItem(itemPedidoIn);
    }
}
