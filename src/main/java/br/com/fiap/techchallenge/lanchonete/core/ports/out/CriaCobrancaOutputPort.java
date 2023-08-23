package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.entities.CobrancaBase;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaOut;

public interface CriaCobrancaOutputPort {
    CobrancaOut criar(CobrancaBase cobranca);
}
