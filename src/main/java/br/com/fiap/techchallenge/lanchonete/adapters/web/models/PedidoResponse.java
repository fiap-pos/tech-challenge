package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;

import java.math.BigDecimal;
import java.util.List;

public class PedidoResponse extends PedidoOut {
    public PedidoResponse(Long id, BigDecimal valorTotal, List<ItemPedidoOut> itens, StatusPedidoEnum status) {
        super(id, valorTotal, itens, status);
    }

}
