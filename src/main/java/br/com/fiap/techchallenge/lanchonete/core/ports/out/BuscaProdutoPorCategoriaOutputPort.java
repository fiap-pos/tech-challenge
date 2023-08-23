package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.entities.enums.CategoriaEnum;
import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoOut;

import java.util.List;

public interface BuscaProdutoPorCategoriaOutputPort {

    List<ProdutoOut> buscarPorCategoria(CategoriaEnum categoriaEnum);
}
