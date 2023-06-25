package br.com.fiap.techchallenge.lanchonete.adapters.web.mapper;

import br.com.fiap.techchallenge.lanchonete.adapters.web.models.CobrancaResponse;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.CobrancaOut;
import org.springframework.stereotype.Component;

@Component("CobrancaMapperWeb")
public class CobrancaMapper {
    public CobrancaResponse toCobrancaResponse(CobrancaOut cobrancaOut) {
        return new CobrancaResponse(
                cobrancaOut.getId(),
                cobrancaOut.getPedidoId(),
                cobrancaOut.getStatus().name(),
                cobrancaOut.getValor(),
                cobrancaOut.getQrCode().getEncodedBase64Value()
        );
    }
}
