package br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Produto;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toProduto(ProdutoDTO produtoIn) {
        return new Produto(produtoIn.id(), produtoIn.nome(), produtoIn.categoria(), produtoIn.preco(),
                produtoIn.descricao());
    }

    public ProdutoDTO toProdutoDTO(Produto produto) {
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getCategoria(), produto.getPreco(),
                produto.getDescricao(), produto.getImagem());
    }

}
