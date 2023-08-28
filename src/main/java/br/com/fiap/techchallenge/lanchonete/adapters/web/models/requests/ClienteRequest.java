package br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;

public class ClienteRequest {

    private String nome;
    private String cpf;
    private String emai;

    public ClienteDTO toClienteDTO() {
        return new ClienteDTO(this.nome, this.cpf, this.emai);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }
}
