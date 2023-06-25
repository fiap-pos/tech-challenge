package br.com.fiap.techchallenge.lanchonete.core.usecase.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.CobrancaBase;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.CobrancaIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.enums.StatusCobrancaEnum;
import br.com.fiap.techchallenge.lanchonete.core.port.in.cobranca.CriaCobrancaInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.cobranca.CriaCobrancaOutputPort;

import java.math.BigDecimal;

public class CriaCobrancaUseCase implements CriaCobrancaInputPort {

    private final CriaCobrancaOutputPort cobrancaOutputPort;
    private final CriaQrCodeUseCase criaQrCodeUseCase;

    public CriaCobrancaUseCase(CriaCobrancaOutputPort cobrancaOutputPort, CriaQrCodeUseCase criaQrCodeUseCase) {
        this.cobrancaOutputPort = cobrancaOutputPort;
        this.criaQrCodeUseCase = criaQrCodeUseCase;
    }

    public CobrancaOut criar(CobrancaIn cobrancaIn) {
        var valor = new BigDecimal(150);
        var qrCode = criaQrCodeUseCase.criar(cobrancaIn.getPedidoId(), valor);
        var cobranca = new CobrancaBase(
                cobrancaIn.getPedidoId(), StatusCobrancaEnum.PENDENTE, valor, qrCode
        );
        return cobrancaOutputPort.criar(cobranca);
    }
}
