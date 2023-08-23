package br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Cliente;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.ClienteResponse;
import br.com.fiap.techchallenge.lanchonete.core.entities.ClienteIn;
import br.com.fiap.techchallenge.lanchonete.core.entities.ClienteOut;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteMapper {

    public Cliente toCliente(ClienteIn cliente) {
        return new Cliente(
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail()
        );
    }

    public ClienteOut toClienteResponse(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail()
        );
    }

    public List<ClienteOut> toClienteListResponse(List<Cliente> clientes) {
        return clientes.stream().map(cliente -> new ClienteOut(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail()
        )).toList();
    }
}
