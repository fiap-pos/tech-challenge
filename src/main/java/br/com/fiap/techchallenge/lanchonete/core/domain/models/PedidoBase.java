package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Cliente;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.ItemPedido;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class PedidoBase {
    private Long id;
    private StatusPedidoEnum status;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();
    private BigDecimal valorTotal;

    public PedidoBase(Long id, StatusPedidoEnum status, LocalDateTime dataCriacao, Cliente cliente, List<ItemPedido> itens) {
        this.id = id;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.cliente = cliente;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusPedidoEnum getStatus() {
        return status;
    }

    public void setStatus(StatusPedidoEnum status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens.stream().map(itemPedido ->
                new ItemPedido(itemPedido.getId(), itemPedido.getPedido(), itemPedido.getProduto(), itemPedido.getQuantidade())
        ).toList();
    }

    public BigDecimal getValorTotal() {
        if (itens.isEmpty()){
            return BigDecimal.ZERO;
        }
        return itens.stream()
                .map(itemPedido -> itemPedido.getProduto().getPreco()
                        .multiply(BigDecimal.valueOf(itemPedido.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
