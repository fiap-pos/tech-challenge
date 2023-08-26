package br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.Cobranca;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.QrCode;
import org.springframework.stereotype.Component;

@Component
public class CobrancaMapper {
    public br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Cobranca toCobranca(Cobranca cobranca) {
        return new br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Cobranca(
                cobranca.getPedidoId(),
                cobranca.getStatus(),
                cobranca.getValor(),
                cobranca.getQrCode().getEncodedBase64Value()
        );
    }

    public CobrancaOut toCobrancaOut(br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Cobranca cobranca) {
        return new Cobranca(
            cobranca.getId(),
            cobranca.getPedidoId(),
            cobranca.getStatus(),
            cobranca.getValor(),
            new QrCode(cobranca.getQrCode())
        );
    }
}
