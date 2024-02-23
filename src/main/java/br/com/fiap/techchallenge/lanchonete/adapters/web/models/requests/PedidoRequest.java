package br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CriaItemPedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CriaPedidoDTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PedidoRequest{


    private List<ItemPedidoRequest> itens;

    public PedidoRequest() {
    }

    public PedidoRequest(List<ItemPedidoRequest> itens) {
        this.itens = itens;
    }

    @NotNull(message = "O campo 'itens' é obrigatório")
    public List<ItemPedidoRequest> getItens() {
        return itens;
    }

    private List<CriaItemPedidoDTO> mapItens() {
        return itens.stream().map(item -> new CriaItemPedidoDTO(item.getProdutoId(), item.getQuantidade()) ).toList();
    }

    public void setItens(List<ItemPedidoRequest> itens) {
        this.itens = itens;
    }

    public CriaPedidoDTO toCriaItemPedidoDTO() {
        return new CriaPedidoDTO(
                mapItens()
        );
    }
}
