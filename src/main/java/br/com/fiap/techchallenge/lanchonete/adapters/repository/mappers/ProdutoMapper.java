package br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Produto;
import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoOut;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toProduto(ProdutoIn produtoIn) {
        return new Produto(produtoIn.getId(), produtoIn.getNome(), produtoIn.getCategoria(), produtoIn.getPreco(),
                produtoIn.getDescricao());
    }

    public ProdutoOut toProdutoResponse(Produto produto) {
        return new ProdutoOut(produto.getId(), produto.getNome(), produto.getCategoria(), produto.getPreco(),
                produto.getDescricao(), produto.getImagem());
    }

}
