package br.com.fiap.techchallenge.lanchonete.adapters.messages;

import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.AtualizaStatusPedidoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.CobrancaRequest;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.AtualizaStatusPedidoInputPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.model.Message;


@Service
public class Listeners {

    private static Logger logger = LoggerFactory.getLogger(Listeners.class);

    private final AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort;
    public Listeners(AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort) {
        this.atualizaStatusPedidoInputPort = atualizaStatusPedidoInputPort;
    }

    @SqsListener("sqsPagamentos")
    public void receberMensagem(Message mensagem) throws JsonProcessingException {
        logger.info("Recebendo mensagem: {}", mensagem);
        ObjectMapper om = new ObjectMapper();
        var cobrancaDTO = om.readValue(mensagem.body(), CobrancaDTO.class);
        atualizaStatusPedidoInputPort.atualizarStatus(cobrancaDTO.id(), cobrancaDTO.status());
    }
}
