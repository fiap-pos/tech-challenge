package br.com.fiap.techchallenge.lanchonete.core.usecases.produto;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.produto.CriaProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.produto.CriaProdutoOutputPort;

public class CriaProdutoUseCase implements CriaProdutoInputPort {

    CriaProdutoOutputPort criaProdutoOutputPort;

    public CriaProdutoUseCase(CriaProdutoOutputPort criaProdutoOutputPort) {
        this.criaProdutoOutputPort = criaProdutoOutputPort;
    }

    @Override
    public ProdutoDTO criar(ProdutoDTO produtoIn) {
        return criaProdutoOutputPort.criar(produtoIn);
    }
}
