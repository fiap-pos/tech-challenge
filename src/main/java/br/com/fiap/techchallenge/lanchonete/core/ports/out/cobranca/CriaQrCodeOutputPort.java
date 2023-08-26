package br.com.fiap.techchallenge.lanchonete.core.ports.out.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.QrCode;

import java.math.BigDecimal;

public interface CriaQrCodeOutputPort {
    QrCode criar(Long pedidoId, BigDecimal valor);
}
