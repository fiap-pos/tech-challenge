package br.com.fiap.techchallenge.lanchonete.core.entities;

import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusPedidoEnum;

import java.math.BigDecimal;
import java.util.List;

public class Pedido {
    private Long id;
    private Cliente cliente;
    private BigDecimal valorTotal;
    private List<ItemPedido> itens;
    private StatusPedidoEnum status;

    public Pedido(Long id, Cliente cliente, BigDecimal valorTotal, List<ItemPedido> itens, StatusPedidoEnum status) {
        this.id = id;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.itens = itens;
        this.status = status;
    }
    public Pedido(Long id, BigDecimal valorTotal, List<ItemPedido> itens, StatusPedidoEnum status) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.itens = itens;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public StatusPedidoEnum getStatus() {
        return status;
    }
}
