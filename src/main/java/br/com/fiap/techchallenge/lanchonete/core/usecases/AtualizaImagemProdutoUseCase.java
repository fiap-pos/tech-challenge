package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.AtualizaImagemProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.AtualizaImagemProdutoOutputPort;

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
