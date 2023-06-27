package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.CobrancaBase;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.CobrancaIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusCobrancaEnum;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaCobrancaInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaQrCodeInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.CriaCobrancaOutputPort;

import java.math.BigDecimal;

public class CriaCobrancaUseCase implements CriaCobrancaInputPort {

    private final CriaCobrancaOutputPort cobrancaOutputPort;
    private final CriaQrCodeInputPort criaQrCodeInputPort;

    public CriaCobrancaUseCase(CriaCobrancaOutputPort cobrancaOutputPort, CriaQrCodeInputPort criaQrCodeInputPort) {
        this.cobrancaOutputPort = cobrancaOutputPort;
        this.criaQrCodeInputPort = criaQrCodeInputPort;
    }

    public CobrancaOut criar(CobrancaIn cobrancaIn) {
        var valor = new BigDecimal(150);
        var qrCode = criaQrCodeInputPort.criar(cobrancaIn.getPedidoId(), valor);
        var cobranca = new CobrancaBase(
                cobrancaIn.getPedidoId(), StatusCobrancaEnum.PENDENTE, valor, qrCode
        );
        return cobrancaOutputPort.criar(cobranca);
    }
}
