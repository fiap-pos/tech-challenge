package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CobrancaOut;

public interface BuscaCobrancaPorPedidoIdInputPort {
    CobrancaOut buscarPorPedidoId(Long pedidoId);
}
