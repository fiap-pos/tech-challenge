package br.com.fiap.techchallenge.lanchonete.core.ports.in;

import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoOut;

public interface AtualizaImagemProdutoInputPort {

    ProdutoOut atualizar(ProdutoIn produtoIn);
}
