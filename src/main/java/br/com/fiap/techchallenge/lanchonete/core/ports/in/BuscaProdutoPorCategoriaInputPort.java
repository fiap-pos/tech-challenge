package br.com.fiap.techchallenge.lanchonete.core.ports.in;

import br.com.fiap.techchallenge.lanchonete.core.entities.enums.CategoriaEnum;
import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoOut;

import java.util.List;

public interface BuscaProdutoPorCategoriaInputPort {

    List<ProdutoOut> buscarPorCategoria(CategoriaEnum categoriaEnum);
}
