package br.com.fiap.techchallenge.lanchonete.core.usecases.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusCobrancaEnum;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.domain.exceptions.BadRequestException;
import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaStatusCobrancaDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cobranca.AtualizaStatusCobrancaInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cobranca.AtualizaStatusCobrancaOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cobranca.BuscaCobrancaOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.AtualizaStatusPedidoOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.fiap.techchallenge.lanchonete.utils.CobrancaHelper.getCobrancaDTO;
import static br.com.fiap.techchallenge.lanchonete.utils.CobrancaHelper.getCobrancaDTOcomStatusPendente;
import static br.com.fiap.techchallenge.lanchonete.utils.PedidoHelper.getPedidoDTOcomStatus;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AtualizaStatusCobrancaUseCaseTest {

    private AtualizaStatusCobrancaInputPort atualizaStatusCobrancaInputPort;

    @Mock
    BuscaCobrancaOutputPort buscaCobrancaOutputPort;


    @Mock
    AtualizaStatusCobrancaOutputPort atualizaStatusCobrancaOutputPort;

    @Mock
    AtualizaStatusPedidoOutputPort atualizaStatusPedidoOutputPort;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        atualizaStatusCobrancaInputPort = new AtualizaStatusCobrancaUseCase(
                buscaCobrancaOutputPort,
                atualizaStatusCobrancaOutputPort,
                atualizaStatusPedidoOutputPort
        );
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class atualizaStatusCobrancaUseCase {

        @Test
        void lancaExececao_atualizarStatusCobranca_DiferenteStatusPendente() {
            var cobrancaDTO = getCobrancaDTO();
            var id = cobrancaDTO.id();
            var atualizaStatusCobrancaDTO = new AtualizaStatusCobrancaDTO(StatusCobrancaEnum.PAGO);

            when(buscaCobrancaOutputPort.buscarPorId(cobrancaDTO.id())).thenReturn(cobrancaDTO);

            assertThatThrownBy(() -> atualizaStatusCobrancaInputPort.atualizarStatus(id, atualizaStatusCobrancaDTO))
                    .isInstanceOf(BadRequestException.class)
                    .hasMessage("Cobranca "+id+" não pode mais ser atualizada.");

            verify(buscaCobrancaOutputPort, times(1)).buscarPorId(anyLong());
            verify(atualizaStatusPedidoOutputPort, never()).atualizarStatus(anyLong(), any(StatusPedidoEnum.class));
            verify(atualizaStatusCobrancaOutputPort, never()).atualizarStatus(anyLong(), any(AtualizaStatusCobrancaDTO.class));
        }

        @Test
        void atualizarStatusCobranca_ComStatusPendente() {
            var cobrancaDTOcomStatusPendente = getCobrancaDTOcomStatusPendente();
            var id = cobrancaDTOcomStatusPendente.id();
            var atualizaStatusCobrancaDTOparaPago = new AtualizaStatusCobrancaDTO(StatusCobrancaEnum.PAGO);
            var cobrancaDTOcomStatusPago = getCobrancaDTO();
            var pedidoDTOcomStatusRecebido = getPedidoDTOcomStatus(StatusPedidoEnum.RECEBIDO);

            when(buscaCobrancaOutputPort.buscarPorId(id)).thenReturn(cobrancaDTOcomStatusPendente);
            when(atualizaStatusPedidoOutputPort.atualizarStatus(id, StatusPedidoEnum.RECEBIDO)).thenReturn(pedidoDTOcomStatusRecebido);
            when(atualizaStatusCobrancaOutputPort.atualizarStatus(id, atualizaStatusCobrancaDTOparaPago)).thenReturn(cobrancaDTOcomStatusPago);

            var cobrancaDTOcomStatusAtualizado = atualizaStatusCobrancaInputPort.atualizarStatus(1L, atualizaStatusCobrancaDTOparaPago);

            assertThat(cobrancaDTOcomStatusAtualizado).isNotNull().isInstanceOf(CobrancaDTO.class);
            assertThat(cobrancaDTOcomStatusAtualizado.id()).isEqualTo(cobrancaDTOcomStatusPago.id());
            assertThat(cobrancaDTOcomStatusAtualizado.pedidoId()).isEqualTo(cobrancaDTOcomStatusPago.pedidoId());
            assertThat(cobrancaDTOcomStatusAtualizado.status()).isEqualTo(cobrancaDTOcomStatusPago.status());
            assertThat(cobrancaDTOcomStatusAtualizado.valor()).isEqualTo(cobrancaDTOcomStatusPago.valor());
            assertThat(cobrancaDTOcomStatusAtualizado.qrCode()).isEqualTo(cobrancaDTOcomStatusPago.qrCode());

        }

    }

}