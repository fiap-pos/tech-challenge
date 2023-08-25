package br.com.fiap.techchallenge.lanchonete.core.dtos;

import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusPedidoEnum;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PedidoDTO(
        Long id,
        ClienteDTO cliente,
        List<ItemPedidoDTO> itens,
        StatusPedidoEnum status,
        BigDecimal valorTotal,
        LocalDateTime dataCriacao
) {

}
