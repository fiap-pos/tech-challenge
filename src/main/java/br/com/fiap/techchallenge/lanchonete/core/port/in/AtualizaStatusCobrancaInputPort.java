package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.CobrancaStatusIn;

public interface AtualizaStatusCobrancaInputPort {
    CobrancaOut atualizarStatus(Long id, CobrancaStatusIn cobrancaStatusIn);
}
