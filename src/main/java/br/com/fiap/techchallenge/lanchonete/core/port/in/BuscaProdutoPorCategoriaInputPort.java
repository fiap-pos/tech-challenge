package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.CategoriaEnum;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;

import java.util.List;

public interface BuscaProdutoPorCategoriaInputPort {

    List<ProdutoOut> buscarPorCategoria(CategoriaEnum categoriaEnum);
}
