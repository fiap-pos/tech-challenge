package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.SpringIntegrationTest;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ProdutoJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Produto;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.CategoriaEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

class ProdutoRepositoryIT extends SpringIntegrationTest {

    @Autowired
    ProdutoJpaRepository produtoJpaRepository;

    @Test
    void devePermitirCriarTabela() {
        criarProdutoBebida();
        var totalRegistros = produtoJpaRepository.count();
        assertThat(totalRegistros).isGreaterThan(0);
    }

    @Test
    void criarProdutoLanche() {
        var produto = new Produto(
                null,
                "HAMBURGER ANGUS",
                CategoriaEnum.LANCHE,
                BigDecimal.valueOf(35.90),
                "Hamburger Angus 200mg de carne");

        var produtoCriado = produtoJpaRepository.save(produto);

        assertThat(produtoCriado)
                .isInstanceOf(Produto.class)
                .isNotNull();
        assertThat(produtoCriado.getId()).isNotNull();
        assertThat(produtoCriado.getId()).isEqualTo(produto.getId());
        assertThat(produtoCriado.getNome()).isEqualTo(produto.getNome());
        assertThat(produtoCriado.getCategoria()).isEqualTo(produto.getCategoria());
        assertThat(produtoCriado.getPreco()).isEqualTo(produto.getPreco());
        assertThat(produtoCriado.getDescricao()).isEqualTo(produto.getDescricao());

    }

    @Test
    void criarProdutoBebida() {
        var produto = new Produto(
                null,
                "Coca Cola 600ml",
                CategoriaEnum.BEBIDA,
                BigDecimal.valueOf(8.00),
                "Coca Cola 600ml");

        var produtoCriado = produtoJpaRepository.save(produto);

        assertThat(produtoCriado)
                .isInstanceOf(Produto.class)
                .isNotNull();
        assertThat(produtoCriado.getId()).isNotNull();
        assertThat(produtoCriado.getId()).isEqualTo(produto.getId());
        assertThat(produtoCriado.getNome()).isEqualTo(produto.getNome());
        assertThat(produtoCriado.getCategoria()).isEqualTo(produto.getCategoria());
        assertThat(produtoCriado.getPreco()).isEqualTo(produto.getPreco());
        assertThat(produtoCriado.getDescricao()).isEqualTo(produto.getDescricao());
    }

}