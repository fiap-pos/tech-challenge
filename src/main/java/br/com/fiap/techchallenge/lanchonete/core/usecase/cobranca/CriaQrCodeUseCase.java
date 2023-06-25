package br.com.fiap.techchallenge.lanchonete.core.usecase.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.QrCode;

import java.math.BigDecimal;

public class CriaQrCodeUseCase {
    QrCode criar(Long pedidoId, BigDecimal valor) {
        return new QrCode(
                generateQrCode(pedidoId, valor)
        );
    }

    private String generateQrCode(Long pedidoId, BigDecimal valor) {
        return "{pedidoId:"+pedidoId+",valor:"+valor+"}";
    }
}
