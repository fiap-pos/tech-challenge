package br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusCobrancaEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaStatusCobrancaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class AtualizaStatusCobrancaRequest {
    private StatusCobrancaEnum status;

    AtualizaStatusCobrancaRequest() {

    }

    public AtualizaStatusCobrancaRequest(StatusCobrancaEnum status) {
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

    public AtualizaStatusCobrancaDTO toAtualizaStatusCobrancaDTO() {
        return new AtualizaStatusCobrancaDTO(status);
    }
}
