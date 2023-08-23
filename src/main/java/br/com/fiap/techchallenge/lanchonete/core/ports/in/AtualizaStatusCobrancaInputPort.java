package br.com.fiap.techchallenge.lanchonete.core.ports.in;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaStatusIn;

public interface AtualizaStatusCobrancaInputPort {
    CobrancaOut atualizarStatus(Long id, CobrancaStatusIn cobrancaStatusIn);
}
