package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaStatusIn;

public interface AtualizaStatusCobrancaOutputPort {
    CobrancaOut atualizarStatus(Long id, CobrancaStatusIn cobrancaStatusIn);
}
