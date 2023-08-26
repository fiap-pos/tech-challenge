package br.com.fiap.techchallenge.lanchonete.core.dtos;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.Pedido;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
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
    public String getNomeCliente() {
        return cliente != null ? cliente.nome() : null;
    }

    public PedidoDTO(Pedido pedido) {
        this(
            pedido.getId(),
            pedido.getCliente() != null ? new ClienteDTO(pedido.getCliente()) : null,
            pedido.getItens().stream().map(ItemPedidoDTO::new).toList(),
            pedido.getStatus(),
            pedido.getValorTotal(),
            pedido.getDataCriacao()
        );
    }

}
