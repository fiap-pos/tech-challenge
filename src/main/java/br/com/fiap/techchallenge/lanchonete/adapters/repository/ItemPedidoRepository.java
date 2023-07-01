package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ItemPedidoRepository /*implements SalvarItensPedidoOutputPort, BuscarItensPorPedidoIdOutputPort,
        EditarItemPedidoOutputPort*/ {
    /*private final ItemPedidoJpaRepository jpaRepository;
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
    public ItemPedidoOut editarItem(CriaItemPedido itemPedidoIn) {
        return jpaRepository.findById(itemPedidoIn.getProdutoId())
                .map(mapper::toItemPedidoResponse)
                .orElseThrow(() -> new EntityNotFoundException("Item não encontrado"));
    }

    @Override
    public ItemPedidoOut salvarItem(CriaItemPedido itemPedidoIn) {
        var itemPedido = mapper.toItemPedido(itemPedidoIn);
        var itemPedidoSalvo = jpaRepository.save(itemPedido);
        return mapper.toItemPedidoResponse(itemPedidoSalvo);
    }*/
}
