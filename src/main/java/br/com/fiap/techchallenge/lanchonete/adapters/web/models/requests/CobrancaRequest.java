//package br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests;
//
//import br.com.fiap.techchallenge.lanchonete.core.domain.entities.QrCode;
//import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
//import br.com.fiap.techchallenge.lanchonete.core.dtos.CriaCobrancaDTO;
//import jakarta.validation.constraints.NotNull;
//
//import java.math.BigDecimal;
//
//public class CobrancaRequest {
//    private Long id;
//    private Long pedidoId;
//    private BigDecimal valor;
//    private StatusPedidoEnum status;
//
//    public CobrancaRequest() {}
//
//    public CobrancaRequest(Long id, Long pedidoId, BigDecimal valor, StatusPedidoEnum status) {
//        this.id = id;
//        this.pedidoId = pedidoId;
//        this.valor = valor;
//        this.status = status;
//    }
//
//    @NotNull(message = "O campo pedidoId é obrigatório")
//    public Long getPedidoId() {
//        return pedidoId;
//    }
//
//    public void setPedidoId(Long pedidoId) {
//        this.pedidoId = pedidoId;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public BigDecimal getValor() {
//        return valor;
//    }
//
//    public void setValor(BigDecimal valor) {
//        this.valor = valor;
//    }
//
//    public StatusPedidoEnum getStatus() {
//        return status;
//    }
//
//    public void setStatus(StatusPedidoEnum status) {
//        this.status = status;
//    }
//
//    public CriaCobrancaDTO toCriaCobrancaDTO() {
//        return new CriaCobrancaDTO(pedidoId);
//    }
//}
