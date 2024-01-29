package br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Produto;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getProduto;
import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getProdutoDTO;
import static org.assertj.core.api.Assertions.assertThat;

class ProdutoMapperTest {

    private ProdutoMapper produtoMapper;

    @BeforeEach
    void setUp() {
        this.produtoMapper = new ProdutoMapper();
    }

    @Test
    void dadoProdutoDTO_DeveFazerMapper_RetornarProduto() {
        var produtoDTO = getProdutoDTO();

        var produto = produtoMapper.toProduto(produtoDTO);

        assertThat(produto).isNotNull().isInstanceOf(Produto.class);
        assertThat(produto.getId()).isEqualTo(produtoDTO.id());
        assertThat(produto.getNome()).isEqualTo(produtoDTO.nome());
        assertThat(produto.getCategoria()).isEqualTo(produtoDTO.categoria());
        assertThat(produto.getPreco()).isEqualTo(produtoDTO.preco());
        assertThat(produto.getDescricao()).isEqualTo(produtoDTO.descricao());
    }

    @Test
    void dadoProduto_DeveFazerMapper_RetornarProdutoDTO() {
        var produto = getProduto();

        var produtoDTO = produtoMapper.toProdutoDTO(produto);

        assertThat(produtoDTO).isNotNull().isInstanceOf(ProdutoDTO.class);
        assertThat(produtoDTO.id()).isEqualTo(produto.getId());
        assertThat(produtoDTO.nome()).isEqualTo(produto.getNome());
        assertThat(produtoDTO.categoria()).isEqualTo(produto.getCategoria());
        assertThat(produtoDTO.preco()).isEqualTo(produto.getPreco());
        assertThat(produtoDTO.descricao()).isEqualTo(produto.getDescricao());
    }
}