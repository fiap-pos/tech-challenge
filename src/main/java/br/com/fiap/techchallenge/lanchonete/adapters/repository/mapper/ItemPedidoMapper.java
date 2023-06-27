package br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.ItemPedido;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.ItemPedidoResponse;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoOut;
import org.springframework.stereotype.Component;
@Component
public class ItemPedidoMapper {
    public ItemPedido toItemPedido(ItemPedidoIn itemPedidoIn){
        return new ItemPedido(itemPedidoIn.getPedido(), itemPedidoIn.getProduto(), itemPedidoIn.getQuantidade());
    }

    public ItemPedidoOut toItemPedidoResponse(ItemPedido itemPedido){
        return new ItemPedidoResponse(itemPedido.getId(), itemPedido.getPedido(), itemPedido.getProduto(),
                itemPedido.getQuantidade());
    }
}
