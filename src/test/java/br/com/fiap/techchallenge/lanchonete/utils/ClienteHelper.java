package br.com.fiap.techchallenge.lanchonete.utils;

import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.ClienteRequest;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;

import java.util.List;

public abstract class ClienteHelper {

    private static final String CLIENTE_ID_1 = "id-cliente-1";
    private static final String NOME_1 = "Cliente 1";
    private static final String CPF_1 = "94187479015";
    private static final String EMAIL_1 = "cliente1@gmail.com";

    private static final String CLIENTE_ID_2 = "id-cliente-2";
    private static final String NOME_2 = "Cliente 1";
    private static final String CPF_2 = "94187479015";
    private static final String EMAIL_2 = "cliente1@gmail.com";

    public static ClienteDTO getClienteDTO() {
        return new ClienteDTO(CLIENTE_ID_1, NOME_1, CPF_1, EMAIL_1);
    }

    public static ClienteDTO getClienteDTOSemId() {
        return new ClienteDTO(NOME_1, CPF_1, EMAIL_1);
    }

    public static List<ClienteDTO> getListaClienteDTO() {
        return List.of(
                new ClienteDTO(CLIENTE_ID_1, NOME_1, CPF_1, EMAIL_1),
                new ClienteDTO(CLIENTE_ID_2, NOME_2, CPF_2, EMAIL_2)
        );
    }

    public static ClienteRequest getClienteRequest(String nome, String cpf, String email) {
        return new ClienteRequest(nome, cpf, email);
    }

}
