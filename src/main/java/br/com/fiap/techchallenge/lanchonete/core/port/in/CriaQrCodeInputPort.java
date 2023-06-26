package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.QrCode;

import java.math.BigDecimal;

public interface CriaQrCodeInputPort {
    QrCode criar(Long pedidoId, BigDecimal valor);
}