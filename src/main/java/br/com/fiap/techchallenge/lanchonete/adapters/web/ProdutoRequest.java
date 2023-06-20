package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.Categoria;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoIn;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ProdutoRequest extends ProdutoIn {

    public ProdutoRequest() {
    }

    public ProdutoRequest(Long id, String nome, Categoria categoria, BigDecimal preco, String descricao, byte[] imagem) {
        setId(id);
        setNome(nome);
        setCategoria(categoria);
        setPreco(preco);
        setDescricao(descricao);
        setImagem(imagem);
    }

    public ProdutoRequest(Long id, byte[] imagem) {
        setId(id);
        setImagem(imagem);
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @NotBlank(message = "O campo 'nome' é obrigatório")
    @Override
    public String getNome() {
        return super.getNome();
    }

    @NotNull(message = "O campo 'categoria' é obrigatório")
    @Override
    public Categoria getCategoria() {
        return super.getCategoria();
    }

    @NotNull(message = "O campo 'preco' é obrigatório")
    @DecimalMin(value = "0.0", message = "Informe um valor maior que 0.0")
    @Override
    public BigDecimal getPreco() {
        return super.getPreco();
    }

    @NotBlank(message = "O campo 'descricao' é obrigatório")
    @Override
    public String getDescricao() {
        return super.getDescricao();
    }

    @Override
    public byte[] getImagem() {
        return super.getImagem();
    }
}
