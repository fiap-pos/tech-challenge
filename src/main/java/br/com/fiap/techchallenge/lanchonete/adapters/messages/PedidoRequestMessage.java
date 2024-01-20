//package br.com.fiap.techchallenge.lanchonete.adapters.messages;
//
//import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
//import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.AtualizaStatusPedidoInputPort;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.awspring.cloud.sqs.annotation.SqsListener;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import software.amazon.awssdk.services.sqs.model.Message;
//
//public class PedidoRequestMessage {
//    private static Logger logger = LoggerFactory.getLogger(PedidoRequestMessage.class);
//
//    private final AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort;
//
//    public PedidoRequestMessage(AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort) {
//        this.atualizaStatusPedidoInputPort = atualizaStatusPedidoInputPort;
//    }
//
//    //    @SqsListener(value = "sqsPagamentos")
////    public void receiveMessage(Message message) {
////
////        try{
////            logger.info("Message: " + message.body());
////        }
////        catch (Exception e)
////        {
////            logger.error(e.getMessage(), e);
////        }
////    }
//
//    @SqsListener("sqsPagamentos")
//    public void receberMensagem(Message mensagem) throws JsonProcessingException {
//        ObjectMapper om = new ObjectMapper();
//        var pedidoDto = om.readValue(mensagem.body(), PedidoDTO.class);
//        atualizaStatusPedidoInputPort.atualizarStatus(pedidoDto.id(), pedidoDto.status());
//    }
//
//}
