package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoRequest;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoResponse;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaProdutoPriceInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.SalvaProdutoOutputPort;

public class CriaProdutoUseCase implements CriaProdutoPriceInputPort {

    SalvaProdutoOutputPort salvaProdutoOutputPort;

    public CriaProdutoUseCase(SalvaProdutoOutputPort salvaProdutoOutputPort) {
        this.salvaProdutoOutputPort = salvaProdutoOutputPort;
    }

    @Override
    public ProdutoResponse criar(ProdutoRequest produtoRequest) {
        return salvaProdutoOutputPort.salvar(produtoRequest);
    }
}
