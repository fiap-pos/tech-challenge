package br.com.fiap.techchallenge.lanchonete.core.usecases.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cobranca.BuscaCobrancaPorPedidoIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cobranca.BuscaCobrancaOutputPort;

public class BuscaCobrancaPorPedidoIdUseCase implements BuscaCobrancaPorPedidoIdInputPort{

    private BuscaCobrancaOutputPort buscaCobrancaOutputPort;

    public BuscaCobrancaPorPedidoIdUseCase(BuscaCobrancaOutputPort buscaCobrancaOutputPort) {
        this.buscaCobrancaOutputPort = buscaCobrancaOutputPort;
    }
    @Override
    public CobrancaDTO buscarPorPedidoId(Long pedidoId) { return buscaCobrancaOutputPort.buscarPorPedidoId(pedidoId); }
}
