package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteIn;

public class ClienteRequest extends ClienteIn {
    public ClienteRequest(Long id, String nome, String cpf, String email) {
        super(id, nome, cpf, email);
    }
}
