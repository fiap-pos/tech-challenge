package br.com.fiap.techchallenge.lanchonete.core.usecases.produto;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.produto.BuscaProdutoPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.produto.BuscaProdutoPorIdOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getProdutoDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class BuscaProdutoPorIdUseCaseTest {

    private BuscaProdutoPorIdInputPort buscaProdutoPorIdInputPort;

    @Mock
    BuscaProdutoPorIdOutputPort buscaProdutoPorIdOutputPort;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        buscaProdutoPorIdInputPort = new BuscaProdutoPorIdUseCase(buscaProdutoPorIdOutputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class buscaProdutoPorIdUseCase {
        @Test
        void buscaProdutoPorId() {
            var produto = getProdutoDTO();
            when(buscaProdutoPorIdOutputPort.buscarPorId(anyLong())).thenReturn(produto);

            var produtoBuscado = buscaProdutoPorIdInputPort.buscarPorId(produto.id());

            assertThat(produtoBuscado).isNotNull().isInstanceOf(ProdutoDTO.class);
            assertThat(produtoBuscado.id()).isEqualTo(produto.id());
            assertThat(produtoBuscado.nome()).isEqualTo(produto.nome());
            assertThat(produtoBuscado.descricao()).isEqualTo(produto.descricao());
            assertThat(produtoBuscado.categoria()).isEqualTo(produto.categoria());
            assertThat(produtoBuscado.preco()).isEqualTo(produto.preco());
        }
    }
}