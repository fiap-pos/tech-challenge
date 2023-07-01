package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaCobrancaPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaCobrancaPorIdOutputPort;

public class BuscaCobrancaPorIdUserCase implements BuscaCobrancaPorIdInputPort {

    private BuscaCobrancaPorIdOutputPort buscaCobrancaPorIdOutputPort;

    public BuscaCobrancaPorIdUserCase(BuscaCobrancaPorIdOutputPort buscaCobrancaPorIdOutputPort) {
        this.buscaCobrancaPorIdOutputPort = buscaCobrancaPorIdOutputPort;
    }
    @Override
    public CobrancaOut buscarPorId(Long id) {
        return buscaCobrancaPorIdOutputPort.buscarPorId(id);
    }
}
