package br.com.fiap.techchallenge.lanchonete.adapters.messages.listeners;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.AtualizaStatusPedidoInputPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.model.Message;

@Component
public class PagamentosListener {

    private static Logger logger = LoggerFactory.getLogger(PagamentosListener.class);

    private final AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort;

    private final ObjectMapper objectMapper;

    public PagamentosListener(AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort, ObjectMapper objectMapper) {
        this.atualizaStatusPedidoInputPort = atualizaStatusPedidoInputPort;
        this.objectMapper = objectMapper;
    }

    @Transactional
    @SqsListener("${aws.sqs.queues.pagamentos}")
    public void receberMensagem(Message mensagem) throws JsonProcessingException {
        logger.info("Recebendo mensagem: {}", mensagem);

        var cobrancaDTO = objectMapper.readValue(mensagem.body(), CobrancaDTO.class);
        atualizaStatusPedidoInputPort.atualizarStatus(cobrancaDTO.pedidoId(), cobrancaDTO.status());
    }
}
