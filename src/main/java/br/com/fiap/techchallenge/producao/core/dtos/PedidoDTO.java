package br.com.fiap.techchallenge.producao.core.dtos;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoDTO(
        String id,
        Long codigo,
        ClienteDTO cliente,
        List<ItemPedidoDTO> itens,
        StatusPedidoEnum status,
        LocalDateTime dataCriacao
) {
    public PedidoDTO(Long codigo, List<ItemPedidoDTO> itens, StatusPedidoEnum status, LocalDateTime dataCriacao) {
        this(null, codigo, null, itens, status, dataCriacao);
    }
}
