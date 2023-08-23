package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.CriaProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.CriaProdutoOutputPort;

public class CriaProdutoUseCase implements CriaProdutoInputPort {

    CriaProdutoOutputPort criaProdutoOutputPort;

    public CriaProdutoUseCase(CriaProdutoOutputPort criaProdutoOutputPort) {
        this.criaProdutoOutputPort = criaProdutoOutputPort;
    }

    @Override
    public ProdutoOut criar(ProdutoIn produtoIn) {
        return criaProdutoOutputPort.criar(produtoIn);
    }
}
