package br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FilaProducaoResponse (Long codigo, String clienteNome, List<FilaProducaoItem> itens, StatusPedidoEnum status, LocalDateTime data) {

    public FilaProducaoResponse(Long codigo, List<FilaProducaoItem> itens, StatusPedidoEnum status, LocalDateTime data) {
        this(codigo, null, itens, status, data);
    }
}
