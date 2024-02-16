package br.com.fiap.techchallenge.lanchonete.adapters.messages.listeners;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.AtualizaStatusPedidoInputPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import software.amazon.awssdk.services.sqs.model.Message;

import static br.com.fiap.techchallenge.lanchonete.utils.CobrancaHelper.getCobrancaDTO;
import static br.com.fiap.techchallenge.lanchonete.utils.PedidoHelper.getPedidoDTO;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PagamentosListenerTest {

    private PagamentosListener pagamentosListener;

    @Mock
    private AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort;

    @Mock
    private ObjectMapper objectMapper;

    AutoCloseable openMocks;

    @BeforeEach
    void setup() {
        openMocks = MockitoAnnotations.openMocks(this);
        pagamentosListener = new PagamentosListener(atualizaStatusPedidoInputPort, objectMapper);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void receberMensagem() throws JsonProcessingException {
        var cobrancaDTO = getCobrancaDTO();
        var pedidoDTO = getPedidoDTO();
        var message = mock(Message.class);
        var objMapper = new ObjectMapper();
        var cobrancaDTOJson = objMapper.writeValueAsString(cobrancaDTO);

        when(message.body()).thenReturn(cobrancaDTOJson);
        when(objectMapper.readValue(cobrancaDTOJson, CobrancaDTO.class)).thenReturn(cobrancaDTO);
        when(atualizaStatusPedidoInputPort.atualizarStatus(cobrancaDTO.id(), cobrancaDTO.status())).thenReturn(pedidoDTO);

        pagamentosListener.receberMensagem(message);

        verify(atualizaStatusPedidoInputPort, times(1)).atualizarStatus(cobrancaDTO.id(), cobrancaDTO.status());
    }
}