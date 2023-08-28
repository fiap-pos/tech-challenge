package br.com.fiap.techchallenge.lanchonete.adapters.web.models.responses;

import java.math.BigDecimal;

public class ItemPedidoResponse {
    private String produtoNome;
    private BigDecimal valorUnitario;
    private Integer quantidade;
    private BigDecimal valorTotal;

    public ItemPedidoResponse(String produtoNome, BigDecimal valorUnitario, Integer quantidade, BigDecimal valorTotal) {
        this.produtoNome = produtoNome;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
