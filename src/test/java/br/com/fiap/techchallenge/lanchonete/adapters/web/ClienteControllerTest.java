package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.mappers.ClienteMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.ClienteRequest;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente.AtualizaClienteInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente.BuscaClientePorInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente.BuscaTodosClientesInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente.CadastraClienteInputPort;
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
import static br.com.fiap.techchallenge.lanchonete.utils.ClienteHelper.getClienteDTO;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ClienteControllerTest {

    private MockMvc mockMvc;

    @Mock
    AtualizaClienteInputPort atualizaClienteInputPort;

    @Mock
    BuscaClientePorInputPort buscaClientePorInputPort;

    @Mock
    BuscaTodosClientesInputPort buscaTodosClientesInputPort;

    @Mock
    CadastraClienteInputPort cadastraClienteInputPort;

    ClienteMapper clienteMapper;

    AutoCloseable mock;

    ClienteRequest clienteRequest;

    @BeforeEach
    void setup() {
        clienteRequest = new ClienteRequest("Nome", "99999999999", "email1@email.com");

        this.clienteMapper = new ClienteMapper();
        mock = MockitoAnnotations.openMocks(this);
        ClienteController clienteController = new ClienteController(
                atualizaClienteInputPort,
                buscaClientePorInputPort,
                buscaTodosClientesInputPort,
                cadastraClienteInputPort,
                clienteMapper
        );

        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class testaClienteController {

        @Test
        void buscaClientePorCpf() throws Exception {
            var cpf = "94187479015";
            var clienteDTO = getClienteDTO();

            when(buscaClientePorInputPort.buscar(any(String.class))).thenReturn(clienteDTO);

            ResultActions result = mockMvc.perform(get("/clientes/{cpf}", cpf)
                    .contentType(MediaType.APPLICATION_JSON)
            );

            result.andExpect(status().isOk());

            verify(buscaClientePorInputPort, times(1)).buscar(any(String.class));
            verifyNoMoreInteractions(buscaClientePorInputPort);
        }

        @Test
        void buscaTodosClientes() throws Exception {
            var clienteDTO = getClienteDTO();

            when(buscaTodosClientesInputPort.buscarTodos()).thenReturn(Collections.singletonList(clienteDTO));

            ResultActions result = mockMvc.perform(get("/clientes")
                    .contentType(MediaType.APPLICATION_JSON)
            );

            result.andExpect(status().isOk());

            verify(buscaTodosClientesInputPort, times(1)).buscarTodos();
            verifyNoMoreInteractions(buscaTodosClientesInputPort);
        }

        @Test
        void cadastraUmNovoCliente() throws Exception {
            var clienteDTO = getClienteDTO();

            when(cadastraClienteInputPort.cadastrar(any(ClienteDTO.class))).thenReturn(clienteDTO);

            ResultActions result = mockMvc.perform(post("/clientes")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(clienteRequest))
            );

            result.andExpect(status().isCreated());

            verify(cadastraClienteInputPort, times(1)).cadastrar(any(ClienteDTO.class));
            verifyNoMoreInteractions(cadastraClienteInputPort);
        }

        @Test
        void atualizaUmClientePeloId() throws Exception {
            var id = 1L;
            var clienteDTO = getClienteDTO();

            when(atualizaClienteInputPort.atualizar(any(ClienteDTO.class), any(Long.class))).thenReturn(clienteDTO);

            ResultActions result = mockMvc.perform(put("/clientes/{id}", id)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(clienteRequest))
            );

            result.andExpect(status().isOk());

            verify(atualizaClienteInputPort, times(1)).atualizar(any(ClienteDTO.class), any(Long.class));
            verifyNoMoreInteractions(atualizaClienteInputPort);
        }

    }

}