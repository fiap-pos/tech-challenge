package br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;
import jakarta.persistence.*;

import java.util.List;

public abstract class PedidoOut {
    private Long id;
    private StatusPedidoEnum status;
    private Long clienteId;
    private Long produtoid;
    private Integer quantidade;

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

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getProdutoid() {
        return produtoid;
    }

    public void setProdutoid(Long produtoid) {
        this.produtoid = produtoid;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
