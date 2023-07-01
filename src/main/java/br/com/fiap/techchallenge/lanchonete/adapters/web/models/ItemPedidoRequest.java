package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.ItemPedidoIn;
import jakarta.validation.constraints.NotNull;

public class ItemPedidoRequest implements ItemPedidoIn {
    private Long pedidoId;
    private Integer quantidade;
    public ItemPedidoRequest(Long pedidoId, Integer quantidade) {
        this.pedidoId = pedidoId;
        this.quantidade = quantidade;
    }

    @Override
    @NotNull(message = "O campo 'pedido' é obrigatório")
    public Long getPedidoId() {
        return pedidoId;
    }

    @Override
    @NotNull(message = "O campo 'quantidade' é obrigatório")
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
