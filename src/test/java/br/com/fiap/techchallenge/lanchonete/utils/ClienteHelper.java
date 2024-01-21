package br.com.fiap.techchallenge.lanchonete.utils;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Cliente;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;

import java.util.List;

public abstract class ClienteHelper {

    private static final String NOME_1 = "Cliente 1";
    private static final String CPF_1 = "94187479015";
    private static final String EMAIL_1 = "cliente1@gmail.com";
    private static final String NOME_2 = "Cliente 1";
    private static final String CPF_2 = "94187479015";
    private static final String EMAIL_2 = "cliente1@gmail.com";

    public static ClienteDTO getClienteDTO() {
        return new ClienteDTO(1L, NOME_1, CPF_1, EMAIL_1);
    }

    public static List<ClienteDTO> getListaClienteDTO() {
        return List.of(
                new ClienteDTO(1L, NOME_1, CPF_1, EMAIL_1),
                new ClienteDTO(2L, NOME_2, CPF_2, EMAIL_2)
        );
    }

    public static Cliente getCliente() {
        return new Cliente(NOME_1, CPF_1, EMAIL_1);
    }

    public static List<Cliente> getListaCliente() {
        return List.of(getCliente());
    }
}
