package br.com.fiap.techchallenge.lanchonete.core.ports.out.produto;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;
import java.util.List;

public interface BuscaTodosProdutosOutputPort {

    List<ProdutoDTO> buscarTodos();
}
