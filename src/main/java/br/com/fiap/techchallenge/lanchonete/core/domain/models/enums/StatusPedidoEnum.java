package br.com.fiap.techchallenge.lanchonete.core.domain.models.enums;

public enum StatusPedidoEnum {
    PENDENTE_DE_PAGAMENTO("Aguardando Pagamento"),
    PAGO("Pago"),
    RECEBIDO("Recebido"),
    EM_PREPARACAO("Em preparação"),
    PRONTO("Pronto"),
    FINALIZADO("Finalizado"),
    CANCELADO ("Cancelado");

    private final String descricao;

    StatusPedidoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
