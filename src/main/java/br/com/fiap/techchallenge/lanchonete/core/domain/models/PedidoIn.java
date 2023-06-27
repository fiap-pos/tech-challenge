package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Cliente;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.ItemPedido;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoIn extends PedidoBase{

    public PedidoIn(Long id, StatusPedidoEnum status, LocalDateTime dataCriacao, Cliente cliente, List<ItemPedidoIn> itens) {
        super(id, status, dataCriacao, cliente, itens);
    }
}
