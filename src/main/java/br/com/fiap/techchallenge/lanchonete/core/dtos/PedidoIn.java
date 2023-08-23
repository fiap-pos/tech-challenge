package br.com.fiap.techchallenge.lanchonete.core.dtos;

import java.util.List;

public interface PedidoIn {
    Long getClienteId();
    List<ItemPedidoIn> getItens();
}
