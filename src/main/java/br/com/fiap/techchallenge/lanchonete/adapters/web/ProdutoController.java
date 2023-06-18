package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.mapper.ProdutoMapper;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaImagemProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.EditaProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.RemoveProdutoInputPort;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    CriaProdutoInputPort criaProdutoInputPort;
    CriaImagemProdutoInputPort criaImagemProdutoInputPort;
    EditaProdutoInputPort editaProdutoInputPort;
    RemoveProdutoInputPort removeProdutoInputPort;
    ProdutoMapper produtoMapper;

    public ProdutoController(CriaProdutoInputPort criaProdutoInputPort, CriaImagemProdutoInputPort criaImagemProdutoInputPort,
                             EditaProdutoInputPort editaProdutoInputPort, RemoveProdutoInputPort removeProdutoInputPort,
                             ProdutoMapper produtoMapper) {
        this.criaProdutoInputPort = criaProdutoInputPort;
        this.criaImagemProdutoInputPort = criaImagemProdutoInputPort;
        this.editaProdutoInputPort = editaProdutoInputPort;
        this.removeProdutoInputPort = removeProdutoInputPort;
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

}
