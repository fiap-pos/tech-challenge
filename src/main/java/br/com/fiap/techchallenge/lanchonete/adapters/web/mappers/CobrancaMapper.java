package br.com.fiap.techchallenge.lanchonete.adapters.web.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.web.models.CobrancaResponse;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaOut;
import org.springframework.stereotype.Component;

@Component("CobrancaMapperWeb")
public class CobrancaMapper {
    public CobrancaResponse toCobrancaResponse(CobrancaOut cobrancaOut) {
        return new CobrancaResponse(
                cobrancaOut.getId(),
                cobrancaOut.getPedidoId(),
                cobrancaOut.getStatus(),
                cobrancaOut.getValor(),
                cobrancaOut.getQrCode()
        );
    }
}
