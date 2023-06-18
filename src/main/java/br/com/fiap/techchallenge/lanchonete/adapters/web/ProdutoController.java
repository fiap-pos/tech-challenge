package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.mapper.ProdutoMapper;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.Categoria;
import br.com.fiap.techchallenge.lanchonete.core.port.in.*;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    CriaProdutoInputPort criaProdutoInputPort;
    CriaImagemProdutoInputPort criaImagemProdutoInputPort;
    EditaProdutoInputPort editaProdutoInputPort;
    RemoveProdutoInputPort removeProdutoInputPort;
    BuscaProdutoPorIdInputPort buscaProdutoPorIdInputPort;
    BuscaTodosProdutosInputPort buscaTodosProdutosInputPort;
    BuscaProdutoPorCategoriaInputPort buscaProdutoPorCategoriaInputPort;
    ProdutoMapper produtoMapper;

    public ProdutoController(CriaProdutoInputPort criaProdutoInputPort, CriaImagemProdutoInputPort criaImagemProdutoInputPort,
                             EditaProdutoInputPort editaProdutoInputPort, RemoveProdutoInputPort removeProdutoInputPort,
                             BuscaProdutoPorIdInputPort buscaProdutoPorIdInputPort,
                             BuscaTodosProdutosInputPort buscaTodosProdutosInputPort,
                             BuscaProdutoPorCategoriaInputPort buscaProdutoPorCategoriaInputPort,
                             ProdutoMapper produtoMapper) {
        this.criaProdutoInputPort = criaProdutoInputPort;
        this.criaImagemProdutoInputPort = criaImagemProdutoInputPort;
        this.editaProdutoInputPort = editaProdutoInputPort;
        this.removeProdutoInputPort = removeProdutoInputPort;
        this.buscaProdutoPorIdInputPort = buscaProdutoPorIdInputPort;
        this.buscaTodosProdutosInputPort = buscaTodosProdutosInputPort;
        this.buscaProdutoPorCategoriaInputPort = buscaProdutoPorCategoriaInputPort;
        this.produtoMapper = produtoMapper;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> criar(@Valid @RequestBody ProdutoRequest produtoRequest) {
        var produtoOut = criaProdutoInputPort.criar(produtoRequest);
        var produtoResponse = produtoMapper.toProdutoResponse(produtoOut);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produtoResponse.getId())
                .toUri();

        return ResponseEntity.created(uri).body(produtoResponse);
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> upload(@PathVariable("id") Long id, @RequestPart("imagem") MultipartFile image) {
        try {
            var produtoRequest = produtoMapper.toProdutoRequest(id, image.getBytes());
            criaImagemProdutoInputPort.criarImagem(produtoRequest);

            return ResponseEntity.noContent().build();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar a imagem: " + e.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<ProdutoResponse> editar(@PathVariable("id") Long id, @RequestBody ProdutoRequest produtoRequest) {
        var produtoRequestMapper = produtoMapper.toProdutoRequest(id, produtoRequest);
        var produtoOut = editaProdutoInputPort.editar(produtoRequestMapper);
        var produtoResponse = produtoMapper.toProdutoResponse(produtoOut);

        return ResponseEntity.ok(produtoResponse);
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<ProdutoResponse> remover(@PathVariable("id") Long id) {
        var produtoRequest = produtoMapper.toProdutoRequest(id);
        var produtoOut = removeProdutoInputPort.remover(produtoRequest);
        var produtoResponse = produtoMapper.toProdutoResponse(produtoOut);

        return ResponseEntity.ok(produtoResponse);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<ProdutoResponse> buscarPorId(@PathVariable("id") Long id) {
        var produtoRequest = produtoMapper.toProdutoRequest(id);
        var produtoOut = buscaProdutoPorIdInputPort.buscarPorId(produtoRequest);
        var produtoResponse = produtoMapper.toProdutoResponse(produtoOut);

        return ResponseEntity.ok(produtoResponse);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<List<ProdutoResponse>> buscarTodos() {
        var produtosOut = buscaTodosProdutosInputPort.buscartodos();
        var produtosResponse = produtoMapper.toProdutosResponse(produtosOut);

        return ResponseEntity.ok(produtosResponse);
    }

    @GetMapping(value = "/categoria/{categoria}")
    public @ResponseBody ResponseEntity<List<ProdutoResponse>> buscarProdutosPorCategoria(@PathVariable("categoria") String categoria) {
        var produtoRequest = produtoMapper.toProdutoRequest(Categoria.fromString(categoria));
        var produtosOut = buscaProdutoPorCategoriaInputPort.buscarPorCategoria(produtoRequest);
        var produtosResponse = produtoMapper.toProdutosResponse(produtosOut);

        return ResponseEntity.ok(produtosResponse);
    }

}
