package br.com.fiap.techchallenge.lanchonete.adapters.integration;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.QrCode;
import br.com.fiap.techchallenge.lanchonete.core.port.out.CriaQrCodeOutputPort;

import java.math.BigDecimal;

public class PagamentoMock implements CriaQrCodeOutputPort {
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
