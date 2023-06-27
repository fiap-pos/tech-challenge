package br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Pedido;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.PedidoResponse;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoOut;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public Pedido toPedido(PedidoIn pedidoIn){

        return new Pedido(pedidoIn.getStatus(), pedidoIn.getDataCriacao(), pedidoIn.getCliente(),
                pedidoIn.getItens());
    }

    public PedidoOut toPedidoResponse(Pedido pedido){
        return new PedidoResponse(pedido.getId(), pedido.getStatus(), pedido.getData(),
                pedido.getCliente(), pedido.getItens());
    }
}
