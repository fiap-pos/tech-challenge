package br.com.fiap.techchallenge.lanchonete.core.port.in;

public interface BuscarPedidoPorIdInputPort {
    PedidoOut buscarPorId(Long id);
}
