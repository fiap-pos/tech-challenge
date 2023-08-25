package br.com.fiap.techchallenge.lanchonete.core.dtos;

import java.math.BigDecimal;

public record ItemPedidoDTO(
        Long produtoId,
        String produtoNome,
        BigDecimal valorUnitario,
        Integer quantidade
) {
    public BigDecimal getValorTotal(){
        return BigDecimal.valueOf(quantidade).multiply(valorUnitario);
    }
}
