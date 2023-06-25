package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ProdutoJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper.ProdutoMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;
import br.com.fiap.techchallenge.lanchonete.core.domain.exception.EntityNotFoundException;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.enums.CategoriaEnum;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.out.produto.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepository implements CriaProdutoOutputPort, AtualizaImagemProdutoOutputPort, EditaProdutoOutputPort,
        RemoveProdutoOutputPort, BuscaProdutoPorIdOutputPort, BuscaTodosProdutosOutputPort, BuscaProdutoPorCategoriaOutputPort {

    ProdutoJpaRepository produtoJpaRepository;
    ProdutoMapper produtoMapper;

    public ProdutoRepository(ProdutoJpaRepository produtoJpaRepository, ProdutoMapper produtoMapper) {
        this.produtoJpaRepository = produtoJpaRepository;
        this.produtoMapper = produtoMapper;
    }

    @Override
    public ProdutoOut criar(ProdutoIn produtoIn) {
        var produto = produtoMapper.toProduto(produtoIn);
        var produtoSalvo = produtoJpaRepository.save(produto);

        return produtoMapper.toProdutoResponse(produtoSalvo);
    }

    @Override
    public ProdutoOut atualizar(ProdutoIn produtoIn) {
        var produto = buscaProdutoPorId(produtoIn.getId());
        produto.setImagem(produtoIn.getImagem());

        var produtoSalvo = produtoJpaRepository.save(produto);

        return produtoMapper.toProdutoResponse(produtoSalvo);
    }

    @Override
    public ProdutoOut editar(ProdutoIn produtoIn) {
        buscaProdutoPorId(produtoIn.getId());

        return criar(produtoIn);
    }

    @Override
    public ProdutoOut remover(Long id) {
        var produto = buscaProdutoPorId(id);

        produtoJpaRepository.delete(produto);
        produto.setImagem(null);

        return produtoMapper.toProdutoResponse(produto);
    }

    private Produto buscaProdutoPorId(Long id) {
        return produtoJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto com o id " + id + " não existe"));
    }

    @Override
    public ProdutoOut buscarPorId(Long id) {
        var produto = buscaProdutoPorId(id);

        return produtoMapper.toProdutoResponse(produto);
    }

    @Override
    public List<ProdutoOut> buscarTodos() {
        var produtos = produtoJpaRepository.findAll();
        return produtoMapper.toProdutosResponse(produtos);
    }

    @Override
    public List<ProdutoOut> buscarPorCategoria(CategoriaEnum categoriaEnum) {
        var produtos = produtoJpaRepository.findByCategoria(categoriaEnum);
        return produtoMapper.toProdutosResponse(produtos);
    }
}
