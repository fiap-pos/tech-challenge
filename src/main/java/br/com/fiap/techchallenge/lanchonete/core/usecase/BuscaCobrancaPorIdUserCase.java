package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaCobrancaPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaCobrancaPorIdOutputPort;

public class BuscaCobrancaPorIdUserCase implements BuscaCobrancaPorIdInputPort {

    private BuscaCobrancaPorIdOutputPort buscaCobrancaPorIdOutputPort;

    public BuscaCobrancaPorIdUserCase(BuscaCobrancaPorIdOutputPort buscaCobrancaPorIdOutputPort) {
        this.buscaCobrancaPorIdOutputPort = buscaCobrancaPorIdOutputPort;
    }
    @Override
    public CobrancaOut buscaPorId(Long id) {
        return buscaCobrancaPorIdOutputPort.buscaPorId(id);
    }
}
