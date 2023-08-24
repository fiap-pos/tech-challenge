package br.com.fiap.techchallenge.lanchonete.core.ports.in.produto;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;
import java.util.List;

public interface BuscaTodosProdutosInputPort {

    List<ProdutoDTO> buscartodos();
}
