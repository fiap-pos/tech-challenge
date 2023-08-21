package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaCobrancaPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaCobrancaPorPedidoIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaCobrancaOutputPort;

public class BuscaCobrancaPorPedidoIdUseCase implements BuscaCobrancaPorPedidoIdInputPort{

    private BuscaCobrancaOutputPort buscaCobrancaOutputPort;

    public BuscaCobrancaPorPedidoIdUseCase(BuscaCobrancaOutputPort buscaCobrancaOutputPort) {
        this.buscaCobrancaOutputPort = buscaCobrancaOutputPort;
    }
    @Override
    public CobrancaOut buscarPorPedidoId(Long pedidoId) { return buscaCobrancaOutputPort.buscarPorPedidoId(pedidoId); }
}
