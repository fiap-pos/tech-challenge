package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.PedidoJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper.PedidoMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Pedido;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;
import br.com.fiap.techchallenge.lanchonete.core.domain.exception.EntityNotFoundException;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.out.AtualizaStatusPedidoOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaPedidoPorClienteIdOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaTodosPedidosOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.CriaPedidoOutputPort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoRepository implements  CriaPedidoOutputPort, AtualizaStatusPedidoOutputPort,
        BuscaTodosPedidosOutputPort, BuscaPedidoPorClienteIdOutputPort {
    private final PedidoMapper pedidoMapper;
    private final PedidoJpaRepository pedidoJpaRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoRepository(PedidoMapper pedidoMapper, PedidoJpaRepository pedidoJpaRepository,
                            ProdutoRepository produtoRepository) {
        this.pedidoMapper = pedidoMapper;
        this.pedidoJpaRepository = pedidoJpaRepository;
        this.produtoRepository = produtoRepository;
    }

    public Pedido buscarPedidoPorId(Long id){
        return pedidoJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido com id " + id + " não encontrado!"));
    }

    @Override
    public PedidoOut criar(PedidoIn pedidoIn) {
        Produto produto = buscaProdutoPorId(pedidoIn.getProdutoid());
        Pedido pedido = pedidoMapper.toPedido(produto, pedidoIn);
        Pedido pedidoSalvo = pedidoJpaRepository.save(pedido);
        return pedidoMapper.toPedidoResponse(pedidoSalvo);
    }
    @Override
    public PedidoOut atualizarStatus(PedidoIn pedidoIn) {
        Produto produto = buscaProdutoPorId(pedidoIn.getProdutoid());
        Pedido pedido = pedidoMapper.toPedido(produto, pedidoIn);
        Pedido pedidoBuscado = pedidoJpaRepository.findById(pedido.getId())
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
        pedidoBuscado.setStatus(pedido.getStatus());
        Pedido pedidoAtualizado = pedidoJpaRepository.save(pedidoBuscado);

        return pedidoMapper.toPedidoResponse(pedidoAtualizado);
    }

    @Override
    public List<PedidoOut> buscarTodos() {
        return pedidoJpaRepository.findAll()
                .stream()
                .map(pedidoMapper::toPedidoResponse)
                .toList();
    }

    private Produto buscaProdutoPorId(Long produtoid){
        return produtoRepository.buscaProdutoPorId(produtoid);
    }

    @Override
    public List<PedidoOut> buscaPedidosDoCliente(Long clienteid) {
        return pedidoJpaRepository.findAllByClienteid(clienteid)
                .stream().map(pedidoMapper::toPedidoResponse)
                .toList();
    }
}
