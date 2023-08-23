package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.entities.ItemPedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusPedidoEnum;

import java.math.BigDecimal;
import java.util.List;

public class PedidoResponse extends PedidoOut {
    public PedidoResponse(Long id, String clienteNome, BigDecimal valorTotal, List<ItemPedidoOut> itens, StatusPedidoEnum status) {
        super(id, clienteNome, valorTotal, itens, status);
    }

    public PedidoResponse(Long id, BigDecimal valorTotal, List<ItemPedidoOut> itens, StatusPedidoEnum status) {
        super(id, valorTotal, itens, status);
    }
}
