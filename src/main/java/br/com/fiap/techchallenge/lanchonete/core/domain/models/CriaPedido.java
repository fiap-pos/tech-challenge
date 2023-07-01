package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Cliente;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CriaPedidoIn;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CriaPedido implements CriaPedidoIn {
    private Long id;
    private Long clienteId;
    private StatusPedidoEnum status;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private List<CriaItemPedido> itens = new ArrayList<>();
    private BigDecimal valorTotal;

    public CriaPedido() {
    }

    public CriaPedido(Long id, StatusPedidoEnum status, LocalDateTime dataCriacao, List<CriaItemPedido> itens) {
        this.id = id;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.itens = itens;
    }
    public CriaPedido(Long id, Long clienteId, StatusPedidoEnum status, LocalDateTime dataCriacao, List<CriaItemPedido> itens) {
        this.id = id;
        this.clienteId = clienteId;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.itens = itens;
    }

    @Override
    public Long getClienteId() {
        return clienteId;
    }

    @Override
    public StatusPedidoEnum getStatus() {
        return status;
    }

    @Override
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    @Override
    public List<CriaItemPedido> getItens() {
        return itens;
    }

    @Override
    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCliente(Long clienteId) {
        this.clienteId = clienteId;
    }

    public void setStatus(StatusPedidoEnum status) {
        this.status = status;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setItens(List<CriaItemPedido> itens) {
        this.itens = itens;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
