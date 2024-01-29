package br.com.fiap.techchallenge.lanchonete.core.domain.entities;

public class Cliente {
    private Long id;
    private String nome;
    private String cpf;
    private String email;

    public Cliente(Long id, String nome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

}
