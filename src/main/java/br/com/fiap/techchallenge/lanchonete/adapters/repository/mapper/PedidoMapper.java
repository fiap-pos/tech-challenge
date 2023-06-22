package br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Pedido;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.PedidoResponse;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoOut;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoMapper {

    public Pedido toPedido(Produto produto, PedidoIn pedidoIn){
        return new Pedido(pedidoIn.getStatus(), pedidoIn.getClienteId(),
                produto, pedidoIn.getQuantidade());
    }

    public PedidoOut toPedidoResponse(Pedido pedido){
        return new PedidoResponse(pedido.getId(), pedido.getStatus(),
                pedido.getClienteId(), pedido.getProduto().getId(), pedido.getQuantidade());
    }

    public List<PedidoOut> toPedidoListResponse(List<Pedido> pedidos){
        List<PedidoOut> pedidosOut = new ArrayList<>();
        pedidos.forEach(pedidoOut -> pedidosOut.add(toPedidoResponse(pedidoOut)));
        return pedidosOut;
    }
}
