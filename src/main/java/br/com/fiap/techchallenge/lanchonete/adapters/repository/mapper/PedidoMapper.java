package br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Pedido;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.PedidoResponse;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CriaPedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoOut;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {
    private final ItemPedidoMapper itemPedidoMapper;

    public PedidoMapper(ItemPedidoMapper itemPedidoMapper) {
        this.itemPedidoMapper = itemPedidoMapper;
    }

    public Pedido toPedido(CriaPedidoIn pedidoIn){
        var pedido =  new Pedido(pedidoIn.getStatus(),pedidoIn.getValorTotal(), pedidoIn.getDataCriacao());
        var itemPedido = itemPedidoMapper.toItemPedido(pedido, pedidoIn.getItens());
        pedido.setItens(itemPedido);
        return pedido;

    }

    public PedidoOut toPedidoResponse(Pedido pedido){
        var listaItemPedidoOut = itemPedidoMapper.toItemPedidoResponse(pedido.getItens());
        return new PedidoResponse(pedido.getId(),pedido.getValorTotal(), listaItemPedidoOut, pedido.getStatus());
    }
}
