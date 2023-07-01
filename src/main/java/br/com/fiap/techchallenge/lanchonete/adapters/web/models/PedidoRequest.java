package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.ItemPedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.PedidoIn;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PedidoRequest implements PedidoIn {

    private Long clienteId;
    private List<ItemPedidoIn> itens;

    public PedidoRequest() {
    }

    public PedidoRequest(Long clienteId, List<ItemPedidoIn> itens) {
        this.clienteId = clienteId;
        this.itens = itens;
    }

    public Long getClienteId() {
        return clienteId;
    }
    @NotNull(message = "O campo 'itens' é obrigatório")
    @Override
    public List<ItemPedidoIn> getItens() {
        return itens;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public void setItens(List<ItemPedidoIn> itens) {
        this.itens = itens;
    }
}
