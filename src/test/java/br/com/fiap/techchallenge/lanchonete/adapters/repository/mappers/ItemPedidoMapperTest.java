package br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ProdutoJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.ItemPedido;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static br.com.fiap.techchallenge.lanchonete.utils.adapters.web.PedidoHelper.getItemPedidoDTO;
import static br.com.fiap.techchallenge.lanchonete.utils.adapters.web.PedidoHelper.getPedido;
import static br.com.fiap.techchallenge.lanchonete.utils.adapters.web.ProdutoHelper.getProduto;
import static org.assertj.core.api.Assertions.assertThat;
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
    void toItemPedidoResponse() {
    }
}