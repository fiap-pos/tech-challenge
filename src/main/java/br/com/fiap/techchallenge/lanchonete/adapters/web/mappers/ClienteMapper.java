package br.com.fiap.techchallenge.lanchonete.adapters.web.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.web.models.responses.ClienteResponse;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("clienteMapperWeb")
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
