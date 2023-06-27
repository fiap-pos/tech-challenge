package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Cliente;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.ItemPedido;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoIn;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoRequest extends PedidoIn {
    public PedidoRequest(Long id, StatusPedidoEnum status, LocalDateTime dataCriacao, Cliente cliente, List<ItemPedido> itens) {
        super(id, status, dataCriacao, cliente, itens);
    }
}
