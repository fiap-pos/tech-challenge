package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import java.math.BigDecimal;

public class ItemPedidoOut {

    private BigDecimal valorUnitario;
    private String produtoNome;
    private Integer quantidade;
    private String produtoDescricao;

    public ItemPedidoOut(Integer quantidade, BigDecimal valorUnitario, String produtoNome, String produtoDescricao) {
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.produtoNome = produtoNome;
        this.produtoDescricao = produtoDescricao;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public BigDecimal getValorTotal(){
        return BigDecimal.valueOf(quantidade).multiply(valorUnitario);
    }

    public String getProdutoNome() {
        return produtoNome;
    }
    public Integer getQuantidade() {
        return quantidade;
    }

    public String getProdutoDescricao() {
        return produtoDescricao;
    }
}
