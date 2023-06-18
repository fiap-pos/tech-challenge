package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaImagemProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.CriaImagemProdutoOutputPort;

public class CriaImagemProdutoUseCase implements CriaImagemProdutoInputPort {

    CriaImagemProdutoOutputPort criaImagemProdutoOutputPort;

    public CriaImagemProdutoUseCase(CriaImagemProdutoOutputPort salvaProdutoOutputPort) {
        this.criaImagemProdutoOutputPort = salvaProdutoOutputPort;
    }

    @Override
    public ProdutoOut criarImagem(ProdutoIn produtoIn) {
        return criaImagemProdutoOutputPort.criarImagem(produtoIn);
    }
}
