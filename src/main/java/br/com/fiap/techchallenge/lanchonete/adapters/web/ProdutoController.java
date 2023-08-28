package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.mappers.ProdutoMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.ProdutoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.responses.ProdutoResponse;
import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaImagemProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.CategoriaEnum;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.produto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Tag(name = "Produto", description = "APIs para gerenciamento de Produto")
@RestController
@RequestMapping("/produtos")
public class ProdutoController extends ControllerBase {

    CriaProdutoInputPort criaProdutoInputPort;
    AtualizaImagemProdutoInputPort atualizaImagemProdutoInputPort;
    EditaProdutoInputPort editaProdutoInputPort;
    RemoveProdutoInputPort removeProdutoInputPort;
    BuscaProdutoPorIdInputPort buscaProdutoPorIdInputPort;
    BuscaTodosProdutosInputPort buscaTodosProdutosInputPort;
    BuscaProdutoPorCategoriaInputPort buscaProdutoPorCategoriaInputPort;
    ProdutoMapper produtoMapper;

    public ProdutoController(CriaProdutoInputPort criaProdutoInputPort, AtualizaImagemProdutoInputPort atualizaImagemProdutoInputPort,
                             EditaProdutoInputPort editaProdutoInputPort, RemoveProdutoInputPort removeProdutoInputPort,
                             BuscaProdutoPorIdInputPort buscaProdutoPorIdInputPort,
                             BuscaTodosProdutosInputPort buscaTodosProdutosInputPort,
                             BuscaProdutoPorCategoriaInputPort buscaProdutoPorCategoriaInputPort,
                             ProdutoMapper produtoMapper) {
        this.criaProdutoInputPort = criaProdutoInputPort;
        this.atualizaImagemProdutoInputPort = atualizaImagemProdutoInputPort;
        this.editaProdutoInputPort = editaProdutoInputPort;
        this.removeProdutoInputPort = removeProdutoInputPort;
        this.buscaProdutoPorIdInputPort = buscaProdutoPorIdInputPort;
        this.buscaTodosProdutosInputPort = buscaTodosProdutosInputPort;
        this.buscaProdutoPorCategoriaInputPort = buscaProdutoPorCategoriaInputPort;
        this.produtoMapper = produtoMapper;
    }

    @Operation(summary = "Cria um novo Produto")
    @PostMapping
    public ResponseEntity<ProdutoResponse> criar(@Valid @RequestBody ProdutoRequest produtoRequest) {
        var produtoOut = criaProdutoInputPort.criar(produtoRequest.toProdutoDTO());
        var produtoResponse = produtoMapper.toProdutoResponse(produtoOut);
        var uri = getExpandedCurrentUri("/{id}", produtoResponse.getId());

        return ResponseEntity.created(uri).body(produtoResponse);
    }

    @Operation(summary = "Atualiza a imagem de um Produto")
    @PatchMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> upload(@PathVariable("id") Long id, @RequestPart("imagem") MultipartFile image) {
        try {

            atualizaImagemProdutoInputPort.atualizar(new AtualizaImagemProdutoDTO(image.getBytes()), id);

            return ResponseEntity.noContent().build();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar a imagem: " + e.getMessage());
        }
    }

    @Operation(summary = "Edita um Produto por Id")
    @PutMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<ProdutoResponse> editar(@PathVariable("id") Long id, @RequestBody ProdutoRequest produtoRequest) {
        var produtoOut = editaProdutoInputPort.editar(produtoRequest.toProdutoDTO(), id);
        var produtoResponse = produtoMapper.toProdutoResponse(produtoOut);

        return ResponseEntity.ok(produtoResponse);
    }

    @Operation(summary = "Remove um Produto por Id")
    @DeleteMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<ProdutoResponse> remover(@PathVariable("id") Long id) {
        var produtoOut = removeProdutoInputPort.remover(id);
        var produtoResponse = produtoMapper.toProdutoResponse(produtoOut);

        return ResponseEntity.ok(produtoResponse);
    }

    @Operation(summary = "Busca um Produto por Id")
    @GetMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<ProdutoResponse> buscarPorId(@PathVariable("id") Long id) {
        var produtoOut = buscaProdutoPorIdInputPort.buscarPorId(id);
        var produtoResponse = produtoMapper.toProdutoResponse(produtoOut);

        return ResponseEntity.ok(produtoResponse);
    }

    @Operation(summary = "Busca todos os produtos")
    @GetMapping
    public @ResponseBody ResponseEntity<List<ProdutoResponse>> buscarTodos() {
        var produtos = buscaTodosProdutosInputPort.buscartodos().stream()
                .map(produtoMapper::toProdutoResponse)
                .toList();

        return ResponseEntity.ok(produtos);
    }

    @Operation(summary = "Busca um Produto por Categoria")
    @GetMapping(value = "/categoria/{categoria}")
    public @ResponseBody ResponseEntity<List<ProdutoResponse>> buscarProdutosPorCategoria(@PathVariable("categoria") String categoria) {
        var produtos = buscaProdutoPorCategoriaInputPort.buscarPorCategoria(CategoriaEnum.fromString(categoria)).stream()
                .map(produtoMapper::toProdutoResponse)
                .toList();

        return ResponseEntity.ok(produtos);
    }

}
