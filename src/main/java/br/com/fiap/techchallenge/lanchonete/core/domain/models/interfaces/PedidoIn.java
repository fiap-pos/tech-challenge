package br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces;

import java.util.List;

public interface PedidoIn {
    Long getClienteId();
    List<ItemPedidoIn> getItens();
}
