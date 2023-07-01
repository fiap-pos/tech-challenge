package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CriaPedido {
    private Long id;
    private StatusPedidoEnum status;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private Long clienteid;
    private List<CriaItemPedido> itens = new ArrayList<>();
    private BigDecimal valorTotal;

    public CriaPedido() {
    }

    public CriaPedido(Long id, StatusPedidoEnum status, LocalDateTime dataCriacao, Long clienteid, List<CriaItemPedido> itens) {
        this.id = id;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.clienteid = clienteid;
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

    public Long getClienteid() {
        return clienteid;
    }

    public void setClienteid(Long clienteid) {
        this.clienteid = clienteid;
    }

    public List<CriaItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<CriaItemPedido> itens) {
        this.itens = itens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
