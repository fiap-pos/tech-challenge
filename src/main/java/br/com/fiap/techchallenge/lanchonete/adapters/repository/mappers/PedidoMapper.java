package br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.AuthGateway;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Pedido;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    private final ItemPedidoMapper itemPedidoMapper;
    private final AuthGateway authGateway;

    public PedidoMapper(ItemPedidoMapper itemPedidoMapper, AuthGateway authGateway) {
        this.itemPedidoMapper = itemPedidoMapper;
        this.authGateway = authGateway;
    }

    public Pedido toPedido(PedidoDTO pedidoIn){
        var cliente = pedidoIn.cliente() != null
                ? authGateway.buscarPorId(pedidoIn.cliente().id()) : null;

        var pedido = cliente != null
                ? new Pedido(pedidoIn.status(), cliente.id(), pedidoIn.dataCriacao(), pedidoIn.valorTotal())
                : new Pedido(pedidoIn.status(), pedidoIn.dataCriacao(), pedidoIn.valorTotal());

        var itemPedido = itemPedidoMapper.toItemPedido(pedido, pedidoIn.itens());
        pedido.setItens(itemPedido);
        return pedido;

    }

    public PedidoDTO toPedidoDTO(Pedido pedido) {

        var clienteDTO = pedido.getClienteId() != null
                ? authGateway.buscarPorId(pedido.getClienteId())
                : null;

        var listaItemPedidoOut = itemPedidoMapper.toItemPedidoResponse(pedido.getItens());

        return new PedidoDTO(
                pedido.getId(),
                clienteDTO,
                listaItemPedidoOut,
                pedido.getStatus(),
                pedido.getValorTotal(),
                pedido.getData()
        );

    }
}
