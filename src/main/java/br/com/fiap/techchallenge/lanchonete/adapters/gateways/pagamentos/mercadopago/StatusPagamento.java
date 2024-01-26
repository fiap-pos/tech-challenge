//package br.com.fiap.techchallenge.lanchonete.adapters.gateways.pagamentos.mercadopago;
//
//import br.com.fiap.techchallenge.lanchonete.adapters.web.models.pagamentos.mercadopago.StatusPedidoMercadoPago;
//import br.com.fiap.techchallenge.lanchonete.core.domain.exceptions.PaymentErrorException;
//import br.com.fiap.techchallenge.lanchonete.core.dtos.StatusPagamentoDTO;
//import br.com.fiap.techchallenge.lanchonete.core.ports.out.cobranca.BuscaStatusPagamentoOutputPort;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.squareup.okhttp.OkHttpClient;
//import com.squareup.okhttp.Request;
//import com.squareup.okhttp.Response;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Service;
//
//@Service
//public class StatusPagamento implements BuscaStatusPagamentoOutputPort {
//
//    @Value("${mercadopago.api.url}")
//    private String UrlMercadoPagoApiPagamentos;
//
//    @Value("${mercadopago.api.token}")
//    private String token;
//
//
//    @Override
//    public StatusPagamentoDTO buscaStatus(Long id) {
//        ObjectMapper mapper = new ObjectMapper()
//                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        //TODO: Extrair configuração OkHttp e injetar no construtor
//        OkHttpClient httpClient = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url(UrlMercadoPagoApiPagamentos + id)
//                .addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
//                .build();
//
//        try {
//            Response response = httpClient.newCall(request).execute();
//            if (!response.isSuccessful())
//                throw new PaymentErrorException(response.message());
//
//            StatusPedidoMercadoPago statusPedidoMercadoPago = mapper.readValue(
//                    response.body().byteStream(),
//                    StatusPedidoMercadoPago.class
//            );
//
//            return statusPedidoMercadoPago.toStatusPagamentoDTO();
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//}
