package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.entities.QrCode;

import java.math.BigDecimal;

public interface CriaQrCodeOutputPort {
    QrCode criar(Long pedidoId, BigDecimal valor);
}
