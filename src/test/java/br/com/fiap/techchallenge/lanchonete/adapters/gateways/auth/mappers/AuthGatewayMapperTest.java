package br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.mappers;


import br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.models.UserResponse;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.models.UserRole;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AuthGatewayMapperTest {

    private AuthGatewayMapper authGatewayMapper;

    @BeforeEach
    void setUp() {
        authGatewayMapper = new AuthGatewayMapper();
    }

    @Test
    void testToClienteDTO() {

        UserResponse userResponse = new UserResponse("id", "name", "username", "email", List.of(UserRole.CUSTOMER));

        ClienteDTO result = authGatewayMapper.toClienteDTO(userResponse);

        assertThat(result).isEqualTo(new ClienteDTO("id", "name", "username", "email"));
    }
}