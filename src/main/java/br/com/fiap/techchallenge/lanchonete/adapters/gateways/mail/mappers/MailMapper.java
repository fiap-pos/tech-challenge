package br.com.fiap.techchallenge.lanchonete.adapters.gateways.mail.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.gateways.mail.models.Mail;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.mail.models.MailId;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MailMapper {

    public Mail toMailStatusPedido(PedidoDTO pedidoDTO, String mailFrom, String mailFromName) {
        var from = new MailId(mailFrom, mailFromName);
        var to = new MailId(pedidoDTO.cliente().email(), pedidoDTO.getNomeCliente());
        var subject = getSubjectStatusPedido(pedidoDTO.status());
        var text = getTextoStatusPedido(pedidoDTO.getNomeCliente(), pedidoDTO.status());

        return new Mail(from, List.of(to), subject, text);
    }

    private String getSubjectStatusPedido(StatusPedidoEnum status) {
        return "Lanchonete 61: Pedido " + status.getDescricao().toLowerCase() + "!";
    }

    private String getTextoStatusPedido(String cliente, StatusPedidoEnum status) {
        return "Olá " + cliente + " seu pedido está " + status.getDescricao().toLowerCase() + "!";
    }
}
