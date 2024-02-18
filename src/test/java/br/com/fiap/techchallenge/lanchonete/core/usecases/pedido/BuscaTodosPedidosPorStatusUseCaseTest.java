package br.com.fiap.techchallenge.lanchonete.core.usecases.pedido;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.BuscaTodosPedidosPorStatusInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.BuscaTodosPedidosPorStatusOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.fiap.techchallenge.lanchonete.utils.PedidoHelper.getListaPedidoDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class BuscaTodosPedidosPorStatusUseCaseTest {

    private BuscaTodosPedidosPorStatusInputPort buscaTodosPedidosPorStatusInputPort;

    @Mock
    BuscaTodosPedidosPorStatusOutputPort buscaTodosPedidosPorStatusOutputPort;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        buscaTodosPedidosPorStatusInputPort = new BuscaTodosPedidosPorStatusUseCase(buscaTodosPedidosPorStatusOutputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class buscaTodosPedidosPorStatusUseCase {

        @Test
        void buscaTodosPedidosPorStatus() {
            var status = StatusPedidoEnum.PENDENTE_DE_PAGAMENTO;
            var pedidosDTO = getListaPedidoDTO();
            when(buscaTodosPedidosPorStatusOutputPort.buscarPedidosPorStatus(any(StatusPedidoEnum.class))).thenReturn(pedidosDTO);

            var listaPedidosBuscados = buscaTodosPedidosPorStatusInputPort.buscarTodosStatus(status);

            assertThat(listaPedidosBuscados)
                    .isNotNull()
                    .isNotEmpty()
                    .allSatisfy( pedidoBuscado -> {
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

            verify(buscaTodosPedidosPorStatusOutputPort, times(1)).buscarPedidosPorStatus(any(StatusPedidoEnum.class));
            verifyNoMoreInteractions(buscaTodosPedidosPorStatusOutputPort);
        }
    }

}