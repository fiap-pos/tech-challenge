package br.com.fiap.techchallenge.lanchonete.adapters.web.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.web.models.responses.ItemPedidoResponse;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.responses.PedidoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static br.com.fiap.techchallenge.lanchonete.utils.PedidoHelper.getListaPedidoDTO;
import static br.com.fiap.techchallenge.lanchonete.utils.PedidoHelper.getPedidoDTO;
import static org.assertj.core.api.Assertions.assertThat;

class PedidoMapperTest {

    private PedidoMapper pedidoMapper;

    @BeforeEach
    void setup() {
        this.pedidoMapper = new PedidoMapper();
    }

    @Test
    void dadoPedidoDTO_DeveFazerMapper_RetornarPedidoResponse() {
        // Arrange
        var pedidoDTO = getPedidoDTO();

        // Act
        var pedidoResponse = pedidoMapper.toPedidoResponse(pedidoDTO);

        // Assert
        assertThat(pedidoResponse).isNotNull();
        assertThat(pedidoResponse.getId()).isEqualTo(pedidoDTO.id());
        assertThat(pedidoResponse.getClienteNome()).isEqualTo(pedidoDTO.cliente().nome());
        assertThat(pedidoResponse.getItens()).allSatisfy(item -> {
           assertThat(item).isNotNull().isInstanceOf(ItemPedidoResponse.class);
        });
        assertThat(pedidoResponse.getItens().get(0).getProdutoNome()).isEqualTo(pedidoDTO.itens().get(0).produtoNome());
        assertThat(pedidoResponse.getItens().get(0).getProdutoDescricao()).isEqualTo(pedidoDTO.itens().get(0).produtoDescricao());
        assertThat(pedidoResponse.getItens().get(0).getValorUnitario()).isEqualTo(pedidoDTO.itens().get(0).valorUnitario());
        assertThat(pedidoResponse.getItens().get(0).getQuantidade()).isEqualTo(pedidoDTO.itens().get(0).quantidade());
        assertThat(pedidoResponse.getItens().get(0).getValorTotal()).isEqualTo(pedidoDTO.itens().get(0).getValorTotal());
    }

    @Test
    void dadoListaPedidoDTO_DeveFazerMapper_RetornarListaPedidoResponse() {
        // Arrange
        var listaPedidoDTO = getListaPedidoDTO();

        // Act
        var listaPedidoResponse = pedidoMapper.toPedidoListResponse(listaPedidoDTO);

        // Assert
        assertThat(listaPedidoResponse).isNotNull();
        assertThat(listaPedidoResponse).allSatisfy(pedidoResponse -> {
           assertThat(pedidoResponse).isNotNull().isInstanceOf(PedidoResponse.class);
           assertThat(pedidoResponse.getId()).isEqualTo(listaPedidoDTO.get(0).id());
           assertThat(pedidoResponse.getClienteNome()).isEqualTo(listaPedidoDTO.get(0).cliente().nome());
            assertThat(pedidoResponse.getItens()).allSatisfy(item -> {
                assertThat(item).isNotNull().isInstanceOf(ItemPedidoResponse.class);
            });
            assertThat(pedidoResponse.getItens().get(0).getProdutoNome()).isEqualTo(listaPedidoDTO.get(0).itens().get(0).produtoNome());
            assertThat(pedidoResponse.getItens().get(0).getProdutoDescricao()).isEqualTo(listaPedidoDTO.get(0).itens().get(0).produtoDescricao());
            assertThat(pedidoResponse.getItens().get(0).getValorUnitario()).isEqualTo(listaPedidoDTO.get(0).itens().get(0).valorUnitario());
            assertThat(pedidoResponse.getItens().get(0).getQuantidade()).isEqualTo(listaPedidoDTO.get(0).itens().get(0).quantidade());
            assertThat(pedidoResponse.getItens().get(0).getValorTotal()).isEqualTo(listaPedidoDTO.get(0).itens().get(0).getValorTotal());
        });
    }

}