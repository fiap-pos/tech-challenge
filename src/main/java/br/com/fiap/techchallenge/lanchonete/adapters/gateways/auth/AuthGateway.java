package br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth;

import br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.mappers.AuthGatewayMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.models.UserResponse;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.models.UserRole;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.BuscaClienteOutputPort;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthGateway implements BuscaClienteOutputPort {

    @Value("${services.auth.url}")
    private String authUrl;

    private final ObjectMapper objectMapper;

    private final OkHttpClient okHttpClient;

    private final AuthGatewayMapper authGatewayMapper;

    public AuthGateway(ObjectMapper objectMapper, OkHttpClient okHttpClient, AuthGatewayMapper authGatewayMapper) {
        this.objectMapper = objectMapper;
        this.okHttpClient = okHttpClient;
        this.authGatewayMapper = authGatewayMapper;
    }

    @Override
    public ClienteDTO buscarPorId(String id) {

        var request = new Request.Builder()
                .url(authUrl + "/users/" + id)
                .get()
                .build();

        try {
            var response = okHttpClient.newCall(request).execute();
            return parseUserResponse(response);

        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("Falha ao buscar usuário por id", e);
        }
    }

    @Override
    public ClienteDTO buscarPorToken(String authorization) {
        var request = new Request.Builder()
                .url(authUrl + "/auth/info")
                .addHeader("Authorization", authorization)
                .get()
                .build();

        try {
            var response = okHttpClient.newCall(request).execute();
            return parseUserResponse(response);

        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("Falha ao buscar usuário por token", e);
        }
    }

    private ClienteDTO parseUserResponse(Response response) throws RuntimeException, IOException {
        if (response.body() == null || !response.isSuccessful()) {
            throw new RuntimeException("Falha ao buscar usuário");
        }

        var userResponse = objectMapper.readValue(response.body().string(), UserResponse.class);
        if(userResponse.roles().contains(UserRole.CUSTOMER)) {
            return authGatewayMapper.toClienteDTO(userResponse);
        }

        return null;
    }
}
