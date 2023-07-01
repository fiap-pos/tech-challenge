package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.PedidoJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper.PedidoMapper;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.CriaItemPedido;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.PedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.port.out.*;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoRepository implements  CriaPedidoOutputPort/*, AtualizaStatusPedidoOutputPort,
        BuscaTodosPedidosOutputPort, BuscarPedidoPorIdOutputPort,EditarPedidoOutputPort, RemoverPedidoOutputPort*/ {
    private final PedidoMapper pedidoMapper;
    private final PedidoJpaRepository pedidoJpaRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    public PedidoRepository(PedidoMapper pedidoMapper, PedidoJpaRepository pedidoJpaRepository,
                            ItemPedidoRepository itemPedidoRepository) {
        this.pedidoMapper = pedidoMapper;
        this.pedidoJpaRepository = pedidoJpaRepository;
        this.itemPedidoRepository = itemPedidoRepository;
    }

    /*@Override
    public List<PedidoOut> buscarTodos() {
        var listaPedidos = pedidoJpaRepository.findAll();

        return listaPedidos.stream().map(pedidoMapper::toPedidoResponse).toList();
    }*/

    @Override
    public PedidoOut criar(PedidoIn pedidoIn) {
        var pedido = pedidoMapper.toPedido(pedidoIn);
        var pedidoSalvo = pedidoJpaRepository.save(pedido);
        itemPedidoRepository.salvarItem((CriaItemPedido) pedidoIn.getItens());
        return pedidoMapper.toPedidoResponse(pedidoSalvo);
    }

    /*@Override
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

    @Override
    public void remover(Long id) {
        pedidoJpaRepository.deleteById(id);
    }

    @Override
    public PedidoOut editar(PedidoIn pedidoIn) {
        buscarPorId(pedidoIn.getId());
        return criar(pedidoIn);
    }

    private Pedido buscarPedidoPorId(Long id){
        return pedidoJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido " + id + " não encontrado"));
    }*/
}
