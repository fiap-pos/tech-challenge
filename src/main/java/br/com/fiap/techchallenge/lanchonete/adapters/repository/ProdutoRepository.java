package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ProdutoJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers.ProdutoMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Produto;
import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaImagemProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.domain.exceptions.EntityNotFoundException;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.CategoriaEnum;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.produto.*;
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
    public ProdutoDTO criar(ProdutoDTO produtoIn) {
        var produto = produtoMapper.toProduto(produtoIn);
        var produtoSalvo = produtoJpaRepository.save(produto);

        return produtoMapper.toProdutoDTO(produtoSalvo);
    }

    @Override
    public ProdutoDTO atualizar(AtualizaImagemProdutoDTO imagemIn, Long id) {
        var produto = buscaProdutoPorId(id);
        produto.setImagem(imagemIn.imagem());

        var produtoSalvo = produtoJpaRepository.save(produto);

        return produtoMapper.toProdutoDTO(produtoSalvo);
    }

    @Override
    public ProdutoDTO editar(ProdutoDTO produtoIn, Long id) {
        var produto = buscaProdutoPorId(id);
        produto.setCategoria(produtoIn.categoria());
        produto.setDescricao(produtoIn.descricao());
        produto.setNome(produtoIn.nome());
        produto.setPreco(produtoIn.preco());

        var produtoSalvo = produtoJpaRepository.save(produto);
        return produtoMapper.toProdutoDTO(produtoSalvo);
    }

    @Override
    public ProdutoDTO remover(Long id) {
        var produto = buscaProdutoPorId(id);

        produtoJpaRepository.delete(produto);
        produto.setImagem(null);

        return produtoMapper.toProdutoDTO(produto);
    }

    private Produto buscaProdutoPorId(Long id) {
        return produtoJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto com o id " + id + " não existe"));
    }

    @Override
    public ProdutoDTO buscarPorId(Long id) {
        var produto = buscaProdutoPorId(id);

        return produtoMapper.toProdutoDTO(produto);
    }

    @Override
    public List<ProdutoDTO> buscarTodos() {
        return produtoJpaRepository.findAll().stream()
                .map(produtoMapper::toProdutoDTO)
                .toList();
    }

    @Override
    public List<ProdutoDTO> buscarPorCategoria(CategoriaEnum categoriaEnum) {
        return produtoJpaRepository.findByCategoria(categoriaEnum).stream()
                .map(produtoMapper::toProdutoDTO)
                .toList();
    }
}
