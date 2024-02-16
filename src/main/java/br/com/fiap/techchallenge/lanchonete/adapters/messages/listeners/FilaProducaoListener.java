package br.com.fiap.techchallenge.lanchonete.adapters.messages.listeners;

import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.AtualizaStatusPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.adapters.messages.models.PedidoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.model.Message;

@Service
public class FilaProducaoListener {
    private final AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort;

    private final ObjectMapper objectMapper;

    public FilaProducaoListener(AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort, ObjectMapper objectMapper) {
        this.atualizaStatusPedidoInputPort = atualizaStatusPedidoInputPort;
        this.objectMapper = objectMapper;
    }

    @SqsListener("${aws.sqs.queues.producao}")
    public void listen(Message menssagem) throws JsonProcessingException {
        var pedidoDTO = objectMapper.readValue(menssagem.body(), PedidoDTO.class);
        atualizaStatusPedidoInputPort.atualizarStatus(
                pedidoDTO.codigo(),
                pedidoDTO.status()
        );
    }
}
