package br.com.fiap.techchallenge.lanchonete.core.dtos;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;

public record AtualizaStatusPedidoDTO(StatusPedidoEnum status) {
}
