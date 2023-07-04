package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CobrancaOut;

public interface BuscaCobrancaPorIdOutputPort {
    CobrancaOut buscarPorId(Long id);
}
