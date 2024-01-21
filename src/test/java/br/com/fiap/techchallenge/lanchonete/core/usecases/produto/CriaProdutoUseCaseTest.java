package br.com.fiap.techchallenge.lanchonete.core.usecases.produto;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.produto.CriaProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.produto.CriaProdutoOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getProdutoDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class CriaProdutoUseCaseTest {

    private CriaProdutoInputPort criaProdutoInputPort;

    @Mock
    CriaProdutoOutputPort criaProdutoOutputPort;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        criaProdutoInputPort = new CriaProdutoUseCase(criaProdutoOutputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class criaProdutoUseCase {
        @Test
        void criar() {
            var produtoDTO = getProdutoDTO();
            when(criaProdutoOutputPort.criar(produtoDTO)).thenReturn(produtoDTO);

            var produtoCriado = criaProdutoInputPort.criar(produtoDTO);

            assertThat(produtoCriado).isNotNull();
            assertThat(produtoCriado.nome()).isEqualTo(produtoDTO.nome());
            assertThat(produtoCriado.categoria()).isEqualTo(produtoDTO.categoria());
            assertThat(produtoCriado.preco()).isEqualTo(produtoDTO.preco());
            assertThat(produtoCriado.descricao()).isEqualTo(produtoDTO.descricao());
            verify(criaProdutoOutputPort, times(1)).criar(any(ProdutoDTO.class));
            verifyNoMoreInteractions(criaProdutoOutputPort);
        }
    }
}