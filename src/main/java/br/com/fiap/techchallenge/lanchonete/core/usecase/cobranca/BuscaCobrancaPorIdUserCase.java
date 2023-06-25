package br.com.fiap.techchallenge.lanchonete.core.usecase.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.cobranca.BuscaCobrancaPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.cobranca.BuscaCobrancaPorIdOutputPort;

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
