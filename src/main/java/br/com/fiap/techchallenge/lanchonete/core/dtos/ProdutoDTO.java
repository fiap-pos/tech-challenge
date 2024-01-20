package br.com.fiap.techchallenge.lanchonete.core.dtos;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.CategoriaEnum;

import java.math.BigDecimal;

public record ProdutoDTO(Long id, String nome, CategoriaEnum categoria, BigDecimal preco, String descricao, byte[] imagem) {

    public ProdutoDTO(String nome, CategoriaEnum categoria, BigDecimal preco, String descricao) {
        this(null, nome, categoria, preco, descricao,null);
    }

    public ProdutoDTO(Long id, String nome, CategoriaEnum categoria, BigDecimal preco, String descricao, byte[] imagem) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
        this.imagem = imagem;
    }
}
