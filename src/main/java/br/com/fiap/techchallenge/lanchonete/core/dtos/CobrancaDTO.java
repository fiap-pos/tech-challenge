package br.com.fiap.techchallenge.lanchonete.core.dtos;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.Cobranca;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.QrCode;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusCobrancaEnum;

import java.math.BigDecimal;

public record CobrancaDTO(Long id, Long pedidoId, BigDecimal valor, StatusCobrancaEnum status, QrCode qrCode) {
    public CobrancaDTO(Cobranca cobranca) {
        this(
            cobranca.getId(),
            cobranca.getPedidoId(),
            cobranca.getValor(),
            cobranca.getStatus(),
            cobranca.getQrCode()
        );
    }

    public CobrancaDTO(Long id, Long pedidoId, BigDecimal valor, StatusCobrancaEnum status, QrCode qrCode) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.valor = valor;
        this.status = status;
        this.qrCode = qrCode;
    }
}
