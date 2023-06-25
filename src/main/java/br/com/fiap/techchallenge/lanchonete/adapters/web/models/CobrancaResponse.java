package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import java.math.BigDecimal;

public class CobrancaResponse {

    private Long id;
    private Long pedidoId;
    private String status;
    private BigDecimal valor;
    private String qrCode;

    public CobrancaResponse(Long id, Long pedidoId, String status, BigDecimal valor, String qrCode) {
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

    public String getStatus() {
        return status;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getQrCode() {
        return qrCode;
    }
}
