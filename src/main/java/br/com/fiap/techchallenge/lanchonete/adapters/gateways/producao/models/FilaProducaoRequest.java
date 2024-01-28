package br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FilaProducaoRequest (Long codigo, String clienteNome, List<FilaProducaoItem> itens) {

    public FilaProducaoRequest(Long codigo, List<FilaProducaoItem> itens) {
        this(codigo, null, itens);
    }
}
