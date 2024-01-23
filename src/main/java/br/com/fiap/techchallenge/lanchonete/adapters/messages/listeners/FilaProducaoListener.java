package br.com.fiap.techchallenge.lanchonete.adapters.messages.listeners;

import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaStatusPedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.AtualizaStatusPedidoInputPort;
import br.com.fiap.techchallenge.producao.core.dtos.PedidoDTO;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class FilaProducaoListener {
    private final AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort;

    public FilaProducaoListener(AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort) {
        this.atualizaStatusPedidoInputPort = atualizaStatusPedidoInputPort;
    }

    @SqsListener("${aws.sqs.queues.producao}")
    public void listen(PedidoDTO pedidoDTO) {
        atualizaStatusPedidoInputPort.atualizarStatus(
                pedidoDTO.codigo(),
                new AtualizaStatusPedidoDTO(pedidoDTO.status())
        );
    }
}
