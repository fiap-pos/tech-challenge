package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CobrancaOut;

public interface BuscaCobrancaOutputPort {
    CobrancaOut buscarPorId(Long id);

    CobrancaOut buscarPorPedidoId(Long pedidoId);

    boolean pedidoPossuiCobranca(Long pedidoId);
}
