package br.com.fiap.techchallenge.lanchonete.adapters.messages.listeners;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.AtualizaStatusPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.adapters.messages.models.ItemPedidoDTO;
import br.com.fiap.techchallenge.lanchonete.adapters.messages.models.PedidoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import software.amazon.awssdk.services.sqs.model.Message;

import java.time.LocalDateTime;
import java.util.List;

import static br.com.fiap.techchallenge.lanchonete.utils.PedidoHelper.getPedidoDTO;
import static org.mockito.Mockito.*;


class FilaProducaoListenerTest {

    private FilaProducaoListener filaProducaoListener;

    @Mock
    private AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort;

    @Mock
    private ObjectMapper objectMapper;

    AutoCloseable openMocks;

    @BeforeEach
    void setup() {
        openMocks = MockitoAnnotations.openMocks(this);
        filaProducaoListener = new FilaProducaoListener(atualizaStatusPedidoInputPort, objectMapper);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void listenTest() throws JsonProcessingException {
        var nome = "nome";
        var descricao = "descricao";
        var quantidade = 1;
        var item = new ItemPedidoDTO(nome, descricao, quantidade);
        var itens = List.of(item);
        var codigo = 1L;
        var status = StatusPedidoEnum.RECEBIDO;
        var dataCriacao = LocalDateTime.now();
        var pedidoDTO = new PedidoDTO(codigo, itens, status, dataCriacao);
        var peditoDTOJson = getPedidoJson(pedidoDTO);
        var message = mock(Message.class);
        var pedidoDTORetorno = getPedidoDTO();

        when(objectMapper.readValue(peditoDTOJson, PedidoDTO.class)).thenReturn(pedidoDTO);
        when(atualizaStatusPedidoInputPort.atualizarStatus(
                pedidoDTO.codigo(),
                pedidoDTO.status())).thenReturn(pedidoDTORetorno);
        when(message.body()).thenReturn(peditoDTOJson);

        filaProducaoListener.listen(message);

        verify(atualizaStatusPedidoInputPort, times(1))
                .atualizarStatus(pedidoDTO.codigo(), pedidoDTO.status());
    }

    private String getPedidoJson(PedidoDTO pedidoDTO) throws JsonProcessingException {
        var objMapper = new ObjectMapper();
        objMapper.findAndRegisterModules();
        return objMapper.writeValueAsString(pedidoDTO);
    }
}