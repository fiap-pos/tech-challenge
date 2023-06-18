package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ImagemProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;

public interface CriaImagemProdutoOutputPort {

    ProdutoOut criar(ImagemProdutoIn imagemProdutoIn);
}
