package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoOut;

public interface CriaProdutoOutputPort {

    ProdutoOut criar(ProdutoIn produtoIn);
}
