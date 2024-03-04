package br.com.fiap.techchallenge.lanchonete.core.usecases.pedido;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.AtualizaStatusPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.AtualizaStatusPedidoOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.EnviaPedidoFilaProducaoOutputPort;

public class AtualizaStatusPedidoUseCase implements AtualizaStatusPedidoInputPort {
    private final AtualizaStatusPedidoOutputPort atualizaStatusPedidoOutputPort;
    private final EnviaPedidoFilaProducaoOutputPort enviaPedidoFilaProducaoOutputPort;

    public AtualizaStatusPedidoUseCase(AtualizaStatusPedidoOutputPort atualizaStatusPedidoOutputPort, EnviaPedidoFilaProducaoOutputPort enviaPedidoFilaProducaoOutputPort) {
        this.atualizaStatusPedidoOutputPort = atualizaStatusPedidoOutputPort;
        this.enviaPedidoFilaProducaoOutputPort = enviaPedidoFilaProducaoOutputPort;
    }

    @Override
    public PedidoDTO atualizarStatus(Long id, StatusPedidoEnum status) {
        var pedidoDTO = atualizaStatusPedidoOutputPort.atualizarStatus(id, status);
        if (pedidoDTO.status().equals(StatusPedidoEnum.PAGO)) {
            enviaPedidoFilaProducaoOutputPort.enviarPedido(pedidoDTO);
        }
        return pedidoDTO;
    }
}
