package br.com.fiap.techchallenge.lanchonete.core.port.out.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.CobrancaBase;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.CobrancaOut;

public interface CriaCobrancaOutputPort {
    CobrancaOut criar(CobrancaBase cobranca);
}
