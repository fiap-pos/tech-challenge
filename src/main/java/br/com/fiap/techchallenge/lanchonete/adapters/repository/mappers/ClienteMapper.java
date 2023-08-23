package br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Cliente;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteMapper {

    public Cliente toCliente(ClienteDTO cliente) {
        return new Cliente(
                cliente.nome(),
                cliente.cpf(),
                cliente.email()
        );
    }

    public ClienteDTO toClienteDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail()
        );
    }

    public List<ClienteDTO> toClienteListDTO(List<Cliente> clientes) {
        return clientes.stream().map(this::toClienteDTO).toList();
    }
}
