package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.entities.ClienteIn;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ClienteRequest extends ClienteIn {

    public ClienteRequest(Long id, String nome, String cpf, String email) {
        super(id, nome, cpf, email);
    }

    @Override
    @JsonIgnore
    public Long getId() {
        return super.getId();
    }
}
