package br.com.fiap.techchallenge.lanchonete.core.ports.out.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;

public interface CriaCobrancaOutputPort {
    CobrancaDTO criar(CobrancaDTO cobranca);
}
