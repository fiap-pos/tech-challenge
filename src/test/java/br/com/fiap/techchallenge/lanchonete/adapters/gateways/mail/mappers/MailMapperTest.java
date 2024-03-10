package br.com.fiap.techchallenge.lanchonete.adapters.gateways.mail.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.gateways.mail.models.Mail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static br.com.fiap.techchallenge.lanchonete.utils.PedidoHelper.getPedidoDTO;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MailMapperTest {
    private MailMapper mailMapper;

    @BeforeEach
    void setUp() {
        this.mailMapper = new MailMapper();
    }

    @Test
    void toMail() {

        var pedidoDTO = getPedidoDTO();

        var mail = mailMapper.toMailStatusPedido(pedidoDTO, "E-mail destinatário", "Nome destinatário");

        assertThat(mail).isNotNull().isInstanceOf(Mail.class);
        assertThat(mail.from().email()).isEqualTo("E-mail destinatário");
        assertThat(mail.from().name()).isEqualTo("Nome destinatário");

        var mailTo = mail.to().stream().findFirst().get();
        assertThat(mailTo.email()).isEqualTo(pedidoDTO.cliente().email());
        assertThat(mailTo.name()).isEqualTo(pedidoDTO.getNomeCliente());

        assertThat(mail.subject()).isEqualTo("Lanchonete 61: Pedido aguardando pagamento!");
        assertThat(mail.text()).isEqualTo("Olá Cliente 1 seu pedido está aguardando pagamento!");
    }
}