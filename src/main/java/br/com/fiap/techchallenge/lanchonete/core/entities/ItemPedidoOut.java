package br.com.fiap.techchallenge.lanchonete.core.entities;

import java.math.BigDecimal;

public class ItemPedidoOut {

    private BigDecimal valorUnitario;
    private String produtoNome;
    private Integer quantidade;
    public ItemPedidoOut(Integer quantidade, BigDecimal valorUnitario, String produtoNome) {
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.produtoNome = produtoNome;

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

}
