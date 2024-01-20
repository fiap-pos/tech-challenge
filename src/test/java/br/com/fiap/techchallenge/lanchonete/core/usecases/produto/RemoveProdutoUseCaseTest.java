package br.com.fiap.techchallenge.lanchonete.core.usecases.produto;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.produto.RemoveProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.produto.RemoveProdutoOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.fiap.techchallenge.lanchonete.utils.adapters.web.ProdutoHelper.getProdutoDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class RemoveProdutoUseCaseTest {

    private RemoveProdutoInputPort removeProdutoInputPort;

    @Mock
    RemoveProdutoOutputPort removeProdutoOutputPort;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        removeProdutoInputPort = new RemoveProdutoUseCase(removeProdutoOutputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class removeProdutoUseCase {
        @Test
        void removeProduto() {
            var produto = getProdutoDTO();
            when(removeProdutoOutputPort.remover(produto.id())).thenReturn(produto);

            var produtoRemovido = removeProdutoInputPort.remover(produto.id());

            assertThat(produtoRemovido).isNotNull().isInstanceOf(ProdutoDTO.class);
            assertThat(produtoRemovido.id()).isEqualTo(produto.id());
            assertThat(produtoRemovido.nome()).isEqualTo(produto.nome());
            assertThat(produtoRemovido.descricao()).isEqualTo(produto.descricao());
            assertThat(produtoRemovido.categoria()).isEqualTo(produto.categoria());
            assertThat(produtoRemovido.preco()).isEqualTo(produto.preco());
        }
    }

}