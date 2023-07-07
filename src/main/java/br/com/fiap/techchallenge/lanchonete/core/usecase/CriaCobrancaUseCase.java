package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.CobrancaBase;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CobrancaIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusCobrancaEnum;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaCobrancaInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscarPedidoPorIdOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.CriaQrCodeOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.CriaCobrancaOutputPort;

public class CriaCobrancaUseCase implements CriaCobrancaInputPort {

    private final CriaCobrancaOutputPort cobrancaOutputPort;

    private final CriaQrCodeOutputPort criaQrCodeOutputPort;

    private final BuscarPedidoPorIdOutputPort buscarPedidoPorIdOutputPort;



    public CriaCobrancaUseCase(
            CriaCobrancaOutputPort cobrancaOutputPort,
            CriaQrCodeOutputPort criaQrCodeOutputPort,
            BuscarPedidoPorIdOutputPort buscarPedidoPorIdOutputPort
    ) {
        this.cobrancaOutputPort = cobrancaOutputPort;
        this.criaQrCodeOutputPort = criaQrCodeOutputPort;
        this.buscarPedidoPorIdOutputPort = buscarPedidoPorIdOutputPort;
    }

    public CobrancaOut criar(CobrancaIn cobrancaIn) {
        var pedidoOut = buscarPedidoPorIdOutputPort.buscarPorId(cobrancaIn.getPedidoId());
        var qrCode = criaQrCodeOutputPort.criar(cobrancaIn.getPedidoId(), pedidoOut.getValorTotal());
        var cobranca = new CobrancaBase(
                cobrancaIn.getPedidoId(), StatusCobrancaEnum.PENDENTE, pedidoOut.getValorTotal(), qrCode
        );
        return cobrancaOutputPort.criar(cobranca);
    }
}
