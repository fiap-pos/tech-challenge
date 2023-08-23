package br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ProdutoJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.ItemPedido;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Pedido;
import br.com.fiap.techchallenge.lanchonete.core.exceptions.EntityNotFoundException;
import br.com.fiap.techchallenge.lanchonete.core.entities.CriaItemPedido;
import br.com.fiap.techchallenge.lanchonete.core.entities.ItemPedidoOut;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemPedidoMapper {

    private final ProdutoJpaRepository produtoJpaRepository;

    public ItemPedidoMapper(ProdutoJpaRepository produtoJpaRepository) {
        this.produtoJpaRepository = produtoJpaRepository;
    }

    public List<ItemPedido> toItemPedido(Pedido pedido, List<CriaItemPedido> criaItemPedido){

        var listaItemPedido = new ArrayList<ItemPedido>();

        criaItemPedido.forEach(item -> {
            var produto = produtoJpaRepository.findById(item.getProdutoId())
                    .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
            var itemPedido = new ItemPedido(pedido, produto, item.getQuantidade(), item.getValorUnitario());
            listaItemPedido.add(itemPedido);
        });

        return listaItemPedido;
    }

    public List<ItemPedidoOut> toItemPedidoResponse(List<ItemPedido> itens){
        var listaItemPedidoOut = new ArrayList<ItemPedidoOut>();

        itens.forEach( item -> {
            var itemPedidoOut = new ItemPedidoOut(item.getQuantidade(), item.getValorUnitario(), item.getProduto().getNome());
            listaItemPedidoOut.add(itemPedidoOut);
        });

        return listaItemPedidoOut;
    }
}
