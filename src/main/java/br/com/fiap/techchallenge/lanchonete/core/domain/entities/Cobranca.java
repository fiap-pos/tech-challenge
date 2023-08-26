package br.com.fiap.techchallenge.lanchonete.core.domain.entities;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusCobrancaEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;

import java.math.BigDecimal;

public class Cobranca {

    private Long id;
    private Long pedidoId;
    private StatusCobrancaEnum status;
    private BigDecimal valor;
    private QrCode qrCode;

    public Cobranca(Long pedidoId, StatusCobrancaEnum status, BigDecimal valor, QrCode qrCode) {
        this.pedidoId = pedidoId;
        this.status = status;
        this.qrCode = qrCode;
        this.valor = valor;
    }

    public Cobranca(Long id, Long pedidoId, StatusCobrancaEnum status, BigDecimal valor, QrCode qrCode) {
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
