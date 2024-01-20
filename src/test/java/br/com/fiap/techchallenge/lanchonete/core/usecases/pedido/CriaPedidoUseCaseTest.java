package br.com.fiap.techchallenge.lanchonete.core.usecases.pedido;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.Pedido;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.CriaPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.BuscaClienteOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.CriaPedidoOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.produto.BuscaProdutoPorIdOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.fiap.techchallenge.lanchonete.utils.adapters.web.PedidoHelper.getCriaPedidoDTO;
import static br.com.fiap.techchallenge.lanchonete.utils.adapters.web.PedidoHelper.getCriaPedidoDTOSemCliente;
import static br.com.fiap.techchallenge.lanchonete.utils.adapters.web.PedidoHelper.getPedidoDTO;
import static br.com.fiap.techchallenge.lanchonete.utils.adapters.web.ProdutoHelper.getProdutoDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class CriaPedidoUseCaseTest {

    private CriaPedidoInputPort criaPedidoInputPort;

    @Mock
    CriaPedidoOutputPort criaPedidoOutputPort;

    @Mock
    BuscaProdutoPorIdOutputPort buscaProdutoPorIdOutputPort;

    @Mock
    BuscaClienteOutputPort buscaClienteOutputPort;

    AutoCloseable mock;

    Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido(StatusPedidoEnum.PENDENTE_DE_PAGAMENTO);
        mock = MockitoAnnotations.openMocks(this);
        criaPedidoInputPort = new CriaPedidoUseCase(criaPedidoOutputPort, buscaProdutoPorIdOutputPort, buscaClienteOutputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class criaPedidoUseCase {

        @Test
        void criarPedidoComCliente() {
            var pedidoDTO = getPedidoDTO();
            var novoPedido = getCriaPedidoDTO();
            var produtoDTO = getProdutoDTO();
            var clienteNovoPedido = new ClienteDTO(
                    1L,
                    "NOME DO CLIENTE",
                    "11122233399",
                    "cliente1@email.com"
            );
            when(criaPedidoOutputPort.criar(any(PedidoDTO.class))).thenReturn(pedidoDTO);
            when(buscaClienteOutputPort.buscar(novoPedido.clientId())).thenReturn(clienteNovoPedido);
            when(buscaProdutoPorIdOutputPort.buscarPorId(pedidoDTO.itens().get(0).produtoId())).thenReturn(produtoDTO);

            var pedidoCriado = criaPedidoInputPort.criar(novoPedido);

            assertThat(pedidoCriado).isNotNull();
            assertThat(pedidoCriado.id()).isEqualTo(pedidoDTO.id());
            assertThat(pedidoCriado.getNomeCliente()).isEqualTo(pedidoDTO.getNomeCliente());
            assertThat(pedidoCriado.itens()).allSatisfy(item -> {
               assertThat(item.produtoNome()).isEqualTo(pedidoDTO.itens().get(0).produtoNome());
               assertThat(item.produtoDescricao()).isEqualTo(pedidoDTO.itens().get(0).produtoDescricao());
               assertThat(item.valorUnitario()).isEqualTo(pedidoDTO.itens().get(0).valorUnitario());
               assertThat(item.quantidade()).isEqualTo(pedidoDTO.itens().get(0).quantidade());
               assertThat(item.getValorTotal()).isEqualTo(pedidoDTO.itens().get(0).getValorTotal());
            });
            assertThat(pedidoCriado.status()).isEqualTo(pedidoDTO.status());
            assertThat(pedidoCriado.valorTotal()).isEqualTo(pedidoDTO.valorTotal());
            assertThat(pedidoCriado.dataCriacao()).isEqualTo(pedidoDTO.dataCriacao());

            verify(criaPedidoOutputPort, times(1)).criar(any(PedidoDTO.class));
            verify(buscaClienteOutputPort, times(1)).buscar(anyLong());
            verify(buscaProdutoPorIdOutputPort, times(1)).buscarPorId(anyLong());
            verifyNoMoreInteractions(criaPedidoOutputPort);
            verifyNoMoreInteractions(buscaClienteOutputPort);
            verifyNoMoreInteractions(buscaProdutoPorIdOutputPort);
        }

        @Test
        void criarPedidoSemCliente() {
            var pedidoDTO = getPedidoDTO();
            var novoPedido = getCriaPedidoDTOSemCliente();

            var produtoDTO = getProdutoDTO();
            when(criaPedidoOutputPort.criar(any(PedidoDTO.class))).thenReturn(pedidoDTO);
            when(buscaProdutoPorIdOutputPort.buscarPorId(pedidoDTO.itens().get(0).produtoId())).thenReturn(produtoDTO);

            var pedidoCriado = criaPedidoInputPort.criar(novoPedido);

            assertThat(pedidoCriado).isNotNull();
            assertThat(pedidoCriado.id()).isEqualTo(pedidoDTO.id());
            assertThat(pedidoCriado.getNomeCliente()).isEqualTo(pedidoDTO.getNomeCliente());
            assertThat(pedidoCriado.itens()).allSatisfy(item -> {
                assertThat(item.produtoNome()).isEqualTo(pedidoDTO.itens().get(0).produtoNome());
                assertThat(item.produtoDescricao()).isEqualTo(pedidoDTO.itens().get(0).produtoDescricao());
                assertThat(item.valorUnitario()).isEqualTo(pedidoDTO.itens().get(0).valorUnitario());
                assertThat(item.quantidade()).isEqualTo(pedidoDTO.itens().get(0).quantidade());
                assertThat(item.getValorTotal()).isEqualTo(pedidoDTO.itens().get(0).getValorTotal());
            });
            assertThat(pedidoCriado.status()).isEqualTo(pedidoDTO.status());
            assertThat(pedidoCriado.valorTotal()).isEqualTo(pedidoDTO.valorTotal());
            assertThat(pedidoCriado.dataCriacao()).isEqualTo(pedidoDTO.dataCriacao());

            verify(criaPedidoOutputPort, times(1)).criar(any(PedidoDTO.class));
            verify(buscaProdutoPorIdOutputPort, times(1)).buscarPorId(anyLong());
            verifyNoMoreInteractions(criaPedidoOutputPort);
            verifyNoMoreInteractions(buscaProdutoPorIdOutputPort);
        }

    }
}