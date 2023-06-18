package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.CriaProdutoOutputPort;

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
