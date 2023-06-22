package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoBase;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoOut;

import java.math.BigDecimal;
import java.util.List;

public class PedidoResponse extends PedidoOut {
    public PedidoResponse() {
    }

    public PedidoResponse(Long id, StatusPedidoEnum status, Long clienteId, Long produtoid, Integer quantidade) {
        setId(id);
        setStatus(status);
        setClienteId(clienteId);
        setProdutoid(produtoid);
        setQuantidade(quantidade);
    }
}
