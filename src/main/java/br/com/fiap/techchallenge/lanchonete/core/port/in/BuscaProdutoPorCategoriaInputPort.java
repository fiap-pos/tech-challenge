package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;

import java.util.List;

public interface BuscaProdutoPorCategoriaInputPort {

    List<ProdutoOut> buscarPorCategoria(ProdutoIn produtoIn);
}
