package br.com.fiap.techchallenge.lanchonete.core.domain.entities;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.CategoriaEnum;

import java.math.BigDecimal;

public class Produto {

    private Long id;
    private String nome;
    private CategoriaEnum categoriaEnum;
    private BigDecimal preco;
    private String descricao;
    private byte[] imagem;

    protected Produto() {
    }

    protected Produto(Long id, String nome, CategoriaEnum categoriaEnum, BigDecimal preco, String descricao, byte[] imagem) {
        this.id = id;
        this.nome = nome;
        this.categoriaEnum = categoriaEnum;
        this.preco = preco;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaEnum getCategoria() {
        return categoriaEnum;
    }

    public void setCategoria(CategoriaEnum categoriaEnum) {
        this.categoriaEnum = categoriaEnum;
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
