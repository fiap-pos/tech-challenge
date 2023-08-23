package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.exceptions.BadRequestException;
import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaStatusIn;
import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusCobrancaEnum;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.AtualizaStatusCobrancaInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.AtualizaStatusCobrancaOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.AtualizaStatusPedidoOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.BuscaCobrancaOutputPort;

public class AtualizaStatusCobrancaUseCase implements AtualizaStatusCobrancaInputPort {

    private final BuscaCobrancaOutputPort buscaCobrancaOutputPort;

    private final AtualizaStatusCobrancaOutputPort atualizaStatusCobrancaOutputPort;

    private final AtualizaStatusPedidoOutputPort atualizaStatusPedidoOutputPort;

    public AtualizaStatusCobrancaUseCase(
        BuscaCobrancaOutputPort buscaCobrancaOutputPort,
        AtualizaStatusCobrancaOutputPort atualizaStatusCobrancaOutputPort,
        AtualizaStatusPedidoOutputPort atualizaStatusPedidoOutputPort
    ) {
        this.buscaCobrancaOutputPort = buscaCobrancaOutputPort;
        this.atualizaStatusCobrancaOutputPort = atualizaStatusCobrancaOutputPort;
        this.atualizaStatusPedidoOutputPort = atualizaStatusPedidoOutputPort;
    }
    @Override
    public CobrancaOut atualizarStatus(Long id, CobrancaStatusIn cobrancaStatusIn) {
        var cobrancaOut = buscaCobrancaOutputPort.buscarPorId(id);
        if (cobrancaOut.getStatus() != StatusCobrancaEnum.PENDENTE) {
            throw new BadRequestException("Cobranca "+id+" não pode mais ser atualizada.");
        }
        var novoStatusPedido = getStatusPedido(cobrancaStatusIn.getStatus());
        if (novoStatusPedido != null) {
            atualizaStatusPedidoOutputPort.atualizarStatus(cobrancaOut.getPedidoId(), novoStatusPedido);
        }
        return atualizaStatusCobrancaOutputPort.atualizarStatus(id, cobrancaStatusIn);
    }

    private StatusPedidoEnum getStatusPedido(StatusCobrancaEnum statusCobranca) {
        return switch(statusCobranca) {
            case PAGO -> StatusPedidoEnum.PAGO;
            case CANCELADO -> StatusPedidoEnum.CANCELADO;
            default -> null;
        };
    }


}
