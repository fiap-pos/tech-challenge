package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.exceptions.EntityAlreadyExistException;
import br.com.fiap.techchallenge.lanchonete.core.entities.CobrancaBase;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaIn;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusCobrancaEnum;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.CriaCobrancaInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.BuscaCobrancaOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.BuscarPedidoPorIdOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.CriaQrCodeOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.CriaCobrancaOutputPort;

public class CriaCobrancaUseCase implements CriaCobrancaInputPort {

    private final CriaCobrancaOutputPort cobrancaOutputPort;

    private final CriaQrCodeOutputPort criaQrCodeOutputPort;

    private final BuscarPedidoPorIdOutputPort buscarPedidoPorIdOutputPort;

    private final BuscaCobrancaOutputPort buscaCobrancaOutputPort;

    public CriaCobrancaUseCase(
            CriaCobrancaOutputPort cobrancaOutputPort,
            CriaQrCodeOutputPort criaQrCodeOutputPort,
            BuscarPedidoPorIdOutputPort buscarPedidoPorIdOutputPort,
            BuscaCobrancaOutputPort buscaCobrancaOutputPort
    ) {
        this.cobrancaOutputPort = cobrancaOutputPort;
        this.criaQrCodeOutputPort = criaQrCodeOutputPort;
        this.buscarPedidoPorIdOutputPort = buscarPedidoPorIdOutputPort;
        this.buscaCobrancaOutputPort = buscaCobrancaOutputPort;
    }

    public CobrancaOut criar(CobrancaIn cobrancaIn) {
        var pedidoOut = buscarPedidoPorIdOutputPort.buscarPorId(cobrancaIn.getPedidoId());

        validaExisteCobranca(pedidoOut.getId());

        var qrCode = criaQrCodeOutputPort.criar(cobrancaIn.getPedidoId(), pedidoOut.getValorTotal());
        var cobranca = new CobrancaBase(
                cobrancaIn.getPedidoId(), StatusCobrancaEnum.PENDENTE, pedidoOut.getValorTotal(), qrCode
        );
        return cobrancaOutputPort.criar(cobranca);
    }

    private void validaExisteCobranca(Long pedidoId) {
        if (buscaCobrancaOutputPort.pedidoPossuiCobranca(pedidoId)) {
            throw new EntityAlreadyExistException("Já existe uma cobrança para o pedido " + pedidoId);
        }
    }
}
