package br.com.fiap.techchallenge.lanchonete.core.ports.in.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaStatusCobrancaDTO;

public interface AtualizaStatusCobrancaInputPort {
    CobrancaOut atualizarStatus(Long id, AtualizaStatusCobrancaDTO cobrancaStatusIn);
}
