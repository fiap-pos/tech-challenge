package br.com.fiap.techchallenge.lanchonete.adapters.repository.model;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private StatusPedidoEnum status;
    @Column(name = "clienteid")
    private Long clienteid;
    @ManyToOne
    @JoinColumn(name = "produtoid")
    private Produto produto;
    private Integer quantidade;

    public Pedido() {
    }

    public Pedido(StatusPedidoEnum status, Long clienteid, Produto produto,  Integer quantidade) {
        this.status = status;
        this.clienteid = clienteid;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Pedido(Long id, StatusPedidoEnum status, Long clienteid,  Produto produto, Integer quantidade) {
        this.id = id;
        this.status = status;
        this.clienteid = clienteid;
        this.produto = produto;
        this.quantidade = quantidade;
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

    public Long getClienteId() {
        return clienteid;
    }

    public void setClienteId(Long clienteid) {
        this.clienteid = clienteid;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }


    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
