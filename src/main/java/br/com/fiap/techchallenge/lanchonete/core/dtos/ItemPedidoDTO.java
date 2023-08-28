package br.com.fiap.techchallenge.lanchonete.core.dtos;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.ItemPedido;

import java.math.BigDecimal;

public record ItemPedidoDTO(
        Long produtoId,
        String produtoNome,
        BigDecimal valorUnitario,
        Integer quantidade
) {

    public ItemPedidoDTO(ItemPedido itemPedido) {
        this(itemPedido.getProdutoId(), itemPedido.getProdutoNome(), itemPedido.getValorUnitario(), itemPedido.getQuantidade());
    }

    public BigDecimal getValorTotal() {
        return BigDecimal.valueOf(quantidade).multiply(valorUnitario);
    }
}
