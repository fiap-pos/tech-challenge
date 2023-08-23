package br.com.fiap.techchallenge.lanchonete.core.entities;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CriaItemPedidoIn;

import java.math.BigDecimal;

public class CriaItemPedido  implements CriaItemPedidoIn {
    private Long produtoId;
    private BigDecimal valorUnitario;
    private Integer quantidade;

    public CriaItemPedido(Long produtoId, BigDecimal valorUnitario, Integer quantidade) {
        this.produtoId = produtoId;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    @Override
    public Long getProdutoId() {
        return produtoId;
    }

    @Override
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public Integer getQuantidade() {
        return quantidade;
    }

}
