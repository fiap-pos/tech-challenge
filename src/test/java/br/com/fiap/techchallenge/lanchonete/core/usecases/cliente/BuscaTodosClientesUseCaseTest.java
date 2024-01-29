package br.com.fiap.techchallenge.lanchonete.core.usecases.cliente;

import br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente.BuscaTodosClientesInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.BuscaTodosClientesOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static br.com.fiap.techchallenge.lanchonete.utils.ClienteHelper.getClienteDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class BuscaTodosClientesUseCaseTest {

    private BuscaTodosClientesInputPort buscaTodosClientesInputPort;

    @Mock
    BuscaTodosClientesOutputPort buscaTodosClientesOutputPort;

    AutoCloseable mock;

    @BeforeEach
    void setup() {
        mock = MockitoAnnotations.openMocks(this);
        buscaTodosClientesInputPort = new BuscaTodosClientesUseCase(buscaTodosClientesOutputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class buscarTodosClienteUseCase {

        @Test
        void buscarTodosCliente() {
            var clientes = List.of(getClienteDTO());
            when(buscaTodosClientesOutputPort.buscarTodos()).thenReturn(clientes);

            var clientesBuscados = buscaTodosClientesInputPort.buscarTodos();

            assertThat(clientesBuscados).isNotNull();
            assertThat(clientesBuscados).allSatisfy(produto -> {
                assertThat(produto.nome()).isEqualTo(clientes.get(0).nome());
            });
        }

    }
}