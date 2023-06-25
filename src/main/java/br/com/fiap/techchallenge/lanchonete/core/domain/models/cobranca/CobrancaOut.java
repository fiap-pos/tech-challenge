package br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.enums.StatusCobrancaEnum;

import java.math.BigDecimal;

public interface CobrancaOut {

    public Long getId();

    public Long getPedidoId();

    public BigDecimal getValor();

    public StatusCobrancaEnum getStatus();

    public QrCode getQrCode();
}
