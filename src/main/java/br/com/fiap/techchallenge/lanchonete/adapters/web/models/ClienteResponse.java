package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteOut;

public class ClienteResponse extends ClienteOut {
    public ClienteResponse(Long id, String nome, String cpf, String email) {
        super(id, nome, cpf, email);
    }
}
