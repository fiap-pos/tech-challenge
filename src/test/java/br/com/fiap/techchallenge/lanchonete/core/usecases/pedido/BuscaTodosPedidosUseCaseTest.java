package br.com.fiap.techchallenge.lanchonete.core.usecases.pedido;

import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.BuscaTodosPedidosInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.BuscaTodosPedidosOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.fiap.techchallenge.lanchonete.utils.PedidoHelper.getListaPedidoDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class BuscaTodosPedidosUseCaseTest {

    private BuscaTodosPedidosInputPort buscaTodosPedidosInputPort;

    @Mock
    BuscaTodosPedidosOutputPort buscaTodosPedidosOutputPort;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        buscaTodosPedidosInputPort = new BuscaTodosPedidosUseCase(buscaTodosPedidosOutputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class buscaTodosPedidosUseCase {

        @Test
        void buscaTodosPedidos() {
            var id = 1L;
            var pedidosDTO = getListaPedidoDTO();
            when(buscaTodosPedidosOutputPort.buscarTodos()).thenReturn(pedidosDTO);

            var pedidosBuscados = buscaTodosPedidosInputPort.buscarTodos();

            assertThat(pedidosBuscados).isNotNull();
            assertThat(pedidosBuscados).allSatisfy( pedidoBuscado -> {
                assertThat(pedidoBuscado.id()).isEqualTo(pedidosDTO.get(0).id());
                assertThat(pedidoBuscado.itens()).allSatisfy( item -> {
                    assertThat(item.produtoNome()).isEqualTo(pedidosDTO.get(0).itens().get(0).produtoNome());
                    assertThat(item.produtoDescricao()).isEqualTo(pedidosDTO.get(0).itens().get(0).produtoDescricao());
                    assertThat(item.valorUnitario()).isEqualTo(pedidosDTO.get(0).itens().get(0).valorUnitario());
                    assertThat(item.quantidade()).isEqualTo(pedidosDTO.get(0).itens().get(0).quantidade());
                    assertThat(item.getValorTotal()).isEqualTo(pedidosDTO.get(0).itens().get(0).getValorTotal());
                });
                assertThat(pedidoBuscado.status()).isEqualTo(pedidosDTO.get(0).status());
                assertThat(pedidoBuscado.valorTotal()).isEqualTo(pedidosDTO.get(0).valorTotal());
                assertThat(pedidoBuscado.dataCriacao()).isEqualTo(pedidosDTO.get(0).dataCriacao());
            });

            verify(buscaTodosPedidosOutputPort, times(1)).buscarTodos();
            verifyNoMoreInteractions(buscaTodosPedidosOutputPort);
        }
    }

}