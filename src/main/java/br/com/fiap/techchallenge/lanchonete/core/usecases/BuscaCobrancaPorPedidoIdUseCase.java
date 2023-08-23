package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.BuscaCobrancaPorPedidoIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.BuscaCobrancaOutputPort;

public class BuscaCobrancaPorPedidoIdUseCase implements BuscaCobrancaPorPedidoIdInputPort{

    private BuscaCobrancaOutputPort buscaCobrancaOutputPort;

    public BuscaCobrancaPorPedidoIdUseCase(BuscaCobrancaOutputPort buscaCobrancaOutputPort) {
        this.buscaCobrancaOutputPort = buscaCobrancaOutputPort;
    }
    @Override
    public CobrancaOut buscarPorPedidoId(Long pedidoId) { return buscaCobrancaOutputPort.buscarPorPedidoId(pedidoId); }
}
