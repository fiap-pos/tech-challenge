package br.com.fiap.techchallenge.lanchonete.core.ports.in.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;

public interface BuscaCobrancaPorPedidoIdInputPort {
    CobrancaDTO buscarPorPedidoId(Long pedidoId);
}
