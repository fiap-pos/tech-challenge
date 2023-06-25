package br.com.fiap.techchallenge.lanchonete.core.port.in.produto;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.ProdutoOut;

import java.util.List;

public interface BuscaTodosProdutosInputPort {

    List<ProdutoOut> buscartodos();
}
