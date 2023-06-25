package br.com.fiap.techchallenge.lanchonete.core.port.out.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.CobrancaOut;

public interface BuscaCobrancaPorIdOutputPort {
    CobrancaOut buscaPorId(Long id);
}
