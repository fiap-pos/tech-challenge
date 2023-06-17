package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ProdutoRequest {

    @NotBlank(message = "O campo 'nome' é obrigatório")
    private String nome;

    @NotNull(message = "O campo 'categoria' é obrigatório")
    private Categoria categoria;

    @NotNull(message = "O campo 'preco' é obrigatório")
    @DecimalMin(value = "0.0", message = "Informe um valor maior que 0.0")
    private BigDecimal preco;

    @NotBlank(message = "O campo 'descricao' é obrigatório")
    private String descricao;

    private byte[] imagem;

    public ProdutoRequest(String nome, Categoria categoria, BigDecimal preco, String descricao, byte[] imagem) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}
