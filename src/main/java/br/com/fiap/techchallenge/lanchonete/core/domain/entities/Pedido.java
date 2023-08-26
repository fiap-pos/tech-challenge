package br.com.fiap.techchallenge.lanchonete.core.domain.entities;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Long id;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private StatusPedidoEnum status;

    private LocalDateTime dataCriacao;

    public Pedido(Long id, List<ItemPedido> itens, StatusPedidoEnum status, LocalDateTime dataCriacao) {
        this.id = id;
        this.itens = List.copyOf(itens);
        this.status = status;
        this.dataCriacao = dataCriacao;
    }
    public Pedido(StatusPedidoEnum status) {
        this.itens = new ArrayList<>();
        this.status = status;
        this.dataCriacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValorTotal() {
        return itens.stream()
                .map(ItemPedido::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<ItemPedido> getItens() {
        return List.copyOf(itens);
    }

    public void addItemPedido(ItemPedido item) {
        itens.add(item);
    }

    public StatusPedidoEnum getStatus() {
        return status;
    }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
}
