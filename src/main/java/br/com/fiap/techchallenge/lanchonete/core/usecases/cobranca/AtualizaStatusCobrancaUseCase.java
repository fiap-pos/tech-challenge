package br.com.fiap.techchallenge.lanchonete.core.usecases.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.domain.exceptions.BadRequestException;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaStatusCobrancaDTO;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusCobrancaEnum;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cobranca.AtualizaStatusCobrancaInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cobranca.AtualizaStatusCobrancaOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.AtualizaStatusPedidoOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cobranca.BuscaCobrancaOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.EnviaPedidoFilaProducaoOutputPort;

public class AtualizaStatusCobrancaUseCase implements AtualizaStatusCobrancaInputPort {

    private final BuscaCobrancaOutputPort buscaCobrancaOutputPort;

    private final AtualizaStatusCobrancaOutputPort atualizaStatusCobrancaOutputPort;

    private final AtualizaStatusPedidoOutputPort atualizaStatusPedidoOutputPort;

    private final EnviaPedidoFilaProducaoOutputPort enviaPedidoFilaProducaoOutputPort;

    public AtualizaStatusCobrancaUseCase(
        BuscaCobrancaOutputPort buscaCobrancaOutputPort,
        AtualizaStatusCobrancaOutputPort atualizaStatusCobrancaOutputPort,
        AtualizaStatusPedidoOutputPort atualizaStatusPedidoOutputPort,
        EnviaPedidoFilaProducaoOutputPort enviaPedidoFilaProducaoOutputPort
    ) {
        this.buscaCobrancaOutputPort = buscaCobrancaOutputPort;
        this.atualizaStatusCobrancaOutputPort = atualizaStatusCobrancaOutputPort;
        this.atualizaStatusPedidoOutputPort = atualizaStatusPedidoOutputPort;
        this.enviaPedidoFilaProducaoOutputPort = enviaPedidoFilaProducaoOutputPort;
    }
    @Override
    public CobrancaDTO atualizarStatus(Long id, AtualizaStatusCobrancaDTO cobrancaStatusIn) {
        var cobrancaOut = buscaCobrancaOutputPort.buscarPorId(id);
        if (cobrancaOut.status() != StatusCobrancaEnum.PENDENTE) {
            throw new BadRequestException("Cobranca "+id+" não pode mais ser atualizada.");
        }
        var novoStatusPedido = getStatusPedido(cobrancaStatusIn.status());

        if (novoStatusPedido != null) {
            var pedidoDTO = atualizaStatusPedidoOutputPort.atualizarStatus(cobrancaOut.pedidoId(), novoStatusPedido);
            if (novoStatusPedido == StatusPedidoEnum.RECEBIDO) {
                enviaPedidoFilaProducaoOutputPort.enviarPedido(pedidoDTO);
            }
            return atualizaStatusCobrancaOutputPort.atualizarStatus(id, cobrancaStatusIn);
        }

        return cobrancaOut;
    }

    private StatusPedidoEnum getStatusPedido(StatusCobrancaEnum statusCobranca) {
        return switch(statusCobranca) {
            case PAGO -> StatusPedidoEnum.RECEBIDO;
            case CANCELADO, RECUSADO -> StatusPedidoEnum.CANCELADO;
            default -> null;
        };
    }
}
