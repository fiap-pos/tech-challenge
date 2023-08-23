package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoOut;

public interface BuscaProdutoPorIdOutputPort {

    ProdutoOut buscarPorId(Long id);
}
