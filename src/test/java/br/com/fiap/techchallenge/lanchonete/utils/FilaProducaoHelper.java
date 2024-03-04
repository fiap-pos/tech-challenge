package br.com.fiap.techchallenge.lanchonete.utils;

import br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.models.FilaProducaoDTO;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.models.FilaProducaoItemDTO;

import java.util.List;

public class FilaProducaoHelper {

    private static final Long codigo = 1L;
    private static final List<FilaProducaoItemDTO> itens = getFilaProducaoItemDTO();
    private static final String nome = "NOME";
    private static final String descricao = "DESCRICAO";
    private static final int quantidade = 10;

    public static FilaProducaoDTO getFilaProducaoDTO() {
        return new FilaProducaoDTO(codigo, itens);
    }

    public static FilaProducaoDTO getFilaProducaoDTO_semItens() {
        return new FilaProducaoDTO(codigo, null);
    }

    private static List<FilaProducaoItemDTO> getFilaProducaoItemDTO() {
        return List.of(new FilaProducaoItemDTO(nome, descricao, quantidade));
    }

}
