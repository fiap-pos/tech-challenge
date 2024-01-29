package br.com.fiap.techchallenge.lanchonete.core.dtos;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;

import java.math.BigDecimal;

public record CobrancaDTO(Long id, Long pedidoId, BigDecimal valor, StatusPedidoEnum status, String qrCode) {
}
