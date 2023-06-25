package br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.enums;

public enum StatusCobrancaEnum {
    PENDENTE("Pendente"),

    PAGO("Pago"),

    CANCELADO("Cancelado");

    private final String descricao;

    StatusCobrancaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
