package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.dtos.CriaItemPedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CriaPedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ItemPedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoIn;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PedidoRequest implements PedidoIn {

    private Long clienteId;
    private List<ItemPedidoRequest> itens;

    public PedidoRequest() {
    }

    public PedidoRequest(Long clienteId, List<ItemPedidoRequest> itens) {
        this.clienteId = clienteId;
        this.itens = itens;
    }
    public PedidoRequest(List<ItemPedidoRequest> itens) {
        this.itens = itens;
    }


    @Override
    public Long getClienteId() {
        return clienteId;
    }

    @NotNull(message = "O campo 'itens' é obrigatório")
    @Override
    public List<ItemPedidoRequest> getItens() {
        return itens;
    }


    private List<CriaItemPedidoDTO> mapItens() {
        return itens.stream().map(item -> new CriaItemPedidoDTO(item.getProdutoId(), item.getQuantidade()) ).toList();
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public void setItens(List<ItemPedidoRequest> itens) {
        this.itens = itens;
    }

    public CriaPedidoDTO toCriaItemPedidoDTO() {
        return new CriaPedidoDTO(
                clienteId,
                mapItens()
        );
    }
}
