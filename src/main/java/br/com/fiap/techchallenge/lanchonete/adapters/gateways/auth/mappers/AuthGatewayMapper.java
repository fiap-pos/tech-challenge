package br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.models.UserResponse;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthGatewayMapper {

    public ClienteDTO toClienteDTO(UserResponse userResponse) {
        return new ClienteDTO(
                userResponse.id(),
                userResponse.name(),
                userResponse.username(),
                userResponse.email()
        );
    }
}
