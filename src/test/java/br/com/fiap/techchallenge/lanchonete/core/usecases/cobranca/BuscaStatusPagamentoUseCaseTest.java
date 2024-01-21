package br.com.fiap.techchallenge.lanchonete.core.usecases.cobranca;

import br.com.fiap.techchallenge.lanchonete.adapters.gateways.pagamentos.mercadopago.StatusPagamento;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusCobrancaEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.StatusPagamentoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cobranca.BuscaStatusPagamentoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cobranca.BuscaStatusPagamentoOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.fiap.techchallenge.lanchonete.utils.CobrancaHelper.getCobrancaDTO;
import static br.com.fiap.techchallenge.lanchonete.utils.CobrancaHelper.getStatusPagamentoPagoDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class BuscaStatusPagamentoUseCaseTest {

    private BuscaStatusPagamentoInputPort buscaStatusPagamentoInputPort;

    @Mock
    BuscaStatusPagamentoOutputPort buscaStatusPagamentoOutputPort;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        buscaStatusPagamentoInputPort = new BuscaStatusPagamentoUseCase(buscaStatusPagamentoOutputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class buscaStatusPagamentoUseCase {

        @Test
        void buscaStatusPagamento() {
            var statusPagamentoDTO = getStatusPagamentoPagoDTO();

            when(buscaStatusPagamentoOutputPort.buscaStatus(anyLong())).thenReturn(statusPagamentoDTO);

            var statusPagamentoBuscado = buscaStatusPagamentoInputPort.buscaStatus(statusPagamentoDTO.id());


            assertThat(statusPagamentoBuscado).isNotNull().isInstanceOf(StatusPagamentoDTO.class);
            assertThat(statusPagamentoBuscado.id()).isEqualTo(statusPagamentoDTO.id());
            assertThat(statusPagamentoBuscado.statusPedido()).isEqualTo(statusPagamentoDTO.statusPedido());
            assertThat(statusPagamentoBuscado.statusPagamento()).isEqualTo(statusPagamentoDTO.statusPagamento());

            verify(buscaStatusPagamentoOutputPort, times(1)).buscaStatus(anyLong());
            verifyNoMoreInteractions(buscaStatusPagamentoOutputPort);
        }
    }

}