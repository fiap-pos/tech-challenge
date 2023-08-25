package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ClienteJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.PedidoJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers.ClienteMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers.PedidoMapper;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.exceptions.EntityNotFoundException;
import br.com.fiap.techchallenge.lanchonete.core.entities.Pedido;
import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoRepository implements CriaPedidoOutputPort, AtualizaStatusPedidoOutputPort,
        BuscaTodosPedidosOutputPort, BuscarPedidoPorIdOutputPort, BuscaTodosPedidosPorStatusOutputPort {
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
    public List<PedidoDTO> buscarTodos() {
        var listaPedidos = pedidoJpaRepository.findAll();

        return listaPedidos.stream().map(pedidoMapper::toPedidoDTO).toList();
    }

    @Override
    public PedidoDTO criar(PedidoDTO pedidoIn) {
        var pedido = pedidoMapper.toPedido(pedidoIn);
        var pedidoSalvo = pedidoJpaRepository.save(pedido);
        return pedidoMapper.toPedidoDTO(pedidoSalvo);
    }

    @Override
    public PedidoDTO atualizarStatus(Long id, StatusPedidoEnum status) {
        var pedidoBuscado = buscarPedidoPorId(id);
        pedidoBuscado.setStatus(status);
        var pedido = pedidoJpaRepository.save(pedidoBuscado);
        return pedidoMapper.toPedidoDTO(pedido);
    }

    @Override
    public PedidoDTO buscarPorId(Long id) {
        var pedidoBuscado = buscarPedidoPorId(id);
        return pedidoMapper.toPedidoDTO(pedidoBuscado);
    }


    private br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Pedido buscarPedidoPorId(Long id){
        return pedidoJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido " + id + " não encontrado"));
    }

    @Override
    public List<PedidoDTO> buscarPedidosPorStatus(StatusPedidoEnum status) {
        return pedidoJpaRepository.findByStatus(status).stream()
                .map(pedidoMapper::toPedidoDTO)
                .toList();
    }
}
