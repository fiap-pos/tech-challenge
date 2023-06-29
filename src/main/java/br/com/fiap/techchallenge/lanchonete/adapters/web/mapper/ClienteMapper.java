package br.com.fiap.techchallenge.lanchonete.adapters.web.mapper;

import br.com.fiap.techchallenge.lanchonete.adapters.web.models.ClienteResponse;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteOut;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ClienteMapperWeb")
public class ClienteMapper {

    public ClienteResponse toClienteResponse(ClienteOut cliente) {
        return new ClienteResponse(
          cliente.getId(),
          cliente.getNome(),
          cliente.getCpf(),
          cliente.getEmail()
        );
    }

    public List<ClienteResponse> toClientesResponse(List<ClienteOut> clientes) {
        return clientes.stream().map(cliente -> new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail()
        )).toList();
    }
}
