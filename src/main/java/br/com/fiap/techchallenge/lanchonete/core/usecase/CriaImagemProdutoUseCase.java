package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ImagemProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaImagemProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.SalvaImagemProdutoOutputPort;

public class CriaImagemProdutoUseCase implements CriaImagemProdutoInputPort {

    SalvaImagemProdutoOutputPort salvaImagemProdutoOutputPort;

    public CriaImagemProdutoUseCase(SalvaImagemProdutoOutputPort salvaProdutoOutputPort) {
        this.salvaImagemProdutoOutputPort = salvaProdutoOutputPort;
    }

    @Override
    public ProdutoOut criar(ImagemProdutoIn imagemProdutoIn) {
        return salvaImagemProdutoOutputPort.salvar(imagemProdutoIn);
    }
}
