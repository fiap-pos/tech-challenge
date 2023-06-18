package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;

import java.util.List;

public interface BuscaTodosProdutosOutputPort {

    List<ProdutoOut> buscarTodos();
}
