package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.CobrancaIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.CobrancaOut;

public interface CriaCobrancaInputPort {
    CobrancaOut criar(CobrancaIn cobrancaIn);
}
