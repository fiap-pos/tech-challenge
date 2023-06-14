package br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoRequest;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoResponse;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toProduto(ProdutoRequest produtoRequest) {
        return new Produto(produtoRequest.getNome(), produtoRequest.getCategoria(), produtoRequest.getPreco(),
                produtoRequest.getDescricao(), produtoRequest.getImagem());
    }

    public ProdutoResponse toProdutoResponse(Produto produto) {
        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getCategoria(), produto.getPreco(),
                produto.getDescricao(), produto.getImagem());
    }

}
