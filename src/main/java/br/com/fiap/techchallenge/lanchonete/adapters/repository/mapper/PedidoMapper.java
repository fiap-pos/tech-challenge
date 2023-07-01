package br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ClienteJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Pedido;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.PedidoResponse;
import br.com.fiap.techchallenge.lanchonete.core.domain.exception.EntityNotFoundException;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CriaPedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoOut;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {
    private final ItemPedidoMapper itemPedidoMapper;
    private final ClienteJpaRepository clienteJpaRepository;
    private final ClienteMapper clienteMapper;
    public PedidoMapper(ItemPedidoMapper itemPedidoMapper, ClienteMapper clienteMapper,
                        ClienteJpaRepository clienteJpaRepository) {
        this.itemPedidoMapper = itemPedidoMapper;
        this.clienteMapper = clienteMapper;
        this.clienteJpaRepository = clienteJpaRepository;
    }

    public Pedido toPedido(CriaPedidoIn pedidoIn){
        var cliente = pedidoIn.getClienteId() != null
                ? clienteJpaRepository.findById(pedidoIn.getClienteId())
                    .orElseThrow(
                            ()-> new EntityNotFoundException("Cliente " + pedidoIn.getClienteId() + " não encontrado"))
                : null;

        var pedido = new Pedido(pedidoIn.getStatus(), cliente, pedidoIn.getDataCriacao(), pedidoIn.getValorTotal());
        var itemPedido = itemPedidoMapper.toItemPedido(pedido, pedidoIn.getItens());
        pedido.setItens(itemPedido);
        return pedido;

    }

    public PedidoOut toPedidoResponse(Pedido pedido){
        var listaItemPedidoOut = itemPedidoMapper.toItemPedidoResponse(pedido.getItens());
        var clienteOut = pedido.getCliente() != null
                ? clienteMapper.toClienteResponse(pedido.getCliente())
                : null;

        return clienteOut != null
                ? new PedidoResponse(pedido.getId(), clienteOut.getNome(), pedido.getValorTotal(), listaItemPedidoOut, pedido.getStatus())
                : new PedidoResponse(pedido.getId(), pedido.getValorTotal(), listaItemPedidoOut, pedido.getStatus());
    }
}
