package br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public enum StatusPedidoEnum {
    PENDENTE_DE_PAGAMENTO("Aguardando Pagamento"),
    RECEBIDO("Recebido"),
    EM_PREPARACAO("Em preparação"),
    PRONTO("Pronto"),
    FINALIZADO("Finalizado"),
    CANCELADO ("Cancelado");

    private final String descricao;

    StatusPedidoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static StatusPedidoEnum fromString(String value) {
        return Stream.of(values())
                .filter(status -> status.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Status permitidos: " + Stream.of(values()).toList()));
    }

}
