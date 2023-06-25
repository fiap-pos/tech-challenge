package br.com.fiap.techchallenge.lanchonete.core.port.in.produto;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.enums.CategoriaEnum;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.ProdutoOut;

import java.util.List;

public interface BuscaProdutoPorCategoriaInputPort {

    List<ProdutoOut> buscarPorCategoria(CategoriaEnum categoriaEnum);
}
