package br.com.fiap.techchallenge.lanchonete.adapters.web.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static br.com.fiap.techchallenge.lanchonete.utils.ClienteHelper.getClienteDTO;
import static br.com.fiap.techchallenge.lanchonete.utils.ClienteHelper.getListaClienteDTO;
import static org.assertj.core.api.Assertions.assertThat;

class ClienteMapperTest {

    private ClienteMapper clienteMapper;

    @BeforeEach
    void setup() {
        this.clienteMapper = new ClienteMapper();
    }

    @Test
    void dadoClienteDTO_DeveFazerMapper_RetornarClienteResponse() {
        // Arrange
        var clienteDTO = getClienteDTO();

        // Act
        var clienteResponse = clienteMapper.toClienteResponse(clienteDTO);

        // Assert
        assertThat(clienteResponse).isNotNull();
        assertThat(clienteResponse.getId()).isEqualTo(clienteDTO.id());
        assertThat(clienteResponse.getNome()).isEqualTo(clienteDTO.nome());
        assertThat(clienteResponse.getCpf()).isEqualTo(clienteDTO.cpf());
        assertThat(clienteResponse.getEmail()).isEqualTo(clienteDTO.email());
    }

    @Test
    void dadoListaDeClienteDTO_DeveFazerMapper_RetornarListaDeClienteResponse() {
        // Arrange
        var clientes = getListaClienteDTO();

        // Act
        var clientesResponse = clienteMapper.toClientesResponse(clientes);

        // Assert
        assertThat(clientesResponse).isNotNull();
        assertThat(clientesResponse.get(0).getId()).isEqualTo(clientes.get(0).id());
        assertThat(clientesResponse.get(0).getNome()).isEqualTo(clientes.get(0).nome());
        assertThat(clientesResponse.get(0).getCpf()).isEqualTo(clientes.get(0).cpf());
        assertThat(clientesResponse.get(0).getEmail()).isEqualTo(clientes.get(0).email());
    }
}