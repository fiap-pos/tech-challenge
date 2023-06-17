package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public enum Categoria {

    LANCHE,
    ACOMPANHAMENTO,
    BEBIDA,
    SOBREMESA;

    @JsonCreator
    public static Categoria fromString(String value) {
        return Stream.of(values())
                .filter(categoria -> categoria.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Categorias permitidas: " + Stream.of(values()).toList()));
    }

}
