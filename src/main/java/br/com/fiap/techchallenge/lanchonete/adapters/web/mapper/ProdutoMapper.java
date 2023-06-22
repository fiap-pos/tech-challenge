package br.com.fiap.techchallenge.lanchonete.adapters.web.mapper;

import br.com.fiap.techchallenge.lanchonete.adapters.web.models.ProdutoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.ProdutoResponse;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("ProdutoMapperWeb")
public class ProdutoMapper {

    public ProdutoResponse toProdutoResponse(ProdutoOut produtoOut) {
        return new ProdutoResponse(produtoOut.getId(), produtoOut.getNome(), produtoOut.getCategoria(),
                produtoOut.getPreco(), produtoOut.getDescricao(), produtoOut.getImagem());
    }

    public List<ProdutoResponse> toProdutosResponse(List<ProdutoOut> produtosOut) {
        List<ProdutoResponse> produtosResponse = new ArrayList<>();
        produtosOut.forEach(produtoOut -> produtosResponse.add(toProdutoResponse(produtoOut)));
        return produtosResponse;
    }

    public ProdutoRequest toProdutoRequest(Long id, ProdutoRequest produtoRequest) {
        return new ProdutoRequest(id, produtoRequest.getNome(), produtoRequest.getCategoria(), produtoRequest.getPreco(),
                produtoRequest.getDescricao(), produtoRequest.getImagem());
    }

    public ProdutoRequest toProdutoRequest(Long id, byte[] imagem) {
        return new ProdutoRequest(id, imagem);
    }

}
