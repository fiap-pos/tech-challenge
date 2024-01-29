package br.com.fiap.techchallenge.lanchonete.adapters.web.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getProdutoDTO;
import static org.assertj.core.api.Assertions.assertThat;

class ProdutoMapperTest {

    private ProdutoMapper produtoMapper;

    @BeforeEach
    void setup() {
        this.produtoMapper = new ProdutoMapper();
    }

    @Test
    void dadoProdutoDTO_DeveFazerMapper_RetornarProdutoResponse() {
        // Arrange
        var produtoDTO = getProdutoDTO();

        // Act
        var produtoResponse = produtoMapper.toProdutoResponse(produtoDTO);

        // Assert
        assertThat(produtoResponse).isNotNull();
        assertThat(produtoResponse.getNome()).isEqualTo(produtoDTO.nome());
        assertThat(produtoResponse.getCategoria()).isEqualTo(produtoDTO.categoria());
        assertThat(produtoResponse.getPreco()).isEqualTo(produtoDTO.preco());
        assertThat(produtoResponse.getDescricao()).isEqualTo(produtoDTO.descricao());
    }

}