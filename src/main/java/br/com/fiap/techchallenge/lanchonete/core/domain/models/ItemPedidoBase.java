package br.com.fiap.techchallenge.lanchonete.core.domain.models;

public abstract class ItemPedidoBase {

    private Long id;

    private Integer quantidade;

    public ItemPedidoBase(Long id, Integer quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
