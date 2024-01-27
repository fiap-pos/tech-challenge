package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ClienteJpaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.fiap.techchallenge.lanchonete.utils.ClienteHelper.getCliente;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ClienteRepositoryTest {

    @Mock
    ClienteJpaRepository clienteJpaRepository;

    AutoCloseable openMocks;

    @BeforeEach
    void setup() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void deveCriarCliente() {
        var cliente = getCliente();
        when(clienteJpaRepository.save(cliente)).thenReturn(cliente);

        var clienteSavo = clienteJpaRepository.save(cliente);

        assertThat(clienteSavo).isNotNull().isEqualTo(cliente);

        verify(clienteJpaRepository, times(1)).save(cliente);
    }

}