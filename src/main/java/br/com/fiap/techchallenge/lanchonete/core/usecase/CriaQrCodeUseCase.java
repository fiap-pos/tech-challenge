package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.QrCode;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaQrCodeInputPort;

import java.math.BigDecimal;

public class CriaQrCodeUseCase implements CriaQrCodeInputPort {
    @Override
    public QrCode criar(Long pedidoId, BigDecimal valor) {
        return new QrCode(
                generateQrCode(pedidoId, valor)
        );
    }

    private String generateQrCode(Long pedidoId, BigDecimal valor) {
        return "{pedidoId:"+pedidoId+",valor:"+valor+"}";
    }
}
