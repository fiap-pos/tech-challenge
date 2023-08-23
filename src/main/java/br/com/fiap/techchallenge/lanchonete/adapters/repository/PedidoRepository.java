package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ClienteJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.PedidoJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers.ClienteMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers.PedidoMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Pedido;
import br.com.fiap.techchallenge.lanchonete.core.exceptions.EntityNotFoundException;
import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CriaPedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoRepository implements  CriaPedidoOutputPort, AtualizaStatusPedidoOutputPort,
        BuscaTodosPedidosOutputPort, BuscarPedidoPorIdOutputPort, BuscaTodosPedidosPorStatusOutputPort{
    private final PedidoMapper pedidoMapper;
    private final ClienteMapper clienteMapper;
    private final ClienteJpaRepository clienteJpaRepository;
    private final PedidoJpaRepository pedidoJpaRepository;

    public PedidoRepository(PedidoMapper pedidoMapper, PedidoJpaRepository pedidoJpaRepository,
                            ClienteMapper clienteMapper, ClienteJpaRepository clienteJpaRepository) {
        this.pedidoMapper = pedidoMapper;
        this.clienteMapper = clienteMapper;
        this.clienteJpaRepository = clienteJpaRepository;
        this.pedidoJpaRepository = pedidoJpaRepository;
    }

    @Override
    public List<PedidoOut> buscarTodos() {
        var listaPedidos = pedidoJpaRepository.findAll();

        return listaPedidos.stream().map(pedidoMapper::toPedidoResponse).toList();
    }

    @Override
    public PedidoOut criar(CriaPedidoIn pedidoIn) {
        var cliente = pedidoIn.getClienteId() != null
                ? clienteJpaRepository.findById(pedidoIn.getClienteId())
                .orElseThrow(
                        ()-> new EntityNotFoundException("Cliente " + pedidoIn.getClienteId() + " não encontrado"))
                : null;
        var pedido = pedidoMapper.toPedido(pedidoIn);
        var pedidoSalvo = pedidoJpaRepository.save(pedido);
        return pedidoMapper.toPedidoResponse(pedidoSalvo);
    }

    @Override
    public PedidoOut atualizarStatus(Long id, StatusPedidoEnum status) {
        var pedidoBuscado = buscarPedidoPorId(id);
        pedidoBuscado.setStatus(status);
        var pedido = pedidoJpaRepository.save(pedidoBuscado);
        return pedidoMapper.toPedidoResponse(pedido);
    }

    @Override
    public PedidoOut buscarPorId(Long id) {
        var pedidoBuscado = buscarPedidoPorId(id);
        return pedidoMapper.toPedidoResponse(pedidoBuscado);
    }


    private Pedido buscarPedidoPorId(Long id){
        return pedidoJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido " + id + " não encontrado"));
    }

    @Override
    public List<PedidoOut> buscarPedidosPorStatus(StatusPedidoEnum status) {
        return pedidoJpaRepository.findByStatus(status).stream()
                .map(pedidoMapper::toPedidoResponse)
                .toList();
    }
}
