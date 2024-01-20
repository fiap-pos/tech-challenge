package br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class WebhookStatusCobrancaRequest {
    @NotNull
    @NotBlank
    private String action;

    @NotNull
    private WebhookDataRequest data;

    public WebhookStatusCobrancaRequest() {
    }

    public WebhookStatusCobrancaRequest(String action, WebhookDataRequest data) {
        this.action = action;
        this.data = data;
    }


    public String getAction() {
        return action;
    }

    public WebhookDataRequest getData() {
        return data;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setData(WebhookDataRequest data) {
        this.data = data;
    }
}