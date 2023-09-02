package br.com.fiap.techchallenge.lanchonete.core.ports.in.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaStatusCobrancaDTO;

public interface AtualizaStatusCobrancaInputPort {
    CobrancaDTO atualizarStatus(Long id, AtualizaStatusCobrancaDTO cobrancaStatusIn);
}
