package br.com.fiap.techchallenge.lanchonete.core.port.in.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.CobrancaIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.CobrancaOut;

public interface CriaCobrancaInputPort {
    CobrancaOut criar(CobrancaIn cobrancaIn);
}
