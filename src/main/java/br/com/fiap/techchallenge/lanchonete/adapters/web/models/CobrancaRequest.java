package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.CobrancaIn;
import jakarta.validation.constraints.NotNull;

public class CobrancaRequest implements CobrancaIn {

    private Long pedidoId;

    public CobrancaRequest() {}

    public CobrancaRequest(Long pedidoId) {
        this.pedidoId = pedidoId;
    }
    @Override
    @NotNull(message = "O campo pedidoId é obrigatório")
    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }
}
