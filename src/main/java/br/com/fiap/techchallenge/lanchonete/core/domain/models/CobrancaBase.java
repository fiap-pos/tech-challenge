package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusCobrancaEnum;
import java.math.BigDecimal;

public class CobrancaBase implements CobrancaOut {

    private Long id;
    private Long pedidoId;
    private StatusCobrancaEnum status;
    private BigDecimal valor;
    private QrCode qrCode;

    public CobrancaBase(Long pedidoId, StatusCobrancaEnum status, BigDecimal valor, QrCode qrCode) {
        this.pedidoId = pedidoId;
        this.status = status;
        this.qrCode = qrCode;
        this.valor = valor;
    }

    public CobrancaBase(Long id, Long pedidoId, StatusCobrancaEnum status, BigDecimal valor, QrCode qrCode) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.status = status;
        this.qrCode = qrCode;
        this.valor = valor;
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

    public QrCode getQrCode() {
        return qrCode;
    }
}
