package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;

import java.math.BigDecimal;

public class PedidoResponse {
    private Long id;
    private StatusPedidoEnum status;
    private BigDecimal valorTotal;

    public PedidoResponse(Long id, StatusPedidoEnum status, BigDecimal valorTotal) {
        this.id = id;
        this.status = status;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return null;
    }

    public StatusPedidoEnum getStatus() {
        return null;
    }

    public BigDecimal getValorTotal() {
        return null;
    }
}
