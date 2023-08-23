package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaStatusIn;
import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusCobrancaEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class AtualizaStatusCobrancaRequest implements CobrancaStatusIn {
    private StatusCobrancaEnum status;

    AtualizaStatusCobrancaRequest() {

    }

    AtualizaStatusCobrancaRequest(StatusCobrancaEnum status) {
        this.status = status;
    }

    @NotNull(message = "O campo 'status' é obrigatório")
    @Schema(type = "String", title = "Status da cobrança", allowableValues = {"PAGO","CANCELADO"})
    public StatusCobrancaEnum getStatus() {
        return status;
    }

    public void setStatus(StatusCobrancaEnum status) {
        this.status = status;
    }
}
