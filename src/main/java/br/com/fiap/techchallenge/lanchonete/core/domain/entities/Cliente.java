package br.com.fiap.techchallenge.lanchonete.core.domain.entities;

public class Cliente {
    private String id;
    private String nome;
    private String cpf;
    private String email;

    public Cliente(String id, String nome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getId() {
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
