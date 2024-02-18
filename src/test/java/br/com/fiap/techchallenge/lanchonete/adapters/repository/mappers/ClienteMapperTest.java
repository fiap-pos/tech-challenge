package br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Cliente;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static br.com.fiap.techchallenge.lanchonete.utils.ClienteHelper.*;
import static org.assertj.core.api.Assertions.assertThat;

class ClienteMapperTest {

    private ClienteMapper clienteMapper;

    @BeforeEach
    void setup() {
        this.clienteMapper = new ClienteMapper();
    }

    @Test
    void dadoClienteDTO_DeveFazerMapper_RetornarCliente() {
        var clienteDTO = getClienteDTO();

        var cliente = clienteMapper.toCliente(clienteDTO);

        assertThat(cliente).isNotNull().isInstanceOf(Cliente.class);
        assertThat(cliente.getNome()).isEqualTo(clienteDTO.nome());
        assertThat(cliente.getCpf()).isEqualTo(clienteDTO.cpf());
        assertThat(cliente.getEmail()).isEqualTo(clienteDTO.email());
    }


    @Test
    void dadoCliente_DeveFazerMapper_RetornarClienteDTO() {
        var cliente = getCliente();

        var clienteDTO = clienteMapper.toClienteDTO(cliente);

        assertThat(clienteDTO).isNotNull().isInstanceOf(ClienteDTO.class);
        assertThat(clienteDTO.id()).isEqualTo(cliente.getId());
        assertThat(clienteDTO.nome()).isEqualTo(cliente.getNome());
        assertThat(clienteDTO.cpf()).isEqualTo(cliente.getCpf());
        assertThat(clienteDTO.email()).isEqualTo(cliente.getEmail());
    }


    @Test
    void dadoListaCliente_DeveFazerMapper_RetornarListaClienteDTO() {
        var listaCliente = getListaCliente();

        var listaClienteDTO = clienteMapper.toClienteListDTO(listaCliente);

        assertThat(listaClienteDTO)
                .isNotNull()
                .isInstanceOf(List.class)
                .isNotEmpty()
                .allSatisfy(clienteDTO -> {
                    assertThat(clienteDTO).isNotNull().isInstanceOf(ClienteDTO.class);
                    assertThat(clienteDTO.id()).isEqualTo(listaCliente.get(0).getId());
                    assertThat(clienteDTO.nome()).isEqualTo(listaCliente.get(0).getNome());
                    assertThat(clienteDTO.cpf()).isEqualTo(listaCliente.get(0).getCpf());
                    assertThat(clienteDTO.email()).isEqualTo(listaCliente.get(0).getEmail());
                });
    }

}