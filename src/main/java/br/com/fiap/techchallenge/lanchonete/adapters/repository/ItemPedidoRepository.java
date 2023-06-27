package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ItemPedidoJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper.ItemPedidoMapper;
import br.com.fiap.techchallenge.lanchonete.core.domain.exception.EntityNotFoundException;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscarItensPorPedidoIdOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.EditarItemPedidoOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.SalvarItensPedidoOutputPort;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ItemPedidoRepository implements SalvarItensPedidoOutputPort, BuscarItensPorPedidoIdOutputPort,
        EditarItemPedidoOutputPort {
    private final ItemPedidoJpaRepository jpaRepository;
    private final ItemPedidoMapper mapper;

    public ItemPedidoRepository(ItemPedidoJpaRepository jpaRepository,ItemPedidoMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }


    @Override
    public List<ItemPedidoOut> buscarItensDoPedido(Long pedidoid) {
        var listaItens = jpaRepository.findAllByPedidoId(pedidoid);
        return listaItens.stream()
                .map(mapper::toItemPedidoResponse)
                .toList();
    }

    @Override
    public ItemPedidoOut editarItem(ItemPedidoIn itemPedidoIn) {
        return jpaRepository.findById(itemPedidoIn.getId())
                .map(mapper::toItemPedidoResponse)
                .orElseThrow(() -> new EntityNotFoundException("Item não encontrado"));
    }

    @Override
    public ItemPedidoOut salvarItem(ItemPedidoIn itemPedidoIn) {
        var itemPedido = mapper.toItemPedido(itemPedidoIn);
        var itemPedidoSalvo = jpaRepository.save(itemPedido);
        return mapper.toItemPedidoResponse(itemPedidoSalvo);
    }
}
