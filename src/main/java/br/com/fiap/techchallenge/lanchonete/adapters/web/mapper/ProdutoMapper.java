package br.com.fiap.techchallenge.lanchonete.adapters.web.mapper;

import br.com.fiap.techchallenge.lanchonete.adapters.web.models.ProdutoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.ProdutoResponse;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;
import org.springframework.stereotype.Component;

@Component("ProdutoMapperWeb")
public class ProdutoMapper {

    public ProdutoResponse toProdutoResponse(ProdutoOut produtoOut) {
        return new ProdutoResponse(produtoOut.getId(), produtoOut.getNome(), produtoOut.getCategoria(),
                produtoOut.getPreco(), produtoOut.getDescricao(), produtoOut.getImagem());
    }

    public ProdutoRequest toProdutoRequest(Long id, ProdutoRequest produtoRequest) {
        return new ProdutoRequest(id, produtoRequest.getNome(), produtoRequest.getCategoria(), produtoRequest.getPreco(),
                produtoRequest.getDescricao(), produtoRequest.getImagem());
    }

    public ProdutoRequest toProdutoRequest(Long id, byte[] imagem) {
        return new ProdutoRequest(id, imagem);
    }

}
