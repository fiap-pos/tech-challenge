package br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.QrCode;
import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaStatusPedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class AtualizaStatusPedidoRequest {
    private Long id;
    private Long pedidoId;
    private StatusPedidoEnum status;
    private BigDecimal valor;
    private QrCode qrcode;

    public AtualizaStatusPedidoRequest() {
    }

    public AtualizaStatusPedidoRequest(Long id, Long pedidoId, StatusPedidoEnum status, BigDecimal valor, QrCode qrcode) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.status = status;
        this.valor = valor;
        this.qrcode = qrcode;
    }

    @NotNull(message = "O campo 'status' é obrigatório")
    public StatusPedidoEnum getStatus() {
        return status;
    }

    public void setStatus(StatusPedidoEnum status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public AtualizaStatusPedidoDTO toAtualizaStatusPedidoDTO() {
        return new AtualizaStatusPedidoDTO(
            status
        );
    }
}
