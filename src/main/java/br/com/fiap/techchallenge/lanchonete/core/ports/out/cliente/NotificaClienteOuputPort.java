package br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente;

import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;

public interface NotificaClienteOuputPort {
    void notificaClienteStatusPedido(PedidoDTO pedidoDTO);
}
