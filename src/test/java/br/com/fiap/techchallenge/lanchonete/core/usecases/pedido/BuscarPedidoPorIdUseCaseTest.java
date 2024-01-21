package br.com.fiap.techchallenge.lanchonete.core.usecases.pedido;

import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.BuscarPedidoPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.BuscarPedidoPorIdOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.fiap.techchallenge.lanchonete.utils.PedidoHelper.getPedidoDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class BuscarPedidoPorIdUseCaseTest {

    private BuscarPedidoPorIdInputPort buscarPedidoPorIdInputPort;

    @Mock
    BuscarPedidoPorIdOutputPort buscarPedidoPorIdOutputPort;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        buscarPedidoPorIdInputPort = new BuscarPedidoPorIdUseCase(buscarPedidoPorIdOutputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class buscaPedidoPorIdUseCase {

        @Test
        void buscaPedidoPorId() {
            var id = 1L;
            var pedidoDTO = getPedidoDTO();
            when(buscarPedidoPorIdOutputPort.buscarPorId(id)).thenReturn(pedidoDTO);

            var pedidoBuscado = buscarPedidoPorIdInputPort.buscarPorId(id);

            assertThat(pedidoBuscado).isNotNull().isInstanceOf(PedidoDTO.class);
            assertThat(pedidoBuscado.id()).isEqualTo(pedidoDTO.id());
            assertThat(pedidoBuscado.itens()).allSatisfy(item -> {
               assertThat(item.produtoNome()).isEqualTo(pedidoDTO.itens().get(0).produtoNome());
               assertThat(item.produtoDescricao()).isEqualTo(pedidoDTO.itens().get(0).produtoDescricao());
               assertThat(item.valorUnitario()).isEqualTo(pedidoDTO.itens().get(0).valorUnitario());
               assertThat(item.quantidade()).isEqualTo(pedidoDTO.itens().get(0).quantidade());
               assertThat(item.getValorTotal()).isEqualTo(pedidoDTO.itens().get(0).getValorTotal());
            });
            assertThat(pedidoBuscado.status()).isEqualTo(pedidoDTO.status());
            assertThat(pedidoBuscado.valorTotal()).isEqualTo(pedidoDTO.valorTotal());
            assertThat(pedidoBuscado.dataCriacao()).isEqualTo(pedidoDTO.dataCriacao());

            verify(buscarPedidoPorIdOutputPort, times(1)).buscarPorId(anyLong());
            verifyNoMoreInteractions(buscarPedidoPorIdOutputPort);
        }
    }

}