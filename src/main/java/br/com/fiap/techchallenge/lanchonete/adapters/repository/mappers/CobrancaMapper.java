package br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Cobranca;
import br.com.fiap.techchallenge.lanchonete.core.entities.CobrancaBase;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.entities.QrCode;
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
