package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ProdutoJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers.ProdutoMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Produto;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.CategoriaEnum;
import br.com.fiap.techchallenge.lanchonete.core.domain.exceptions.EntityNotFoundException;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getAtualizaImagemProdutoDTO;
import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getProduto;
import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getProdutoDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProdutoRepositoryTest {

    private ProdutoRepository produtoRepository;

    @Mock
    ProdutoJpaRepository produtoJpaRepository;

    @Mock
    ProdutoMapper produtoMapper;

    AutoCloseable openMocks;

    @BeforeEach
    void setup() {
        openMocks = MockitoAnnotations.openMocks(this);
        produtoRepository = new ProdutoRepository(produtoJpaRepository, produtoMapper);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Nested
    class produto {

        @Test
        void criar() {
            var produtoDTO = getProdutoDTO();
            var produto = getProduto();
            when(produtoMapper.toProduto(produtoDTO)).thenReturn(produto);
            when(produtoJpaRepository.save(produto)).thenReturn(produto);
            when(produtoMapper.toProdutoDTO(produto)).thenReturn(produtoDTO);

            var produtoCriado = produtoRepository.criar(produtoDTO);

            assertThat(produtoCriado).isNotNull().isInstanceOf(ProdutoDTO.class);
            assertThat(produtoCriado.nome()).isEqualTo(produtoDTO.nome());
            assertThat(produtoCriado.categoria()).isEqualTo(produtoDTO.categoria());
            assertThat(produtoCriado.preco()).isEqualTo(produtoDTO.preco());
            assertThat(produtoCriado.descricao()).isEqualTo(produtoDTO.descricao());
            assertThat(produtoCriado.imagem()).isEqualTo(produtoDTO.imagem());

            verify(produtoMapper, times(1)).toProduto(any(ProdutoDTO.class));
            verify(produtoJpaRepository, times(1)).save(any(Produto.class));
            verify(produtoMapper, times(1)).toProdutoDTO(any(Produto.class));
        }

        @Test
        void atualizar() {
            var id = 1L;
            var produto = getProduto();
            var produtoDTO = getProdutoDTO();
            var imagemDTO = getAtualizaImagemProdutoDTO();

            when(produtoJpaRepository.findById(id)).thenReturn(Optional.of(produto));
            when(produtoJpaRepository.save(produto)).thenReturn(produto);
            when(produtoMapper.toProdutoDTO(produto)).thenReturn(produtoDTO);

            var produtoAtualizado = produtoRepository.atualizar(imagemDTO, id);

            assertThat(produtoAtualizado).isNotNull().isInstanceOf(ProdutoDTO.class);
            assertThat(produtoAtualizado.nome()).isEqualTo(produtoDTO.nome());
            assertThat(produtoAtualizado.categoria()).isEqualTo(produtoDTO.categoria());
            assertThat(produtoAtualizado.preco()).isEqualTo(produtoDTO.preco());
            assertThat(produtoAtualizado.descricao()).isEqualTo(produtoDTO.descricao());
            assertThat(produtoAtualizado.imagem()).isEqualTo(produtoDTO.imagem());

            verify(produtoJpaRepository, times(1)).findById(id);
            verify(produtoJpaRepository, times(1)).save(produto);
            verify(produtoMapper, times(1)).toProdutoDTO(produto);
        }

        @Test
        void editar() {
            var id = 1L;
            var produtoDTO = getProdutoDTO();
            var produto = getProduto();

            when(produtoJpaRepository.findById(id)).thenReturn(Optional.of(produto));
            when(produtoJpaRepository.save(produto)).thenReturn(produto);
            when(produtoMapper.toProdutoDTO(produto)).thenReturn(produtoDTO);

            var produtoEditado = produtoRepository.editar(produtoDTO, id);

            assertThat(produtoEditado).isNotNull().isInstanceOf(ProdutoDTO.class);
            assertThat(produtoEditado.nome()).isEqualTo(produtoDTO.nome());
            assertThat(produtoEditado.categoria()).isEqualTo(produtoDTO.categoria());
            assertThat(produtoEditado.preco()).isEqualTo(produtoDTO.preco());
            assertThat(produtoEditado.descricao()).isEqualTo(produtoDTO.descricao());
            assertThat(produtoEditado.imagem()).isEqualTo(produtoDTO.imagem());

            verify(produtoJpaRepository, times(1)).findById(id);
            verify(produtoJpaRepository, times(1)).save(produto);
            verify(produtoMapper, times(1)).toProdutoDTO(produto);

        }

        @Test
        void remover() {
            var id = 1L;
            var produtoDTO = getProdutoDTO();
            var produto = getProduto();

            when(produtoJpaRepository.findById(id)).thenReturn(Optional.of(produto));
            doNothing().when(produtoJpaRepository).delete(produto);
            when(produtoMapper.toProdutoDTO(produto)).thenReturn(produtoDTO);

            var produtoRemovido = produtoRepository.remover(id);

            assertThat(produtoRemovido).isNotNull().isInstanceOf(ProdutoDTO.class);
            assertThat(produtoRemovido.nome()).isEqualTo(produtoDTO.nome());
            assertThat(produtoRemovido.categoria()).isEqualTo(produtoDTO.categoria());
            assertThat(produtoRemovido.preco()).isEqualTo(produtoDTO.preco());
            assertThat(produtoRemovido.descricao()).isEqualTo(produtoDTO.descricao());
            assertThat(produtoRemovido.imagem()).isEqualTo(produtoDTO.imagem());

            verify(produtoJpaRepository, times(1)).findById(id);
            verify(produtoJpaRepository, times(1)).delete(produto);
            verify(produtoMapper, times(1)).toProdutoDTO(produto);
        }

        @Test
        void buscarPorId_ComSucesso() {
            var id = 1L;
            var produto = getProduto();
            var produtoDTO = getProdutoDTO();

            when(produtoJpaRepository.findById(id)).thenReturn(Optional.of(produto));
            when(produtoMapper.toProdutoDTO(produto)).thenReturn(produtoDTO);

            var produtoEncontrado = produtoRepository.buscarPorId(id);

            assertThat(produtoEncontrado).isNotNull().isInstanceOf(ProdutoDTO.class);
            assertThat(produtoEncontrado.nome()).isEqualTo(produtoDTO.nome());
            assertThat(produtoEncontrado.categoria()).isEqualTo(produtoDTO.categoria());
            assertThat(produtoEncontrado.preco()).isEqualTo(produtoDTO.preco());
            assertThat(produtoEncontrado.descricao()).isEqualTo(produtoDTO.descricao());
            assertThat(produtoEncontrado.imagem()).isEqualTo(produtoDTO.imagem());

            verify(produtoJpaRepository, times(1)).findById(id);
            verify(produtoMapper, times(1)).toProdutoDTO(produto);
        }

        @Test
        void buscarPorId_ProdutoNaoEncontrado_LancaExcecao() {
            var id = 1L;
            var produto = getProduto();
            var produtoDTO = getProdutoDTO();

            when(produtoJpaRepository.findById(id)).thenReturn(Optional.empty());
            when(produtoMapper.toProdutoDTO(produto)).thenReturn(produtoDTO);

            assertThatThrownBy(() -> produtoRepository.buscarPorId( id))
                    .isInstanceOf(EntityNotFoundException.class)
                    .hasMessage("Produto com o id " + id + " não existe");

            verify(produtoJpaRepository, times(1)).findById(anyLong());
            verify(produtoMapper, never()).toProdutoDTO(any(Produto.class));
        }

        @Test
        void buscarTodos() {
            var produto = getProduto();
            var listaProdutos = List.of(produto);
            var produtoDTO = getProdutoDTO();

            when(produtoJpaRepository.findAll()).thenReturn(listaProdutos);
            when(produtoMapper.toProdutoDTO(produto)).thenReturn(produtoDTO);

            var listaProdutosEncontrados = produtoRepository.buscarTodos();

            assertThat(listaProdutosEncontrados).isNotNull();

            verify(produtoJpaRepository, times(1)).findAll();
            verify(produtoMapper, times(1)).toProdutoDTO(any(Produto.class));
        }

        @Test
        void buscarPorCategoria() {
            var produto = getProduto();
            var listaProdutos = List.of(produto);
            var produtoDTO = getProdutoDTO();
            var categoria = CategoriaEnum.LANCHE;

            when(produtoJpaRepository.findByCategoria(categoria)).thenReturn(listaProdutos);
            when(produtoMapper.toProdutoDTO(produto)).thenReturn(produtoDTO);

            var listaProdutosEncontrados = produtoRepository.buscarPorCategoria(categoria);

            assertThat(listaProdutosEncontrados).isNotNull();

            verify(produtoJpaRepository, times(1)).findByCategoria(categoria);
            verify(produtoMapper, times(1)).toProdutoDTO(any(Produto.class));
        }

    }

}