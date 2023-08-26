package br.com.fiap.techchallenge.lanchonete.core.ports.in.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;

public interface BuscaCobrancaPorIdInputPort {
    CobrancaDTO buscarPorId(Long id);
}
