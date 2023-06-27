package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Cliente;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.ItemPedido;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoOut extends PedidoBase{

    public PedidoOut(Long id, StatusPedidoEnum status, LocalDateTime dataCriacao, Cliente cliente, List<ItemPedidoOut> itens) {
        super(id, status, dataCriacao, cliente, itens);
    }
}
