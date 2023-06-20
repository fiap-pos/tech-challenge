package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.AtualizaImagemProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.AtualizaImagemProdutoOutputPort;

public class AtualizaImagemProdutoUseCase implements AtualizaImagemProdutoInputPort {

    AtualizaImagemProdutoOutputPort atualizaImagemProdutoOutputPort;

    public AtualizaImagemProdutoUseCase(AtualizaImagemProdutoOutputPort salvaProdutoOutputPort) {
        this.atualizaImagemProdutoOutputPort = salvaProdutoOutputPort;
    }

    @Override
    public ProdutoOut atualizar(ProdutoIn produtoIn) {
        return atualizaImagemProdutoOutputPort.atualizar(produtoIn);
    }
}
