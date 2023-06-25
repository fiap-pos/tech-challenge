package br.com.fiap.techchallenge.lanchonete.core.port.out.produto;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.ProdutoOut;

import java.util.List;

public interface BuscaTodosProdutosOutputPort {

    List<ProdutoOut> buscarTodos();
}
