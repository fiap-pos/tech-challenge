package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.ItemPedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.PedidoIn;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PedidoRequest implements PedidoIn {

    private Long clienteId;
    private List<ItemPedidoRequest> itens;

    public PedidoRequest() {
    }

    public PedidoRequest(Long clienteId, List<ItemPedidoRequest> itens) {
        this.clienteId = clienteId;
        this.itens = itens;
    }

    public Long getClienteId() {
        return clienteId;
    }
    @NotNull(message = "O campo 'itens' é obrigatório")
    @Override
    public List<ItemPedidoIn> getItens() {
        return itens.stream().map(item -> (ItemPedidoIn) item ).toList();
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public void setItens(List<ItemPedidoRequest> itens) {
        this.itens = itens;
    }
}
