package br.com.fiap.techchallenge.lanchonete.adapters.gateways.mail;


import br.com.fiap.techchallenge.lanchonete.adapters.gateways.mail.mappers.MailMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.mail.models.Mail;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.NotificaClienteOuputPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MailGateway implements NotificaClienteOuputPort {

    @Value("${services.mailtrap.url}")
    private String mailApiUrl;

    @Value("${services.mailtrap.api-key}")
    private String mailApiKey;

    @Value("${services.mail.from-mail}")
    private String mailFrom;

    @Value("${services.mail.from-name}")
    private String mailFromName;

    @Value("${services.mail.enabled}")
    private Boolean mailApiEnabled;

    private final Logger logger = LoggerFactory.getLogger(MailGateway.class);

    private final OkHttpClient okHttpClient;

    private final ObjectMapper objectMapper;

    private final MailMapper mailMapper;

    public MailGateway(OkHttpClient okHttpClient, ObjectMapper objectMapper, MailMapper mailMapper) {
        this.okHttpClient = okHttpClient;
        this.objectMapper = objectMapper;
        this.mailMapper = mailMapper;
    }

    public void notificaClienteStatusPedido(PedidoDTO pedidoDTO) {
        var mail = mailMapper.toMailStatusPedido(pedidoDTO, mailFrom, mailFromName);
        if (Boolean.TRUE.equals(mailApiEnabled)) {
            notifica(mail);
        } else {
            logNotifica(mail);
        }

    }

    private void notifica(Mail mail) {

        MediaType mediaType = MediaType.parse("application/json");

        try {
            RequestBody body = RequestBody.create(
                    objectMapper.writeValueAsString(mail),
                    mediaType
            );

            Request request = new Request.Builder()
                    .url(mailApiUrl)
                    .method("POST", body)
                    .addHeader("Authorization", "Bearer " + mailApiKey)
                    .addHeader("Content-Type", "application/json")
                    .build();

            Response response = okHttpClient.newCall(request).execute();

            if (!response.isSuccessful()) {
                var responseString = response.body().string();
                logger.error("Erro ao enviar e-mail: {}", responseString);
            }

        } catch (JsonProcessingException e) {
            logger.error("Erro ao converter objeto para JSON", e);
        } catch (IOException | NullPointerException e) {
            logger.error("Erro ao enviar e-mail: " + e.getMessage(), e);
        }
    }

    private void logNotifica(Mail mail) {
        try {
            var jsonValue = objectMapper.writeValueAsString(mail);
            logger.info("Enviando e-mail: {}", jsonValue);
        } catch (JsonProcessingException e) {
            logger.error("Erro ao converter objeto para JSON", e);
        }
    }


}
