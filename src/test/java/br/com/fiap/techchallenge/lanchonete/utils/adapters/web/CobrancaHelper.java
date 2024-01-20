package br.com.fiap.techchallenge.lanchonete.utils.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Cobranca;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.QrCode;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusCobrancaEnum;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CriaCobrancaDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.StatusPagamentoDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class CobrancaHelper {

    private static final Long ID = 1L;
    private static final Long PEDIDO_ID = 1L;
    private static final BigDecimal VALOR = BigDecimal.valueOf(45.9);
    private static final StatusCobrancaEnum STATUS = StatusCobrancaEnum.PAGO;
    private static final QrCode QR_CODE = new QrCode("e3BlZGlkb0lkOjEsdmFsb3I6NDUuOX0=");

    private static final LocalDateTime CREATED_AT = LocalDateTime.MAX;
    private static final LocalDateTime UPDATED_AT = LocalDateTime.MAX;

    public static CobrancaDTO getCobrancaDTO() {
        return new CobrancaDTO(ID, PEDIDO_ID, VALOR, STATUS, QR_CODE);
    }

    public static Cobranca getCobranca() {
        return new Cobranca(ID, PEDIDO_ID, STATUS, VALOR, QR_CODE.getDecodedBase64Value(), CREATED_AT, UPDATED_AT);
    }

    public static CriaCobrancaDTO getCriaCobrancaDTO() {
        return new CriaCobrancaDTO(1L);
    }

    public static StatusPagamentoDTO getStatusPagamentoPagoDTO() {
        return new StatusPagamentoDTO(1L, StatusPedidoEnum.RECEBIDO.getDescricao(), StatusCobrancaEnum.PAGO);
    }
}
