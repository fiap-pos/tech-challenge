package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.mappers.PedidoMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.ItemPedidoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.PedidoRequest;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CriaPedidoDTO;
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
import static br.com.fiap.techchallenge.lanchonete.utils.PedidoHelper.getPedidoDTO;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PedidoControllerTest {

    private MockMvc mockMvc;

    @Mock
    CriaPedidoInputPort criaPedidoInputPort;

    @Mock
    BuscaTodosPedidosInputPort buscaTodosPedidosInputPort;

    @Mock
    BuscarPedidoPorIdInputPort buscarPedidoPorIdInputPort;

    @Mock
    BuscaTodosPedidosPorStatusInputPort buscaTodosPedidosPorStatusInputPort;

    PedidoMapper pedidoMapper;

    AutoCloseable mock;

    private ItemPedidoRequest itemPedidoRequest;

    private PedidoRequest pedidoRequest;

    @BeforeEach
    void setUp() {
        itemPedidoRequest = new ItemPedidoRequest(1L, 10);
        pedidoRequest = new PedidoRequest(Collections.singletonList(itemPedidoRequest));

        this.pedidoMapper = new PedidoMapper();
        mock = MockitoAnnotations.openMocks(this);
        PedidoController pedidoController = new PedidoController(
                criaPedidoInputPort,
                buscaTodosPedidosInputPort,
                buscarPedidoPorIdInputPort,
                buscaTodosPedidosPorStatusInputPort,
                pedidoMapper
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
            var authorization = "Bearer token";

            when(criaPedidoInputPort.criar(any(CriaPedidoDTO.class), eq(authorization))).thenReturn(pedidoDTO);

            ResultActions result = mockMvc.perform(post("/pedidos")
                    .contentType(MediaType.APPLICATION_JSON)
                    .header("Authorization", authorization)
                    .content(asJsonString(pedidoRequest))
            );

            result.andExpect(status().isCreated());

            verify(criaPedidoInputPort, times(1)).criar(any(CriaPedidoDTO.class), eq(authorization));
            verifyNoMoreInteractions(criaPedidoInputPort);
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

    }
}