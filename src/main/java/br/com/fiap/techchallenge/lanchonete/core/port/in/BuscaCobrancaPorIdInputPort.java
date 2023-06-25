package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.CobrancaOut;

public interface BuscaCobrancaPorIdInputPort {
    CobrancaOut buscaPorId(Long id);
}
