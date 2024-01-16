package br.com.fiap.techchallenge.lanchonete.utils.adapters.web;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.QrCode;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusCobrancaEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;

import java.math.BigDecimal;

public abstract class CobrancaHelper {

    private static final Long ID = 1L;
    private static final Long PEDIDO_ID = 1L;
    private static final BigDecimal VALOR = BigDecimal.valueOf(45.9);
    private static final StatusCobrancaEnum STATUS = StatusCobrancaEnum.PAGO;
    private static final QrCode QR_CODE = new QrCode("e3BlZGlkb0lkOjEsdmFsb3I6NDUuOX0=");

    public static CobrancaDTO getCobrancaDTO() {
        return new CobrancaDTO(ID, PEDIDO_ID, VALOR, STATUS, QR_CODE);
    }
}
