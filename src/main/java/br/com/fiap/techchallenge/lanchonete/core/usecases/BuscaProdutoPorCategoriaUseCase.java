package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.entities.enums.CategoriaEnum;
import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.BuscaProdutoPorCategoriaInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.BuscaProdutoPorCategoriaOutputPort;

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
