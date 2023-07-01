package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;

import java.math.BigDecimal;
import java.util.List;

public class PedidoOut {
    private Long id;
    private String clienteNome;
    private BigDecimal valorTotal;
    private List<ItemPedidoOut> itens;
    private StatusPedidoEnum status;

    public PedidoOut(Long id, String clienteNome, BigDecimal valorTotal, List<ItemPedidoOut> itens, StatusPedidoEnum status) {
        this.id = id;
        this.clienteNome = clienteNome;
        this.valorTotal = valorTotal;
        this.itens = itens;
        this.status = status;
    }
    public PedidoOut(Long id, BigDecimal valorTotal, List<ItemPedidoOut> itens, StatusPedidoEnum status) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.itens = itens;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getCliente() {
        return clienteNome;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public List<ItemPedidoOut> getItens() {
        return itens;
    }

    public StatusPedidoEnum getStatus() {
        return status;
    }
}
