package br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ProdutoJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.ItemPedido;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Produto;
import br.com.fiap.techchallenge.lanchonete.core.domain.exceptions.EntityNotFoundException;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ItemPedidoDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static br.com.fiap.techchallenge.lanchonete.utils.adapters.web.PedidoHelper.*;
import static br.com.fiap.techchallenge.lanchonete.utils.adapters.web.ProdutoHelper.getProduto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ItemPedidoMapperTest {

    private ItemPedidoMapper itemPedidoMapper;

    @Mock
    private ProdutoJpaRepository produtoJpaRepository;

    AutoCloseable mock;


    @BeforeEach
    void setup() {
        mock = MockitoAnnotations.openMocks(this);
        itemPedidoMapper = new ItemPedidoMapper(produtoJpaRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void dadoPedido_ListaItemPedidoDTO_DeveFazerMapper_ListaItemPedido() {
        var pedido = getPedido();
        var itemPedidoDTOList = List.of(getItemPedidoDTO());
        var produto = getProduto();

        when(produtoJpaRepository.findById(any(Long.class))).thenReturn(Optional.of(produto));

        List<ItemPedido> itemPedidoResposta = itemPedidoMapper.toItemPedido(pedido, itemPedidoDTOList);

        assertThat(itemPedidoResposta).isNotNull().hasSize(1);
        assertThat(itemPedidoResposta.get(0).getPedido()).isEqualTo(pedido);
    }

    @Test
    void dadoPedido_ListaItemPedidoDTO_DeveFazerMapper_ListaItemPedido_LancaExececao_SeProdutoNaoEncontrado() {
        var pedido = getPedido();
        var itemPedidoDTOList = List.of(getItemPedidoDTO());
        var produto = getProduto();

        when(produtoJpaRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> itemPedidoMapper.toItemPedido(pedido, itemPedidoDTOList))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("Produto não encontrado");
    }

    @Test
    void dadoListaItemPedido_DeveFazerMapper_ListaItemPedidoDTO() {
        var pedido = getPedido();
        var itemPedidoList = List.of(getItemPedido(pedido));

        List<ItemPedidoDTO> itemPedidoDTOList = itemPedidoMapper.toItemPedidoResponse(itemPedidoList);

        assertThat(itemPedidoList).isNotNull();
        assertThat(itemPedidoList).allSatisfy(itemPedido -> {
            assertThat(itemPedido.getProduto()).isNotNull().isInstanceOf(Produto.class);
            assertThat(itemPedido.getProduto().getId()).isEqualTo(itemPedidoList.get(0).getProduto().getId());
            assertThat(itemPedido.getProduto().getDescricao()).isEqualTo(itemPedidoList.get(0).getProduto().getDescricao());
            assertThat(itemPedido.getValorUnitario()).isEqualTo(itemPedidoList.get(0).getValorUnitario());
            assertThat(itemPedido.getQuantidade()).isEqualTo(itemPedidoList.get(0).getQuantidade());
        });

    }
}