package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CobrancaIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CobrancaOut;

public interface CriaCobrancaInputPort {
    CobrancaOut criar(CobrancaIn cobrancaIn);
}
