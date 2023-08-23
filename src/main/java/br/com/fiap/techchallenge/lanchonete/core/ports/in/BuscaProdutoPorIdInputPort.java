package br.com.fiap.techchallenge.lanchonete.core.ports.in;

import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoOut;

public interface BuscaProdutoPorIdInputPort {

    ProdutoOut buscarPorId(Long id);
}
