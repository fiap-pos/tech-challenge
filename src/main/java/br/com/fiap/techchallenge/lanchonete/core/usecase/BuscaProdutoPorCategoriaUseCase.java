package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.CategoriaEnum;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaProdutoPorCategoriaInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaProdutoPorCategoriaOutputPort;

import java.util.List;

public class BuscaProdutoPorCategoriaUseCase implements BuscaProdutoPorCategoriaInputPort {

    BuscaProdutoPorCategoriaOutputPort buscaProdutoPorIdOutputPort;

    public BuscaProdutoPorCategoriaUseCase(BuscaProdutoPorCategoriaOutputPort buscaProdutoPorIdOutputPort) {
        this.buscaProdutoPorIdOutputPort = buscaProdutoPorIdOutputPort;
    }

    @Override
    public List<ProdutoOut> buscarPorCategoria(CategoriaEnum categoriaEnum) {
        return buscaProdutoPorIdOutputPort.buscarPorCategoria(categoriaEnum);
    }
}
