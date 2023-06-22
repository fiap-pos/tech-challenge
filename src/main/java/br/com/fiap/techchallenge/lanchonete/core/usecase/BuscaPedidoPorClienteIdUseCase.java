package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaPedidoPorClienteIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaTodosPedidosInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaPedidoPorClienteIdOutputPort;

import java.util.List;

public class BuscaPedidoPorClienteIdUseCase implements BuscaPedidoPorClienteIdInputPort {

    private final BuscaPedidoPorClienteIdOutputPort buscaPedidoPorClienteIdOutputPort;

    public BuscaPedidoPorClienteIdUseCase(BuscaPedidoPorClienteIdOutputPort buscaPedidoPorClienteIdOutputPort) {
        this.buscaPedidoPorClienteIdOutputPort = buscaPedidoPorClienteIdOutputPort;
    }

    @Override
    public List<PedidoOut> buscaPedidosDoCliente(Long clienteid) {
        return buscaPedidoPorClienteIdOutputPort.buscaPedidosDoCliente(clienteid);
    }
}
