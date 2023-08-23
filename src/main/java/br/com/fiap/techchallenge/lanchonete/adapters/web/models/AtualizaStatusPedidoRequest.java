package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoStatusIn;
import jakarta.validation.constraints.NotNull;

public class AtualizaStatusPedidoRequest implements PedidoStatusIn {
    private StatusPedidoEnum status;

    public AtualizaStatusPedidoRequest() {
    }

    public AtualizaStatusPedidoRequest(StatusPedidoEnum status) {
        this.status = status;
    }

    @Override
    @NotNull(message = "O campo 'status' é obrigatório")
    public StatusPedidoEnum getStatus() {
        return status;
    }

    public void setStatus(StatusPedidoEnum status) {
        this.status = status;
    }
}
