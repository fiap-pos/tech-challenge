package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.CobrancaBase;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CobrancaOut;

public interface CriaCobrancaOutputPort {
    CobrancaOut criar(CobrancaBase cobranca);
}
