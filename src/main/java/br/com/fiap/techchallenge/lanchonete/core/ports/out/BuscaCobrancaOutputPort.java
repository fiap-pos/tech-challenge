package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaOut;

public interface BuscaCobrancaOutputPort {
    CobrancaOut buscarPorId(Long id);

    CobrancaOut buscarPorPedidoId(Long pedidoId);

    boolean pedidoPossuiCobranca(Long pedidoId);
}
