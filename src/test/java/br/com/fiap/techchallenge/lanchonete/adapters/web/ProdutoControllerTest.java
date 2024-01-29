package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.mappers.ProdutoMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.ProdutoRequest;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.CategoriaEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaImagemProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.produto.*;
import org.instancio.Instancio;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.Collections;

import static br.com.fiap.techchallenge.lanchonete.utils.JsonToStringHelper.asJsonString;
import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getAtualizaImagemProdutoDTO;
import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getProdutoDTO;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProdutoControllerTest {

    private MockMvc mockMvc;

    @Mock
    CriaProdutoInputPort criaProdutoInputPort;

    @Mock
    AtualizaImagemProdutoInputPort atualizaImagemProdutoInputPort;

    @Mock
    EditaProdutoInputPort editaProdutoInputPort;

    @Mock
    RemoveProdutoInputPort removeProdutoInputPort;

    @Mock
    BuscaProdutoPorIdInputPort buscaProdutoPorIdInputPort;

    @Mock
    BuscaTodosProdutosInputPort buscaTodosProdutosInputPort;

    @Mock
    BuscaProdutoPorCategoriaInputPort buscaProdutoPorCategoriaInputPort;

    ProdutoMapper produtoMapper;

    AutoCloseable mock;

    ProdutoRequest produtoRequest;

    @BeforeEach
    void setup() {
        produtoRequest = new ProdutoRequest("Produto Teste", CategoriaEnum.LANCHE, BigDecimal.valueOf(10.00), "Descrição do Produto Teste");

        this.produtoMapper = new ProdutoMapper();
        mock = MockitoAnnotations.openMocks(this);
        ProdutoController produtoController = new ProdutoController(
                criaProdutoInputPort,
                atualizaImagemProdutoInputPort,
                editaProdutoInputPort,
                removeProdutoInputPort,
                buscaProdutoPorIdInputPort,
                buscaTodosProdutosInputPort,
                buscaProdutoPorCategoriaInputPort,
                produtoMapper
        );

        mockMvc = MockMvcBuilders.standaloneSetup(produtoController).build();
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class testaProdutoController {

        @Test
        void criaUmNovoProduto() throws Exception {
            var produtoDTO = getProdutoDTO();

            when(criaProdutoInputPort.criar(any(ProdutoDTO.class))).thenReturn(produtoDTO);

            ResultActions result = mockMvc.perform(post("/produtos")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(produtoRequest))
            );

            result.andExpect(status().isCreated());

            verify(criaProdutoInputPort, times(1)).criar(any(ProdutoDTO.class));
            verifyNoMoreInteractions(criaProdutoInputPort);
        }

        @Test
        void upload() throws Exception {
            var id = 1L;
            var imagem = getAtualizaImagemProdutoDTO();
            var produdoDTO = getProdutoDTO();

            MockMultipartFile image = new MockMultipartFile(
                    "image",
                    "image.jpeg",
                    MediaType.IMAGE_JPEG_VALUE,
                    Instancio.create(String.class).getBytes()
            );

            when(atualizaImagemProdutoInputPort.atualizar(imagem, id)).thenReturn(produdoDTO);

            mockMvc.perform(multipart(HttpMethod.PATCH, "/produtos/{id}", id)
                    .file(image)
                    .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
            );

        }

        @Test
        void deveAtualizarImagemProduto() throws Exception {
            MultipartFile imagem = Instancio.create(MockMultipartFile.class);

            doAnswer(invocation -> {
                byte[] imageBytes = invocation.getArgument(0);
                Long id = invocation.getArgument(1);
                return null;
            }).when(atualizaImagemProdutoInputPort).atualizar(any(AtualizaImagemProdutoDTO.class), any(Long.class));

            mockMvc.perform(patch("/produtos/{id}", 1L)
                            .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                            .content(imagem.getBytes()));

        }

        @Test
        void editaUmProdutoPorId() throws Exception {
            var id = 1L;
            var produtoDTO = getProdutoDTO();

            when(editaProdutoInputPort.editar(any(ProdutoDTO.class), any(Long.class))).thenReturn(produtoDTO);

            ResultActions result = mockMvc.perform(put("/produtos/{id}", id)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(produtoRequest))
            );

            result.andExpect(status().isOk());

            verify(editaProdutoInputPort, times(1)).editar(any(ProdutoDTO.class), any(Long.class));
            verifyNoMoreInteractions(editaProdutoInputPort);
        }

        @Test
        void removeUmProdutoPorId() throws Exception {
            var id = 1L;
            var produtoDTO = getProdutoDTO();

            when(removeProdutoInputPort.remover(any(Long.class))).thenReturn(produtoDTO);

            ResultActions result = mockMvc.perform(delete("/produtos/{id}", id)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(produtoRequest))
            );

            result.andExpect(status().isOk());

            verify(removeProdutoInputPort, times(1)).remover(any(Long.class));
            verifyNoMoreInteractions(removeProdutoInputPort);
        }

        @Test
        void buscaUmProdutoPorId() throws Exception {
            var id = 1L;
            var produtoDTO = getProdutoDTO();

            when(buscaProdutoPorIdInputPort.buscarPorId(any(Long.class))).thenReturn(produtoDTO);

            ResultActions result = mockMvc.perform(get("/produtos/{id}", id)
                    .contentType(MediaType.APPLICATION_JSON)
            );

            result.andExpect(status().isOk());

            verify(buscaProdutoPorIdInputPort, times(1)).buscarPorId(any(Long.class));
            verifyNoMoreInteractions(buscaProdutoPorIdInputPort);
        }

        @Test
        void buscaTodosProdutos() throws Exception {
            var id = 1L;
            var produtoDTO = getProdutoDTO();

            when(buscaTodosProdutosInputPort.buscartodos()).thenReturn(Collections.singletonList(produtoDTO));

            ResultActions result = mockMvc.perform(get("/produtos")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(Collections.singletonList(produtoRequest)))
            );

            result.andExpect(status().isOk());

            verify(buscaTodosProdutosInputPort, times(1)).buscartodos();
            verifyNoMoreInteractions(buscaTodosProdutosInputPort);
        }

        @Test
        void buscaTodosProdutosPorCategoria() throws Exception {
            var categoria = CategoriaEnum.LANCHE;
            var produtoDTO = getProdutoDTO();

            when(buscaProdutoPorCategoriaInputPort.buscarPorCategoria(any(CategoriaEnum.class))).thenReturn(Collections.singletonList(produtoDTO));

            ResultActions result = mockMvc.perform(get("/produtos/categoria/{categoria}", categoria)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(Collections.singletonList(produtoRequest)))
            );

            result.andExpect(status().isOk());

            verify(buscaProdutoPorCategoriaInputPort, times(1)).buscarPorCategoria(any(CategoriaEnum.class));
            verifyNoMoreInteractions(buscaProdutoPorCategoriaInputPort);
        }
    }

}