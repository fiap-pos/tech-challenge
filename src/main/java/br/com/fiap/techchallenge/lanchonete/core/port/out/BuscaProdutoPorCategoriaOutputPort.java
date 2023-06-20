package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.Categoria;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;

import java.util.List;

public interface BuscaProdutoPorCategoriaOutputPort {

    List<ProdutoOut> buscarPorCategoria(Categoria categoria);
}
