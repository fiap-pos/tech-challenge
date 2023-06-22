package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoBase;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoIn;

import java.math.BigDecimal;
import java.util.List;

public class PedidoRequest extends PedidoIn {

    public PedidoRequest() {
    }

    public PedidoRequest(StatusPedidoEnum status, Long clienteid, Long produtoid, Integer quantidade) {
        setClienteId(clienteid);
        setStatus(status);
        setProdutoid(produtoid);
        setQuantidade(quantidade);
    }

}
