package br.com.fiap.techchallenge.lanchonete.adapters.repository.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.CategoriaEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoria;

    private BigDecimal preco;

    private String descricao;
    @Lob
    private byte[] imagem;

    public Produto() {
    }

    public Produto(Long id, String nome, CategoriaEnum categoriaEnum, BigDecimal preco, String descricao) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoriaEnum;
        this.preco = preco;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEnum categoriaEnum) {
        this.categoria = categoriaEnum;
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
