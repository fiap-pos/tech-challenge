package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoOut;

public interface EditaProdutoOutputPort {

    ProdutoOut editar(ProdutoIn produtoIn);
}
