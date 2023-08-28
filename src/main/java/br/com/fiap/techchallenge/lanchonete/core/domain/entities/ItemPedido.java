package br.com.fiap.techchallenge.lanchonete.core.domain.entities;

import java.math.BigDecimal;

public class ItemPedido {
    private Long produtoId;
    private String produtoNome;
    private BigDecimal valorUnitario;
    private Integer quantidade;

    public ItemPedido(Long produtoId, String produtoNome, BigDecimal valorUnitario, Integer quantidade) {
        this.produtoId = produtoId;
        this.produtoNome = produtoNome;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public ItemPedido(Long produtoId, BigDecimal valorUnitario, Integer quantidade) {
        this.produtoId = produtoId;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return BigDecimal.valueOf(quantidade).multiply(valorUnitario);
    }
}
