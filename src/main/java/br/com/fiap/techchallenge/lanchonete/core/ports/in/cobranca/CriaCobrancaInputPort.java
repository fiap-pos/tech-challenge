package br.com.fiap.techchallenge.lanchonete.core.ports.in.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CriaCobrancaDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;

public interface CriaCobrancaInputPort {
    CobrancaDTO criar(CriaCobrancaDTO cobrancaIn);
}
