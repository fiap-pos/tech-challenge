package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ImagemProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;

public interface SalvaImagemProdutoOutputPort {

    ProdutoOut salvar(ImagemProdutoIn imagemProdutoIn);
}
