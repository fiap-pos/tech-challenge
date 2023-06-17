package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ImagemProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;

public interface CriaImagemProdutoInputPort {

    ProdutoOut criar(ImagemProdutoIn imagemProdutoIn);
}
