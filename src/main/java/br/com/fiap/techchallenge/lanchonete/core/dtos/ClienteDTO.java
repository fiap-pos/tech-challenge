package br.com.fiap.techchallenge.lanchonete.core.dtos;

public record ClienteDTO(Long id, String nome, String cpf, String email) {

    public ClienteDTO(String nome, String cpf, String email) {
        this(null, nome, cpf, email);
    }

}
