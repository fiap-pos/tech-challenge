package br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FilaProducaoDTO(Long codigo, List<FilaProducaoItemDTO> itens) {

}
