package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.exception.BadRequestException;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CobrancaStatusIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusCobrancaEnum;
import br.com.fiap.techchallenge.lanchonete.core.port.in.AtualizaStatusCobrancaInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.AtualizaStatusCobrancaOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaCobrancaPorIdOutputPort;

public class AtualizaStatusCobrancaUseCase implements AtualizaStatusCobrancaInputPort {

    private final BuscaCobrancaPorIdOutputPort buscaCobrancaPorIdOutputPort;
    private final AtualizaStatusCobrancaOutputPort atualizaStatusCobrancaOutputPort;

    public AtualizaStatusCobrancaUseCase(
        BuscaCobrancaPorIdOutputPort buscaCobrancaPorIdOutputPort,
        AtualizaStatusCobrancaOutputPort atualizaStatusCobrancaOutputPort
    ) {
        this.buscaCobrancaPorIdOutputPort = buscaCobrancaPorIdOutputPort;
        this.atualizaStatusCobrancaOutputPort = atualizaStatusCobrancaOutputPort;
    }
    @Override
    public CobrancaOut atualizarStatus(Long id, CobrancaStatusIn cobrancaStatusIn) {
        var cobrancaOut = buscaCobrancaPorIdOutputPort.buscarPorId(id);
        if (cobrancaOut.getStatus() != StatusCobrancaEnum.PENDENTE) {
            throw new BadRequestException("Cobranca "+id+" não pode mais ser atualizada.");
        }
        return atualizaStatusCobrancaOutputPort.atualizarStatus(id, cobrancaStatusIn);
    }
}
