package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.CobrancaStatusIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusCobrancaEnum;
import jakarta.validation.constraints.NotNull;

public class AtualizaStatusCobrancaRequest implements CobrancaStatusIn {
    private StatusCobrancaEnum status;

    AtualizaStatusCobrancaRequest() {

    }

    AtualizaStatusCobrancaRequest(StatusCobrancaEnum status) {
        this.status = status;
    }

    @NotNull(message = "O campo 'status' é obrigatório")
    public StatusCobrancaEnum getStatus() {
        return status;
    }

    public void setStatus(StatusCobrancaEnum status) {
        this.status = status;
    }
}
