package br.com.fiap.techchallenge.lanchonete.core.ports.out.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.Cobranca;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaOut;

public interface CriaCobrancaOutputPort {
    CobrancaOut criar(Cobranca cobranca);
}
