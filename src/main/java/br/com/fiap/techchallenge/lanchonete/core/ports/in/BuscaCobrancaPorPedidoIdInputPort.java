package br.com.fiap.techchallenge.lanchonete.core.ports.in;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaOut;

public interface BuscaCobrancaPorPedidoIdInputPort {
    CobrancaOut buscarPorPedidoId(Long pedidoId);
}
