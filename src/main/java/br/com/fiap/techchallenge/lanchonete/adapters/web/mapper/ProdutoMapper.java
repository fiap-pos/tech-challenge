package br.com.fiap.techchallenge.lanchonete.adapters.web.mapper;

import br.com.fiap.techchallenge.lanchonete.adapters.web.ProdutoResponse;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;
import org.springframework.stereotype.Component;

@Component("ProdutoMapperWeb")
public class ProdutoMapper {

    public ProdutoResponse toProdutoResponse(ProdutoOut produtoOut) {
        return new ProdutoResponse(produtoOut.getId(), produtoOut.getNome(), produtoOut.getCategoria(), produtoOut.getPreco(),
                produtoOut.getDescricao(), produtoOut.getImagem());
    }

}
