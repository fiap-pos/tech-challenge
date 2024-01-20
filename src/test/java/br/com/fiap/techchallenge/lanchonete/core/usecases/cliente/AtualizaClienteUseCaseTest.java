package br.com.fiap.techchallenge.lanchonete.core.usecases.cliente;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente.AtualizaClienteInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.AtualizaClienteOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.fiap.techchallenge.lanchonete.utils.adapters.web.ClienteHelper.getClienteDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class AtualizaClienteUseCaseTest {

    private AtualizaClienteInputPort atualizaClienteInputPort;

    @Mock
    AtualizaClienteOutputPort atualizaClienteOutputPort;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        atualizaClienteInputPort = new AtualizaClienteUseCase(atualizaClienteOutputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class atualizaClienteUseCase {

        @Test
        void atualizaCliente() {
            var clienteAntigo = getClienteDTO();
            var clienteNovo = new ClienteDTO(
                    1L,
                    "novo nome alterado",
                    clienteAntigo.cpf(),
                    clienteAntigo.email()
            );

            when(atualizaClienteOutputPort.atualizar(any(ClienteDTO.class), anyLong())).thenReturn(clienteNovo);

            var clienteAlterado = atualizaClienteInputPort.atualizar(clienteNovo, clienteAntigo.id());

            assertThat(clienteAlterado).isNotNull().isInstanceOf(ClienteDTO.class);
            assertThat(clienteAlterado.id()).isEqualTo(clienteNovo.id());
            assertThat(clienteAlterado.nome()).isEqualTo(clienteNovo.nome());
            assertThat(clienteAlterado.cpf()).isEqualTo(clienteNovo.cpf());
            assertThat(clienteAlterado.email()).isEqualTo(clienteNovo.email());
        }
    }

}