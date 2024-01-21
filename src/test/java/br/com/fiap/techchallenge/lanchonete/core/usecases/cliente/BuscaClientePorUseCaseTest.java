package br.com.fiap.techchallenge.lanchonete.core.usecases.cliente;

import br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente.BuscaClientePorInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.BuscaClienteOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.fiap.techchallenge.lanchonete.utils.ClienteHelper.getClienteDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class BuscaClientePorUseCaseTest {

    private BuscaClientePorInputPort buscaClientePorInputPort;

    @Mock
    BuscaClienteOutputPort buscaClienteOutputPort;

    AutoCloseable mock;

    @BeforeEach
    void setup() {
        mock = MockitoAnnotations.openMocks(this);
        buscaClientePorInputPort = new BuscaClientePorUseCase(buscaClienteOutputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class buscarClienteUseCase {

        @Test
        void buscarClientePorCpf() {
            var clienteDTO = getClienteDTO();
            var cpf = clienteDTO.cpf();
            when(buscaClienteOutputPort.buscar(cpf)).thenReturn(clienteDTO);

            var clienteBuscado = buscaClientePorInputPort.buscar(cpf);

            assertThat(clienteBuscado).isNotNull();
            assertThat(clienteBuscado.cpf()).isEqualTo(clienteDTO.cpf());
            assertThat(clienteBuscado.nome()).isEqualTo(clienteDTO.nome());
            verify(buscaClienteOutputPort, times(1)).buscar(anyString());
            verifyNoMoreInteractions(buscaClienteOutputPort);
        }

        @Test
        void buscarClientePorId() {
            var clienteDTO = getClienteDTO();
            var id = clienteDTO.id();
            when(buscaClienteOutputPort.buscar(id)).thenReturn(clienteDTO);

            var clienteBuscado = buscaClientePorInputPort.buscar(id);

            assertThat(clienteBuscado).isNotNull();
            assertThat(clienteBuscado.id()).isEqualTo(clienteDTO.id());
            assertThat(clienteBuscado.nome()).isEqualTo(clienteDTO.nome());
            verify(buscaClienteOutputPort, times(1)).buscar(anyLong());
            verifyNoMoreInteractions(buscaClienteOutputPort);
        }
    }

}