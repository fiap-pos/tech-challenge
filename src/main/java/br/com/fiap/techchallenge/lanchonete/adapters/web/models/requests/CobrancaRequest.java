package br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CriaCobrancaDTO;
import jakarta.validation.constraints.NotNull;

public class CobrancaRequest {

    private Long pedidoId;

    public CobrancaRequest() {}

    public CobrancaRequest(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    @NotNull(message = "O campo pedidoId é obrigatório")
    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public CriaCobrancaDTO toCriaCobrancaDTO() {
        return new CriaCobrancaDTO(pedidoId);
    }
}
