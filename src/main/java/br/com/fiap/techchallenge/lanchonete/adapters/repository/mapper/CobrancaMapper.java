package br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Cobranca;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.CobrancaBase;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.QrCode;
import org.springframework.stereotype.Component;

@Component
public class CobrancaMapper {
    public Cobranca toCobranca(CobrancaBase cobrancaBase) {
        return new Cobranca(
                cobrancaBase.getPedidoId(),
                cobrancaBase.getStatus(),
                cobrancaBase.getValor(),
                cobrancaBase.getQrCode().getEncodedBase64Value()
        );
    }

    public CobrancaOut toCobrancaOut(Cobranca cobranca) {
        return new CobrancaBase(
            cobranca.getId(),
            cobranca.getPedidoId(),
            cobranca.getStatus(),
            cobranca.getValor(),
            new QrCode(cobranca.getQrCode())
        );
    }
}
