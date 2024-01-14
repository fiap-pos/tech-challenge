package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.CobrancaRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sqs")
public class SqsController {
    private static final Logger logger = LoggerFactory.getLogger(SqsController.class);

    private SqsTemplate sqsTemplate;

    public SqsController(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
    }

    @PostMapping("/publish")
    public ResponseEntity<?> publish(@RequestBody CobrancaRequest cobranca){
        sqsTemplate.send("sqsPagamentos", cobranca);
        return ResponseEntity.ok().build();
    }
}
