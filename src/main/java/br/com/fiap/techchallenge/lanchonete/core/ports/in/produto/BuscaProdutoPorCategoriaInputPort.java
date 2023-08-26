package br.com.fiap.techchallenge.lanchonete.core.ports.in.produto;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.CategoriaEnum;
import java.util.List;

public interface BuscaProdutoPorCategoriaInputPort {

    List<ProdutoDTO> buscarPorCategoria(CategoriaEnum categoriaEnum);
}
