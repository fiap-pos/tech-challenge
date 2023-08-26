package br.com.fiap.techchallenge.lanchonete.core.ports.out.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaStatusCobrancaDTO;

public interface AtualizaStatusCobrancaOutputPort {
    CobrancaOut atualizarStatus(Long id, AtualizaStatusCobrancaDTO cobrancaStatusIn);
}
