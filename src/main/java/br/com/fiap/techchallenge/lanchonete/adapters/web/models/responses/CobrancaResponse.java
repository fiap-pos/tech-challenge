package br.com.fiap.techchallenge.lanchonete.adapters.web.models.responses;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.QrCode;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusCobrancaEnum;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public class CobrancaResponse {

    private Long id;
    private Long pedidoId;
    private StatusCobrancaEnum status;
    private BigDecimal valor;
    private QrCode qrCode;

    public CobrancaResponse(Long id, Long pedidoId, StatusCobrancaEnum status, BigDecimal valor, QrCode qrCode) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.status = status;
        this.valor = valor;
        this.qrCode = qrCode;
    }

    public Long getId() {
        return id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public StatusCobrancaEnum getStatus() {
        return status;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @JsonIgnore
    public QrCode getQrCode() {
        return qrCode;
    }

    @JsonGetter(value = "qrCode")
    public String getQrCodeAsBase64String() {
        return qrCode.getEncodedBase64Value();
    }
}
