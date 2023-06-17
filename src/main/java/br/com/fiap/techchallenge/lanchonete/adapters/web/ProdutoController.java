package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.mapper.ImagemProdutoMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.web.mapper.ProdutoMapper;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaImagemProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaProdutoInputPort;
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
    ProdutoMapper produtoMapper;
    ImagemProdutoMapper imagemProdutoMapper;

    public ProdutoController(CriaProdutoInputPort criaProdutoInputPort, CriaImagemProdutoInputPort criaImagemProdutoInputPort,
                             ProdutoMapper produtoMapper, ImagemProdutoMapper imagemProdutoMapper) {
        this.criaProdutoInputPort = criaProdutoInputPort;
        this.criaImagemProdutoInputPort = criaImagemProdutoInputPort;
        this.produtoMapper = produtoMapper;
        this.imagemProdutoMapper = imagemProdutoMapper;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> salvar(@Valid @RequestBody ProdutoRequest produtoRequest) {
        var produtoOut = criaProdutoInputPort.criar(produtoRequest);
        var produtoResponse = produtoMapper.toProdutoResponse(produtoOut);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produtoResponse.getId())
                .toUri();

        return ResponseEntity.created(uri).body(produtoResponse);
    }

    @PatchMapping(value = "/{id}/imagem", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> upload(@PathVariable("id") Long id, @RequestPart("imagem") MultipartFile image) {
        try {
            var imagemProdutoRequest = imagemProdutoMapper.toProdutoResponse(id, image.getBytes());
            criaImagemProdutoInputPort.criar(imagemProdutoRequest);

            return ResponseEntity.ok().build();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar a imagem: " + e.getMessage());
        }
    }

}
