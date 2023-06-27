package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Cliente;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.ItemPedido;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Pedido;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;

import java.time.LocalDateTime;
import java.util.List;

public class ItemPedidoOut extends ItemPedidoBase{

    public ItemPedidoOut(Long id, Pedido pedido, Produto produto, int quantidade) {
        super(id, pedido, produto, quantidade);
    }
}
