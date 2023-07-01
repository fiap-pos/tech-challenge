package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CriaItemPedidoIn;

import java.math.BigDecimal;

public class CriaItemPedido extends ItemPedidoBase implements CriaItemPedidoIn {
    private BigDecimal valorUnitario;
    public CriaItemPedido(Long id, Integer quantidade, BigDecimal valorUnitario) {
        super(id, quantidade);
        this.valorUnitario = valorUnitario;
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
