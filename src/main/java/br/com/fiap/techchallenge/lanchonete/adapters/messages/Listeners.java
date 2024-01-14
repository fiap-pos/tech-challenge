package br.com.fiap.techchallenge.lanchonete.adapters.messages;

import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.CobrancaRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.PedidoRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;


@Service
public class Listeners {

    private static Logger logger = LoggerFactory.getLogger(Listeners.class);

    @SqsListener(value = "sqsPagamentos")
    public void receiveMessage(Message<CobrancaRequest> message) {

        logger.info("Message received on listen method at {}", message);
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            logger.info("Message: " + message.getPayload());
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
        }
    }
}
