package br.com.fiap.techchallenge.lanchonete.utils.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Produto;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.CategoriaEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;

import java.math.BigDecimal;

public abstract class ProdutoHelper {

    private static final Long ID = 1L;

    private static final String NOME = "HAMBURGER ANGUS";
    private static final CategoriaEnum CATEGORIA = CategoriaEnum.LANCHE;
    private static final BigDecimal PRECO = BigDecimal.valueOf(35.90);
    private static final String DESCRICAO = "Hamburger Angus 200mg de carne";

    public static ProdutoDTO getProdutoDTO() {
        return new ProdutoDTO(NOME, CATEGORIA, PRECO, DESCRICAO);
    }

    public static Produto getProduto() {
        return new Produto(ID, NOME, CATEGORIA, PRECO, DESCRICAO);
    }
}
