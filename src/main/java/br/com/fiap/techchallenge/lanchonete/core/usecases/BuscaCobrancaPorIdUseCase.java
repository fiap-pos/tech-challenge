package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.BuscaCobrancaPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.BuscaCobrancaOutputPort;

public class BuscaCobrancaPorIdUseCase implements BuscaCobrancaPorIdInputPort {

    private BuscaCobrancaOutputPort buscaCobrancaOutputPort;

    public BuscaCobrancaPorIdUseCase(BuscaCobrancaOutputPort buscaCobrancaOutputPort) {
        this.buscaCobrancaOutputPort = buscaCobrancaOutputPort;
    }
    @Override
    public CobrancaOut buscarPorId(Long id) {
        return buscaCobrancaOutputPort.buscarPorId(id);
    }

}
