package br.com.fiap.techchallenge.lanchonete.core.usecases.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cobranca.BuscaCobrancaPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cobranca.BuscaCobrancaOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.fiap.techchallenge.lanchonete.utils.CobrancaHelper.getCobrancaDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class BuscaCobrancaPorIdUseCaseTest {

    private BuscaCobrancaPorIdInputPort buscaCobrancaPorIdInputPort;

    @Mock
    BuscaCobrancaOutputPort buscaCobrancaOutputPort;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        buscaCobrancaPorIdInputPort = new BuscaCobrancaPorIdUseCase(buscaCobrancaOutputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class buscaCobrancaPorIdUseCase {

        @Test
        void buscaCobrancaPorId() {
            var cobrancaDTO = getCobrancaDTO();

            when(buscaCobrancaOutputPort.buscarPorId(anyLong())).thenReturn(cobrancaDTO);

            var cobrancaBuscada = buscaCobrancaPorIdInputPort.buscarPorId(cobrancaDTO.id());

            assertThat(cobrancaBuscada).isNotNull().isInstanceOf(CobrancaDTO.class);
            assertThat(cobrancaBuscada.id()).isEqualTo(cobrancaDTO.id());
            assertThat(cobrancaBuscada.pedidoId()).isEqualTo(cobrancaDTO.pedidoId());
            assertThat(cobrancaBuscada.status()).isEqualTo(cobrancaDTO.status());
            assertThat(cobrancaBuscada.valor()).isEqualTo(cobrancaDTO.valor());
            assertThat(cobrancaBuscada.qrCode()).isEqualTo(cobrancaDTO.qrCode());

            verify(buscaCobrancaOutputPort, times(1)).buscarPorId(anyLong());
            verifyNoMoreInteractions(buscaCobrancaOutputPort);
        }

    }

}