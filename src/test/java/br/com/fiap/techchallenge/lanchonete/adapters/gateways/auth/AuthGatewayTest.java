package br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth;

import br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.mappers.AuthGatewayMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.models.UserResponse;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.models.UserRole;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

class AuthGatewayTest {

    private AuthGateway authGateway;

    private AutoCloseable mock;

    @Mock
    private AuthGatewayMapper authGatewayMapper;

    private ObjectMapper objectMapper;

    @Mock
    private OkHttpClient okHttpClient;


    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        mock = MockitoAnnotations.openMocks(this);
        this.authGateway = new AuthGateway(
                objectMapper,
                okHttpClient,
                authGatewayMapper
        );

        ReflectionTestUtils.setField(authGateway, "authUrl", "http://localhost:8080");
    }

    @AfterEach
    void TearDown() throws Exception {
        mock.close();
    }

    @Test
    void testBuscarPorId() throws IOException, NullPointerException {

        var clienteDTO = getClienteDTO();
        var mockedResponse = Mockito.mock(Response.class);
        var mockedBody = Mockito.mock(ResponseBody.class);

        when(mockedResponse.body()).thenReturn(mockedBody);
        when(mockedResponse.isSuccessful()).thenReturn(true);
        when(mockedBody.string()).thenReturn(objectMapper.writeValueAsString(getUserResponse(UserRole.CUSTOMER)));
        mockHttpClient(mockedResponse);

        when(authGatewayMapper.toClienteDTO(any(UserResponse.class))).thenReturn(clienteDTO);

        var result = authGateway.buscarPorId("id");

        assertThat(result)
                .isNotNull()
                .isEqualTo(clienteDTO);
    }

    @Test
    void testBuscarPorIdDeveRetornarNullQuandoUsuarioForGuest() throws IOException, NullPointerException {

        var mockedResponse = Mockito.mock(Response.class);
        var mockedBody = Mockito.mock(ResponseBody.class);

        when(mockedResponse.body()).thenReturn(mockedBody);
        when(mockedResponse.isSuccessful()).thenReturn(true);
        when(mockedBody.string()).thenReturn(objectMapper.writeValueAsString(getUserResponse(UserRole.GUEST)));
        mockHttpClient(mockedResponse);

        var result = authGateway.buscarPorId("id");

        assertThat(result)
                .isNull();

        verifyNoInteractions(authGatewayMapper);
    }

    @Test
    void testBuscaPorIdDeveLancarRuntimeExceptionQuandoRespostaForErro() throws IOException, NullPointerException {

        var mockedResponse = Mockito.mock(Response.class);
        var mockedBody = Mockito.mock(ResponseBody.class);

        when(mockedResponse.body()).thenReturn(mockedBody);
        when(mockedResponse.isSuccessful()).thenReturn(false);
        mockHttpClient(mockedResponse);

        assertThatThrownBy(() -> authGateway.buscarPorId("id"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Falha ao buscar usuário");
    }

    @Test
    void testBuscaPorIdDeveLancarRuntimeExceptionQuandoARespostaForInvalida() throws IOException, NullPointerException {
            var mockedResponse = Mockito.mock(Response.class);
            var mockedBody = Mockito.mock(ResponseBody.class);

            when(mockedResponse.body()).thenReturn(mockedBody);
            when(mockedResponse.isSuccessful()).thenReturn(true);
            when(mockedBody.string()).thenReturn("invalid json");
            mockHttpClient(mockedResponse);

            assertThatThrownBy(() -> authGateway.buscarPorId("id"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("Falha ao buscar usuário por id");
    }

    @Test
    void testBuscarPorToken() throws IOException, NullPointerException {
        var clienteDTO = getClienteDTO();
        var mockedResponse = Mockito.mock(Response.class);
        var mockedBody = Mockito.mock(ResponseBody.class);

        when(mockedResponse.body()).thenReturn(mockedBody);
        when(mockedResponse.isSuccessful()).thenReturn(true);
        when(mockedBody.string()).thenReturn(objectMapper.writeValueAsString(getUserResponse(UserRole.CUSTOMER)));
        mockHttpClient(mockedResponse);

        when(authGatewayMapper.toClienteDTO(any(UserResponse.class))).thenReturn(clienteDTO);

        var result = authGateway.buscarPorToken("token");

        assertThat(result)
                .isNotNull()
                .isEqualTo(clienteDTO);
    }

    @Test
    void testBuscarPorTokenDeveRetornarNullQuandoUsuarioForGuest() throws IOException, NullPointerException {
        var mockedResponse = Mockito.mock(Response.class);
        var mockedBody = Mockito.mock(ResponseBody.class);

        when(mockedResponse.body()).thenReturn(mockedBody);
        when(mockedResponse.isSuccessful()).thenReturn(true);
        when(mockedBody.string()).thenReturn(objectMapper.writeValueAsString(getUserResponse(UserRole.GUEST)));
        mockHttpClient(mockedResponse);

        var result = authGateway.buscarPorToken("token");

        assertThat(result)
                .isNull();

        verifyNoInteractions(authGatewayMapper);
    }

    @Test
    void testBuscaPorTokenDeveLancarRuntimeExceptionQuandoRespostaForErro() throws IOException, NullPointerException {
        var mockedResponse = Mockito.mock(Response.class);
        var mockedBody = Mockito.mock(ResponseBody.class);

        when(mockedResponse.body()).thenReturn(mockedBody);
        when(mockedResponse.isSuccessful()).thenReturn(false);
        mockHttpClient(mockedResponse);

        assertThatThrownBy(() -> authGateway.buscarPorToken("token"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Falha ao buscar usuário");
    }

    @Test
    void testBuscaPorTokenDeveLancarRuntimeExceptionQuandoARespostaForInvalida() throws IOException, NullPointerException {
        var mockedResponse = Mockito.mock(Response.class);
        var mockedBody = Mockito.mock(ResponseBody.class);

        when(mockedResponse.body()).thenReturn(mockedBody);
        when(mockedResponse.isSuccessful()).thenReturn(true);
        when(mockedBody.string()).thenReturn("invalid json");
        mockHttpClient(mockedResponse);

        assertThatThrownBy(() -> authGateway.buscarPorToken("token"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Falha ao buscar usuário por token");
    }

    private void mockHttpClient(Response response) throws IOException {
        var mockedCall = Mockito.mock(Call.class);
        when(okHttpClient.newCall(any(Request.class))).thenReturn(mockedCall);
        when(mockedCall.execute()).thenReturn(response);
    }

    private UserResponse getUserResponse(UserRole role) {
        return new UserResponse(
                "id",
                "name",
                "email",
                "password",
                List.of(role)
        );
    }

    private ClienteDTO getClienteDTO() {
        return new ClienteDTO(
                "id",
                "name",
                "email"
        );
    }
}
