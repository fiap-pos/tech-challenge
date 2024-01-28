package br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao;

import br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.models.FilaProducaoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.mappers.FilaProducaoMapper;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.EnviaPedidoFilaProducaoOutputPort;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.IIOException;
import java.io.IOException;

@Service
public class FilaProducaoGateway implements EnviaPedidoFilaProducaoOutputPort {

    @Value("${services.producao.url}")
    private String producaoUrl;
    private final Logger logger = LoggerFactory.getLogger(FilaProducaoGateway.class);
    private final OkHttpClient okHttpClient;
    private final FilaProducaoMapper filaProducaoMapper;
    private final ObjectMapper objectMapper;

    public FilaProducaoGateway(OkHttpClient okHttpClient, FilaProducaoMapper filaProducaoMapper, ObjectMapper objectMapper) {
        this.okHttpClient = okHttpClient;
        this.filaProducaoMapper = filaProducaoMapper;
        this.objectMapper = objectMapper;
    }

    @Override
    public void enviarPedido(PedidoDTO pedidoDTO) {

        try {
            var filaProducaoRequest = filaProducaoMapper.toRequest(pedidoDTO);
            var jsonRequest = objectMapper.writeValueAsString(filaProducaoRequest);
            var requestBody = RequestBody.create(
                    jsonRequest,
                    MediaType.get("application/json; charset=utf-8")
            );

            var request = new Request.Builder()
                    .url(producaoUrl + "/producao")
                    .post(requestBody)
                    .build();

            var response = okHttpClient.newCall(request).execute();

            if (!response.isSuccessful())
                throw new IIOException("Falha ao enviar pedido para fila de produção");

            objectMapper.readValue(response.body().string(), FilaProducaoResponse.class);

            response.close();

        } catch (IOException ex) {
            logger.error("Falha ao enviar pedido para fila de produção", ex);
            throw new RuntimeException(ex);
        }
    }
}
