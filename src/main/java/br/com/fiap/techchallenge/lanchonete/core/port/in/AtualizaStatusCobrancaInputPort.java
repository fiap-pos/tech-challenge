package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CobrancaStatusIn;

public interface AtualizaStatusCobrancaInputPort {
    CobrancaOut atualizarStatus(Long id, CobrancaStatusIn cobrancaStatusIn);
}
