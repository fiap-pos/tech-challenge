package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.CriaItemPedido;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.EditarItemPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.EditarItemPedidoOutputPort;

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
