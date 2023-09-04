package br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ProdutoJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.ItemPedido;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Pedido;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ItemPedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.domain.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemPedidoMapper {

    private final ProdutoJpaRepository produtoJpaRepository;

    public ItemPedidoMapper(ProdutoJpaRepository produtoJpaRepository) {
        this.produtoJpaRepository = produtoJpaRepository;
    }

    public List<ItemPedido> toItemPedido(Pedido pedido, List<ItemPedidoDTO> criaItemPedido){

        var listaItemPedido = new ArrayList<ItemPedido>();

        criaItemPedido.forEach(item -> {
            var produto = produtoJpaRepository.findById(item.produtoId())
                    .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
            var itemPedido = new ItemPedido(pedido, produto, item.quantidade(), item.valorUnitario());
            listaItemPedido.add(itemPedido);
        });

        return listaItemPedido;
    }

    public List<ItemPedidoDTO> toItemPedidoResponse(List<ItemPedido> itens){
        var listaItemPedidoOut = new ArrayList<ItemPedidoDTO>();

        itens.forEach( item -> {
            var itemPedidoOut = new ItemPedidoDTO(
                    item.getProduto().getId(),
                    item.getProduto().getNome(),
                    item.getProduto().getDescricao(),
                    item.getValorUnitario(),
                    item.getQuantidade()
            );
            listaItemPedidoOut.add(itemPedidoOut);
        });

        return listaItemPedidoOut;
    }
}
