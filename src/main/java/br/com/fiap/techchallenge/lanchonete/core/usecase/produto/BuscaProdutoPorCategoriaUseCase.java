package br.com.fiap.techchallenge.lanchonete.core.usecase.produto;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.enums.CategoriaEnum;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.produto.BuscaProdutoPorCategoriaInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.produto.BuscaProdutoPorCategoriaOutputPort;

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
