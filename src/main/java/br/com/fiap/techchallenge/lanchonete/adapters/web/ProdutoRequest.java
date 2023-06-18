package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.Categoria;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoIn;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoRequest(Long id, String nome, Categoria categoria, BigDecimal preco, String descricao) implements ProdutoIn {

    @Override
    public Long getId() {
        return id;
    }

    @NotBlank(message = "O campo 'nome' é obrigatório")
    @Override
    public String getNome() {
        return nome;
    }

    @NotNull(message = "O campo 'categoria' é obrigatório")
    @Override
    public Categoria getCategoria() {
        return categoria;
    }

    @NotNull(message = "O campo 'preco' é obrigatório")
    @DecimalMin(value = "0.0", message = "Informe um valor maior que 0.0")
    @Override
    public BigDecimal getPreco() {
        return preco;
    }

    @NotBlank(message = "O campo 'descricao' é obrigatório")
    @Override
    public String getDescricao() {
        return descricao;
    }
}
