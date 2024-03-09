package br.com.fiap.techchallenge.lanchonete.adapters.gateways.mail;

import br.com.fiap.techchallenge.lanchonete.adapters.gateways.mail.mappers.MailMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.mail.models.Mail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;

import static br.com.fiap.techchallenge.lanchonete.utils.PedidoHelper.getPedidoDTO;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;


class MailGatewayTest {

    AutoCloseable mock;

    private MailGateway mailGateway;

    @Mock
    private MailMapper mailMapper;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private OkHttpClient okHttpClient;

    @BeforeEach
    void setUp() {
        this.mock = MockitoAnnotations.openMocks(this);
        this.mailGateway = new MailGateway(
            okHttpClient,
            objectMapper,
            mailMapper
        );
        setGatewayValues(true);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void notificaClienteStatusPedido() throws IOException {
        var pedidoDTO = getPedidoDTO();

        var mail = mock(Mail.class);
        var response = mock(okhttp3.Response.class);

        when(mailMapper.toMailStatusPedido(pedidoDTO, "mailFrom", "mailFromName")).thenReturn(mail);
        when(objectMapper.writeValueAsString(mail)).thenReturn("mailJson");

        mockHttpClient(response);
        when(response.isSuccessful()).thenReturn(true);

        mailGateway.notificaClienteStatusPedido(pedidoDTO);

        verify(mailMapper, times(1)).toMailStatusPedido(pedidoDTO, "mailFrom", "mailFromName");
        verify(objectMapper, times(1)).writeValueAsString(mail);
        verify(okHttpClient, times(1)).newCall(any());
        verify(response, times(1)).isSuccessful();
    }

    @Test
    void logNotificaClienteStatusPedido() throws JsonProcessingException {
        var pedidoDTO = getPedidoDTO();
        var mail = mock(Mail.class);

        setGatewayValues(false);
        when(mailMapper.toMailStatusPedido(pedidoDTO, "mailFrom", "mailFromName")).thenReturn(mail);

        mailGateway.notificaClienteStatusPedido(pedidoDTO);

        verify(mailMapper, times(1)).toMailStatusPedido(pedidoDTO, "mailFrom", "mailFromName");
        verify(mailMapper, times(1)).toMailStatusPedido(pedidoDTO, "mailFrom", "mailFromName");
        verify(objectMapper, times(1)).writeValueAsString(mail);
        verify(okHttpClient, times(0)).newCall(any());
    }

    @Test
    void deveriaTratarIoException() throws IOException {
        var pedidoDTO = getPedidoDTO();

        var mail = mock(Mail.class);
        var response = mock(okhttp3.Response.class);

        when(mailMapper.toMailStatusPedido(pedidoDTO, "mailFrom", "mailFromName")).thenReturn(mail);
        when(objectMapper.writeValueAsString(mail)).thenReturn("mailJson");

        var mockedCall = Mockito.mock(Call.class);
        when(okHttpClient.newCall(any(Request.class))).thenReturn(mockedCall);
        when(mockedCall.execute()).thenThrow(new IOException());

        assertDoesNotThrow(() -> mailGateway.notificaClienteStatusPedido(pedidoDTO));

        verify(mailMapper, times(1)).toMailStatusPedido(pedidoDTO, "mailFrom", "mailFromName");
        verify(objectMapper, times(1)).writeValueAsString(mail);
        verify(okHttpClient, times(1)).newCall(any());
        verify(mockedCall, times(1)).execute();
        verify(response, times(0)).isSuccessful();
    }

    @Test
    void deveriaTratarJsonProcessingException() throws IOException {
        var pedidoDTO = getPedidoDTO();
        var mail = mock(Mail.class);

        when(mailMapper.toMailStatusPedido(pedidoDTO, "mailFrom", "mailFromName")).thenReturn(mail);
        when(objectMapper.writeValueAsString(mail)).thenThrow(new JsonProcessingException("error") {});

        assertDoesNotThrow(() -> mailGateway.notificaClienteStatusPedido(pedidoDTO));

        verify(mailMapper, times(1)).toMailStatusPedido(pedidoDTO, "mailFrom", "mailFromName");
        verify(objectMapper, times(1)).writeValueAsString(mail);
        verify(okHttpClient, times(0)).newCall(any());
    }

    @Test
    void deveriaTratarJsonProcessingExceptionLogNotifica() throws IOException {
        var pedidoDTO = getPedidoDTO();
        var mail = mock(Mail.class);

        setGatewayValues(false);
        when(mailMapper.toMailStatusPedido(pedidoDTO, "mailFrom", "mailFromName")).thenReturn(mail);
        when(objectMapper.writeValueAsString(mail)).thenThrow(new JsonProcessingException("error") {});

        assertDoesNotThrow(() -> mailGateway.notificaClienteStatusPedido(pedidoDTO));

        verify(mailMapper, times(1)).toMailStatusPedido(pedidoDTO, "mailFrom", "mailFromName");
        verify(objectMapper, times(1)).writeValueAsString(mail);
    }

    private void setGatewayValues(Boolean mailApiEnabled) {
        ReflectionTestUtils.setField(mailGateway, "mailApiUrl", "http://localhost:8080");
        ReflectionTestUtils.setField(mailGateway, "mailApiKey", "asdf-123456");
        ReflectionTestUtils.setField(mailGateway, "mailFrom", "mailFrom");
        ReflectionTestUtils.setField(mailGateway, "mailFromName", "mailFromName");
        ReflectionTestUtils.setField(mailGateway, "mailApiEnabled", mailApiEnabled);
    }

    private void mockHttpClient(Response response) throws IOException {
        var mockedCall = Mockito.mock(Call.class);
        when(okHttpClient.newCall(any(Request.class))).thenReturn(mockedCall);
        when(mockedCall.execute()).thenReturn(response);
    }
}