package br.com.fiap.techchallenge.lanchonete.core.ports.in;

import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoOut;

import java.util.List;

public interface BuscaTodosProdutosInputPort {

    List<ProdutoOut> buscartodos();
}
