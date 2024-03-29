package br.com.fiap.techchallenge.lanchonete.core.dtos;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.Cliente;

public record ClienteDTO(String id, String nome, String cpf, String email) {

    public ClienteDTO(String nome, String cpf, String email) {
        this(null, nome, cpf, email);
    }

    public ClienteDTO(String id) {
        this(id, null, null, null);
    }

    public ClienteDTO(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getEmail());
    }
}
