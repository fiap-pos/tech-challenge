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
    public PedidoMapper(ItemPedidoMapper itemPedidoMapper, ClienteJpaRepository clienteJpaRepository) {
        this.itemPedidoMapper = itemPedidoMapper;
        this.clienteJpaRepository = clienteJpaRepository;
    }

    public Pedido toPedido(CriaPedidoIn pedidoIn){
        var cliente = pedidoIn.getClienteId() != null
                ? clienteJpaRepository.findById(pedidoIn.getClienteId())
                    .orElseThrow(() -> new EntityNotFoundException("Cliente "+pedidoIn.getClienteId()+" não encontrado"))
                : null;

        var pedido = cliente != null
                ? new Pedido(pedidoIn.getStatus(), cliente, pedidoIn.getDataCriacao(), pedidoIn.getValorTotal())
                : new Pedido(pedidoIn.getStatus(), pedidoIn.getDataCriacao(), pedidoIn.getValorTotal());
        var itemPedido = itemPedidoMapper.toItemPedido(pedido, pedidoIn.getItens());
        pedido.setItens(itemPedido);
        return pedido;

    }

    public PedidoOut toPedidoResponse(Pedido pedido){
        var clienteNome = pedido.getCliente() != null
                ? pedido.getCliente().getNome()
                : null;
        var listaItemPedidoOut = itemPedidoMapper.toItemPedidoResponse(pedido.getItens());
        return clienteNome != null
                ? new PedidoResponse(pedido.getId(), clienteNome, pedido.getValorTotal(), listaItemPedidoOut, pedido.getStatus())
                : new PedidoResponse(pedido.getId(), pedido.getValorTotal(), listaItemPedidoOut, pedido.getStatus());
    }
}
