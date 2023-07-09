package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.ItemPedidoIn;
import jakarta.validation.constraints.NotNull;

public class ItemPedidoRequest implements ItemPedidoIn {
    private Long produtoId;
    private Integer quantidade;

    public ItemPedidoRequest() {
    }

    public ItemPedidoRequest(Long produtoId, Integer quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    @Override
    @NotNull(message = "O campo 'produtoId' é obrigatório")
    public Long getProdutoId() {
        return produtoId;
    }

    @Override
    @NotNull(message = "O campo 'quantidade' é obrigatório")
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
