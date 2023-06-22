package br.com.fiap.techchallenge.lanchonete.adapters.web.mapper;

import br.com.fiap.techchallenge.lanchonete.adapters.web.models.PedidoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.PedidoResponse;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoOut;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("PedidoMapperWeb")
public class PedidoMapper {

    public PedidoResponse toPedidoResponse(PedidoOut pedidoOut){
        return new PedidoResponse(pedidoOut.getId(), pedidoOut.getStatus(), pedidoOut.getClienteId(),
                pedidoOut.getProdutoid(), pedidoOut.getQuantidade());
    }

    public List<PedidoResponse> toPedidoListResponse(List<PedidoOut> pedidosOut){
        List<PedidoResponse> pedidosResponse = new ArrayList<>();
        pedidosOut.forEach(pedidoOut -> pedidosResponse.add(toPedidoResponse(pedidoOut)));
        return pedidosResponse;
    }

    public PedidoRequest toPedidoRequest(PedidoRequest pedidoRequest){
        return  new PedidoRequest(pedidoRequest.getStatus(), pedidoRequest.getClienteId(),
                pedidoRequest.getProdutoid(), pedidoRequest.getQuantidade());
    }

}
