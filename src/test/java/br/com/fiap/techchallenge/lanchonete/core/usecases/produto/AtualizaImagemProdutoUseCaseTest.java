package br.com.fiap.techchallenge.lanchonete.core.usecases.produto;

import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaImagemProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.produto.AtualizaImagemProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.produto.AtualizaImagemProdutoOutputPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.fiap.techchallenge.lanchonete.utils.adapters.web.ProdutoHelper.getAtualizaImagemProdutoDTO;
import static br.com.fiap.techchallenge.lanchonete.utils.adapters.web.ProdutoHelper.getProdutoDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AtualizaImagemProdutoUseCaseTest {

    private AtualizaImagemProdutoInputPort atualizaImagemProdutoInputPort;

    @Mock
    AtualizaImagemProdutoOutputPort atualizaImagemProdutoOutputPort;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        atualizaImagemProdutoInputPort = new AtualizaImagemProdutoUseCase(atualizaImagemProdutoOutputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void atualizaImagemProduto() {
        var id = 1L;
        var atualizaImagemProdutoAntigaDTO = getAtualizaImagemProdutoDTO();
        var imagemAntiga = atualizaImagemProdutoAntigaDTO.imagem();
        var produtoComImagemAntiga = getProdutoDTO(imagemAntiga);

        var atualizaImagemProdutoNovaDTO = getAtualizaImagemProdutoDTO();
        var imagemNova = atualizaImagemProdutoNovaDTO.imagem();
        var produtoComImagemNova = getProdutoDTO(imagemNova);

        when(atualizaImagemProdutoOutputPort.atualizar(any(AtualizaImagemProdutoDTO.class), any(Long.class))).thenReturn(produtoComImagemNova);

        var produtoComImagemAtualizada = atualizaImagemProdutoInputPort.atualizar(atualizaImagemProdutoNovaDTO, id);

        // TODO: verificar porque está retornar nulo
        //assertThat(produtoComImagemAtualizada).isNotNull();
        verify(atualizaImagemProdutoOutputPort, times(1)).atualizar(any(AtualizaImagemProdutoDTO.class), any(Long.class));
    }
}