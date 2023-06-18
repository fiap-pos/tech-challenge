package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ProdutoJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper.ProdutoMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;
import br.com.fiap.techchallenge.lanchonete.core.domain.exception.EntityNotFoundException;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.out.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoRepository implements CriaProdutoOutputPort, CriaImagemProdutoOutputPort, EditaProdutoOutputPort,
        RemoveProdutoOutputPort, BuscaProdutoPorIdOutputPort, BuscaTodosProdutosOutputPort {

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
    public ProdutoOut criarImagem(ProdutoIn produtoIn) {
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
    public ProdutoOut remover(ProdutoIn produtoIn) {
        var produto = buscaProdutoPorId(produtoIn.getId());

        produtoJpaRepository.delete(produto);
        produto.setImagem(null);

        return produtoMapper.toProdutoResponse(produto);
    }

    private Produto buscaProdutoPorId(Long id) {
        return produtoJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto com o id " + id + " não existe"));
    }

    @Override
    public ProdutoOut buscarPorId(ProdutoIn produtoIn) {
        var produto = buscaProdutoPorId(produtoIn.getId());

        return produtoMapper.toProdutoResponse(produto);
    }

    @Override
    public List<ProdutoOut> buscarTodos() {
        List<ProdutoOut> produtosOut = new ArrayList<>();

        var produtos = produtoJpaRepository.findAll();
        produtos.forEach(produto -> produtosOut.add(produtoMapper.toProdutoResponse(produto)));

        return produtosOut;
    }
}
