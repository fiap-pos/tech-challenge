package br.com.fiap.techchallenge.lanchonete.adapters.repository.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusPedidoEnum status;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    private LocalDateTime data;
    @ManyToOne
    @Nullable
    private Cliente cliente;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, targetEntity = ItemPedido.class)
    private List<ItemPedido> itens = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        data = LocalDateTime.now();
        status = StatusPedidoEnum.PENDENTE_DE_PAGAMENTO;
        setValorTotal();
    }

    public Pedido() {
    }

    public Pedido(StatusPedidoEnum status, LocalDateTime data, @Nullable Cliente cliente, List<ItemPedido> itens) {
        this.status = status;
        this.data = data;
        this.cliente = cliente;
        this.itens = itens;
    }
    public Pedido(StatusPedidoEnum status, LocalDateTime data, List<ItemPedido> itens) {
        this.status = status;
        this.data = data;
        this.itens = itens;
    }

    public Pedido(StatusPedidoEnum status, Cliente cliente, LocalDateTime data, BigDecimal valorTotal) {
        this.status = status;
        this.cliente = cliente;
        this.data = data;
        this.valorTotal = valorTotal;
    }
    public Pedido(StatusPedidoEnum status, LocalDateTime data, BigDecimal valorTotal) {
        this.status = status;
        this.data = data;
        this.valorTotal = valorTotal;
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
    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Nullable
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(@Nullable Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public BigDecimal setValorTotal() {
        return valorTotal;
    }
}
