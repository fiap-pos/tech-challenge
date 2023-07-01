package br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.ItemPedido;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.ItemPedidoResponse;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.CriaItemPedido;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoOut;
import org.springframework.stereotype.Component;
@Component
public class ItemPedidoMapper {
    private final PedidoMapper pedidoMapper;
    private final ProdutoMapper produtoMapper;

    public ItemPedidoMapper(PedidoMapper pedidoMapper, ProdutoMapper produtoMapper) {
        this.pedidoMapper = pedidoMapper;
        this.produtoMapper = produtoMapper;
    }

    public ItemPedido toItemPedido(CriaItemPedido itemPedidoIn){
        var pedido = pedidoMapper.toPedido(itemPedidoIn.getPedidoIn());
        var produto = produtoMapper.toProduto(itemPedidoIn.getProdutoIn());
        return new ItemPedido(pedido, produto, itemPedidoIn.getQuantidade());
    }

    public ItemPedidoOut toItemPedidoResponse(ItemPedido itemPedido){
        var produto = produtoMapper.toProdutoResponse(itemPedido.getProduto());
        var pedido = pedidoMapper.toPedidoResponse(itemPedido.getPedido());
        return new ItemPedidoResponse(itemPedido.getId(), pedido, produto,
                itemPedido.getQuantidade());
    }
}
