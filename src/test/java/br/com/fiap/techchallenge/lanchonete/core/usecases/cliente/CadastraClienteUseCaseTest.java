package br.com.fiap.techchallenge.lanchonete.core.usecases.cliente;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente.CadastraClienteInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.CadastraClienteOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.fiap.techchallenge.lanchonete.utils.adapters.web.ClienteHelper.getClienteDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class CadastraClienteUseCaseTest {

    private CadastraClienteInputPort cadastraClienteInputPort;

    @Mock
    CadastraClienteOutputPort cadastraClienteOutputPort;

    AutoCloseable mock;

    @BeforeEach
    void setup() {
        mock = MockitoAnnotations.openMocks(this);
        cadastraClienteInputPort = new CadastraClienteUseCase(cadastraClienteOutputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class cadastraClienteUseCase {
        @Test
        void cadastraClienteUse() {
            var clienteDTO = getClienteDTO();
            when(cadastraClienteOutputPort.cadastrar(any(ClienteDTO.class))).thenReturn(clienteDTO);

            var clienteCadastrado = cadastraClienteInputPort.cadastrar(clienteDTO);

            assertThat(clienteCadastrado).isNotNull();
            assertThat(clienteCadastrado.nome()).isEqualTo(clienteDTO.nome());
            verify(cadastraClienteOutputPort, times(1)).cadastrar(any(ClienteDTO.class));
            verifyNoMoreInteractions(cadastraClienteOutputPort);
        }
    }

}