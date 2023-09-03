package br.com.fiap.techchallenge.lanchonete.adapters.web.models.responses;

import java.math.BigDecimal;

public class ItemPedidoResponse {
    private String produtoNome;
    private String produtoDescricao;
    private BigDecimal valorUnitario;
    private Integer quantidade;
    private BigDecimal valorTotal;

    public ItemPedidoResponse(String produtoNome, String produtoDescricao, BigDecimal valorUnitario, Integer quantidade, BigDecimal valorTotal) {
        this.produtoNome = produtoNome;
        this.produtoDescricao = produtoDescricao;
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

    public String getProdutoDescricao() {
        return produtoDescricao;
    }

    public void setProdutoDescricao(String produtoDescricao) {
        this.produtoDescricao = produtoDescricao;
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
