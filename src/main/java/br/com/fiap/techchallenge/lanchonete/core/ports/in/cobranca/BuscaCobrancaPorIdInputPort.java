package br.com.fiap.techchallenge.lanchonete.core.ports.in.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaOut;

public interface BuscaCobrancaPorIdInputPort {
    CobrancaOut buscarPorId(Long id);
}
