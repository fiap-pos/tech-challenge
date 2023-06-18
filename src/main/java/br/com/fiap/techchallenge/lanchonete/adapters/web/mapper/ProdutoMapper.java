package br.com.fiap.techchallenge.lanchonete.adapters.web.mapper;

import br.com.fiap.techchallenge.lanchonete.adapters.web.ProdutoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.ProdutoResponse;
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

    public ProdutoRequest toProdutoRequest(Long id) {
        return new ProdutoRequest(id);
    }

}
