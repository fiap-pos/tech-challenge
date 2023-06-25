package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.CobrancaOut;

public interface BuscaCobrancaPorIdOutputPort {
    CobrancaOut buscaPorId(Long id);
}
