package br.com.fiap.techchallenge.lanchonete.core.ports.in;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaIn;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaOut;

public interface CriaCobrancaInputPort {
    CobrancaOut criar(CobrancaIn cobrancaIn);
}
