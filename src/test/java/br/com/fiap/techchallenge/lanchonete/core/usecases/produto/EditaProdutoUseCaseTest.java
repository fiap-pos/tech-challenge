package br.com.fiap.techchallenge.lanchonete.core.usecases.produto;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.produto.EditaProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.produto.EditaProdutoOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getProdutoDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class EditaProdutoUseCaseTest {

    private EditaProdutoInputPort editaProdutoInputPort;

    @Mock
    EditaProdutoOutputPort editaProdutoOutputPort;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        editaProdutoInputPort = new EditaProdutoUseCase(editaProdutoOutputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class editaProdutoUseCase {
        @Test
        void editaProduto() {
            var produtoAntigo = getProdutoDTO();
            var produtoNovo = new ProdutoDTO(
                    produtoAntigo.id(),
                    "novo nome alterado",
                    produtoAntigo.categoria(),
                    BigDecimal.valueOf(99.99),
                    produtoAntigo.descricao(),
                    produtoAntigo.imagem()
            );

            when(editaProdutoOutputPort.editar(any(ProdutoDTO.class), anyLong())).thenReturn(produtoNovo);

            var produtoAlterado = editaProdutoInputPort.editar(produtoNovo, produtoAntigo.id());

            assertThat(produtoAlterado).isNotNull().isInstanceOf(ProdutoDTO.class);
            assertThat(produtoAlterado.id()).isEqualTo(produtoNovo.id());
            assertThat(produtoAlterado.nome()).isEqualTo(produtoNovo.nome());
            assertThat(produtoAlterado.descricao()).isEqualTo(produtoNovo.descricao());
            assertThat(produtoAlterado.categoria()).isEqualTo(produtoNovo.categoria());
            assertThat(produtoAlterado.preco()).isEqualTo(produtoNovo.preco());
        }
    }

}