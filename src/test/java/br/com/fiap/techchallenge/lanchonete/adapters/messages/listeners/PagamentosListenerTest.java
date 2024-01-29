package br.com.fiap.techchallenge.lanchonete.adapters.messages.listeners;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.ClienteRepository;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.AtualizaStatusPedidoInputPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.instancio.Instancio;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import software.amazon.awssdk.services.sqs.model.Message;

import javax.management.InstanceAlreadyExistsException;

import static br.com.fiap.techchallenge.lanchonete.utils.CobrancaHelper.getCobrancaDTO;
import static br.com.fiap.techchallenge.lanchonete.utils.PedidoHelper.getPedidoDTO;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PagamentosListenerTest {

    private PagamentosListener pagamentosListener;

    @Mock
    AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort;

    AutoCloseable openMocks;

    @BeforeEach
    void setup() {
        openMocks = MockitoAnnotations.openMocks(this);
        pagamentosListener = new PagamentosListener(atualizaStatusPedidoInputPort);
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

        var objectMapper = new ObjectMapper();
        when(message.body()).thenReturn(objectMapper.writeValueAsString(cobrancaDTO));
        when(atualizaStatusPedidoInputPort.atualizarStatus(cobrancaDTO.id(), cobrancaDTO.status())).thenReturn(pedidoDTO);

        pagamentosListener.receberMensagem(message);

        verify(atualizaStatusPedidoInputPort, times(1)).atualizarStatus(cobrancaDTO.id(), cobrancaDTO.status());
    }
}