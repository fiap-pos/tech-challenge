package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.CobrancaStatusIn;

public interface AtualizaStatusCobrancaOutputPort {
    CobrancaOut atualizarStatus(Long id, CobrancaStatusIn cobrancaStatusIn);
}
