package br.com.fiap.techchallenge.lanchonete.adapters.web.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.web.models.ClienteResponse;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ClienteMapperWeb")
public class ClienteMapper {

    public ClienteResponse toClienteResponse(ClienteDTO cliente) {
        return new ClienteResponse(
          cliente.id(),
          cliente.nome(),
          cliente.cpf(),
          cliente.email()
        );
    }

    public List<ClienteResponse> toClientesResponse(List<ClienteDTO> clientes) {
        return clientes.stream().map(this::toClienteResponse).toList();
    }
}
