package br.com.fiap.techchallenge.lanchonete.core.usecases.produto;

import br.com.fiap.techchallenge.lanchonete.core.ports.in.produto.BuscaTodosProdutosInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.produto.BuscaTodosProdutosOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getProdutoDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class BuscaTodosProdutosUseCaseTest {

    private BuscaTodosProdutosInputPort buscaTodosProdutosInputPort;

    @Mock
    BuscaTodosProdutosOutputPort buscaProdutoPorIdOutputPort;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        buscaTodosProdutosInputPort = new BuscaTodosProdutosUseCase(buscaProdutoPorIdOutputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class buscaTodosProdutoUseCase {
        @Test
        void buscaTodosProduto() {
            var listaProdutos = List.of(getProdutoDTO());
            when(buscaProdutoPorIdOutputPort.buscarTodos()).thenReturn(listaProdutos);

            var listaProdutosBuscados = buscaTodosProdutosInputPort.buscartodos();

            assertThat(listaProdutosBuscados).isNotNull();
            assertThat(listaProdutosBuscados).allSatisfy(produto -> {
                assertThat(produto.nome()).isEqualTo(listaProdutos.get(0).nome());
            });
        }
    }
}