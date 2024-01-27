package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ProdutoJpaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getProduto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProdutoRepositoryTest {

    @Mock
    ProdutoJpaRepository produtoJpaRepository;

    AutoCloseable openMocks;

    @BeforeEach
    void setup() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void deveCriarProduto() {
        var produto = getProduto();
        when(produtoJpaRepository.save(produto)).thenReturn(produto);

        var produtoSalvo = produtoJpaRepository.save(produto);

        assertThat(produtoSalvo).isNotNull().isEqualTo(produto);

        verify(produtoJpaRepository, times(1)).save(produto);
    }

}