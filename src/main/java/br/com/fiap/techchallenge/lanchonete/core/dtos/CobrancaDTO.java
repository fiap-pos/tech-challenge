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
}
