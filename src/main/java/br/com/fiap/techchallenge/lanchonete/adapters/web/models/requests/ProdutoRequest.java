package br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.CategoriaEnum;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ProdutoRequest {

    private String nome;
    private CategoriaEnum categoria;
    private BigDecimal preco;
    private String descricao;

    public ProdutoDTO toProdutoDTO() {
        return new ProdutoDTO(
            nome,
            categoria,
            preco,
            descricao
        );
    }

    @NotBlank(message = "O campo 'nome' é obrigatório")
    public String getNome() {
        return nome;
    }

    @NotNull(message = "O campo 'categoria' é obrigatório")
    public CategoriaEnum getCategoria() {
        return categoria;
    }

    @NotNull(message = "O campo 'preco' é obrigatório")
    @DecimalMin(value = "0.0", message = "Informe um valor maior que 0.0")
    public BigDecimal getPreco() {
        return preco;
    }

    @NotBlank(message = "O campo 'descricao' é obrigatório")
    public String getDescricao() {return descricao; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
