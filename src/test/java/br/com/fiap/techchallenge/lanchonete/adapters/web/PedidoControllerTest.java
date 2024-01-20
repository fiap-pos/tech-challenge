package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.mappers.CobrancaMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.web.mappers.PedidoMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.AtualizaStatusPedidoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.ItemPedidoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.PedidoRequest;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaStatusPedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CriaPedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cobranca.BuscaCobrancaPorPedidoIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static br.com.fiap.techchallenge.lanchonete.utils.JsonToStringHelper.asJsonString;
import static br.com.fiap.techchallenge.lanchonete.utils.adapters.web.CobrancaHelper.getCobrancaDTO;
import static br.com.fiap.techchallenge.lanchonete.utils.adapters.web.PedidoHelper.getPedidoDTO;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PedidoControllerTest {

    private MockMvc mockMvc;

    @Mock
    CriaPedidoInputPort criaPedidoInputPort;

    @Mock
    AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort;

    @Mock
    BuscaTodosPedidosInputPort buscaTodosPedidosInputPort;

    @Mock
    BuscaPedidosOrdenadosPorPrioridadeInputPort buscaPedidosOrdenadosPorPrioridadeInputPort;

    @Mock
    BuscarPedidoPorIdInputPort buscarPedidoPorIdInputPort;

    @Mock
    BuscaTodosPedidosPorStatusInputPort buscaTodosPedidosPorStatusInputPort;

    @Mock
    BuscaCobrancaPorPedidoIdInputPort buscaCobrancaPorPedidoIdInputPort;

    PedidoMapper pedidoMapper;

    CobrancaMapper cobrancaMapper;

    AutoCloseable mock;

    PedidoRequest pedidoRequest = new PedidoRequest();

    ItemPedidoRequest itemPedidoRequest = new ItemPedidoRequest();

    AtualizaStatusPedidoRequest atualizaStatusPedidoRequest = new AtualizaStatusPedidoRequest();

    @BeforeEach
    void setUp() {
        itemPedidoRequest.setProdutoId(1L);
        itemPedidoRequest.setQuantidade(10);

        pedidoRequest.setClienteId(1L);
        pedidoRequest.setItens(Collections.singletonList(itemPedidoRequest));

        atualizaStatusPedidoRequest.setStatus(StatusPedidoEnum.FINALIZADO);

        this.pedidoMapper = new PedidoMapper();
        this.cobrancaMapper = new CobrancaMapper();
        mock = MockitoAnnotations.openMocks(this);
        PedidoController pedidoController = new PedidoController(
                criaPedidoInputPort,
                atualizaStatusPedidoInputPort,
                buscaTodosPedidosInputPort,
                buscaPedidosOrdenadosPorPrioridadeInputPort,
                buscarPedidoPorIdInputPort,
                buscaTodosPedidosPorStatusInputPort,
                buscaCobrancaPorPedidoIdInputPort,
                pedidoMapper,
                cobrancaMapper
        );

        mockMvc = MockMvcBuilders.standaloneSetup(pedidoController).build();
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class testaPedidoController {

        @Test
        void buscarTodosOsPedidos() throws Exception {
            var pedidoDTO = getPedidoDTO();

            when(buscaTodosPedidosInputPort.buscarTodos()).thenReturn(Collections.singletonList(pedidoDTO));

            ResultActions result = mockMvc.perform(get("/pedidos")
                    .contentType(MediaType.APPLICATION_JSON)
            );

            result.andExpect(status().isOk());

            verify(buscaTodosPedidosInputPort, times(1)).buscarTodos();
            verifyNoMoreInteractions(buscaTodosPedidosInputPort);
        }

        @Test
        void buscaPedidosParaSeremExibidosNaFilaDePreparacao() throws Exception {
            var pedidoDTO = getPedidoDTO();

            when(buscaPedidosOrdenadosPorPrioridadeInputPort.buscarPorPrioridade()).thenReturn(Collections.singletonList(pedidoDTO));

            ResultActions result = mockMvc.perform(get("/pedidos/fila-producao")
                    .contentType(MediaType.APPLICATION_JSON)
            );

            result.andExpect(status().isOk());

            verify(buscaPedidosOrdenadosPorPrioridadeInputPort, times(1)).buscarPorPrioridade();
            verifyNoMoreInteractions(buscaPedidosOrdenadosPorPrioridadeInputPort);
        }

        @Test
        void buscarPedidoPorId() throws Exception {
            var id = 1L;
            var pedidoDTO = getPedidoDTO();

            when(buscarPedidoPorIdInputPort.buscarPorId(any(Long.class))).thenReturn(pedidoDTO);

            ResultActions result = mockMvc.perform(get("/pedidos/{id}", id)
                    .contentType(MediaType.APPLICATION_JSON)
            );

            result.andExpect(status().isOk());

            verify(buscarPedidoPorIdInputPort, times(1)).buscarPorId(any(Long.class));
            verifyNoMoreInteractions(buscarPedidoPorIdInputPort);
        }

        @Test
        void criaUmPedido() throws Exception {
            var pedidoDTO = getPedidoDTO();

            when(criaPedidoInputPort.criar(any(CriaPedidoDTO.class))).thenReturn(pedidoDTO);

            ResultActions result = mockMvc.perform(post("/pedidos")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(pedidoRequest))
            );

            result.andExpect(status().isCreated());

            verify(criaPedidoInputPort, times(1)).criar(any(CriaPedidoDTO.class));
            verifyNoMoreInteractions(criaPedidoInputPort);
        }

        @Test
        void atualizaStatusDoPedido() throws Exception {
            var pedidoDTO = getPedidoDTO();
            var id = 1L;

            when(atualizaStatusPedidoInputPort.atualizarStatus(any(Long.class), any(AtualizaStatusPedidoDTO.class))).thenReturn(pedidoDTO);

            ResultActions result = mockMvc.perform(patch("/pedidos/{id}/status", id, atualizaStatusPedidoRequest)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(atualizaStatusPedidoRequest))
            );

            result.andExpect(status().isAccepted());

            verify(atualizaStatusPedidoInputPort, times(1)).atualizarStatus(any(Long.class), any(AtualizaStatusPedidoDTO.class));
            verifyNoMoreInteractions(atualizaStatusPedidoInputPort);
        }

        @Test
        void buscarTodosPedidosPorStatus() throws Exception {
            var status = "PENDENTE_DE_PAGAMENTO";
            var pedidoDTO = getPedidoDTO();

            when(buscaTodosPedidosPorStatusInputPort.buscarTodosStatus(any(StatusPedidoEnum.class))).thenReturn(Collections.singletonList(pedidoDTO));

            ResultActions result = mockMvc.perform(get("/pedidos/status/{status}", status)
                    .contentType(MediaType.APPLICATION_JSON)
            );

            result.andExpect(status().isOk());

            verify(buscaTodosPedidosPorStatusInputPort, times(1)).buscarTodosStatus(any(StatusPedidoEnum.class));
            verifyNoMoreInteractions(buscaTodosPedidosPorStatusInputPort);
        }

        @Test
        void buscarCobrancaPorPedidoId() throws Exception {
            var id = 1L;
            var cobrancaDTO = getCobrancaDTO();

            when(buscaCobrancaPorPedidoIdInputPort.buscarPorPedidoId(any(Long.class))).thenReturn(cobrancaDTO);

            ResultActions result = mockMvc.perform(get("/pedidos/{id}/cobranca", id)
                    .contentType(MediaType.APPLICATION_JSON)
            );

            result.andExpect(status().isOk());

            verify(buscaCobrancaPorPedidoIdInputPort, times(1)).buscarPorPedidoId(any(Long.class));
            verifyNoMoreInteractions(buscaCobrancaPorPedidoIdInputPort);
        }

    }
}