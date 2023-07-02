package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.QrCode;

import java.math.BigDecimal;

public interface CriaQrCodeOutputPort {
    QrCode criar(Long pedidoId, BigDecimal valor);
}