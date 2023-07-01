package br.com.fiap.techchallenge.lanchonete.core.port.out;

public interface BuscarPedidoPorIdOutputPort {

    PedidoOut buscarPorId(Long id);
}
