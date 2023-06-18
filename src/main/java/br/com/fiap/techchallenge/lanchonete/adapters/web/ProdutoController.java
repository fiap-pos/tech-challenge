package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.mapper.ImagemProdutoMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.web.mapper.ProdutoMapper;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaImagemProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.EditaProdutoInputPort;
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
    ProdutoMapper produtoMapper;
    ImagemProdutoMapper imagemProdutoMapper;

    public ProdutoController(CriaProdutoInputPort criaProdutoInputPort, CriaImagemProdutoInputPort criaImagemProdutoInputPort,
                             EditaProdutoInputPort editaProdutoInputPort, ProdutoMapper produtoMapper,
                             ImagemProdutoMapper imagemProdutoMapper) {
        this.criaProdutoInputPort = criaProdutoInputPort;
        this.criaImagemProdutoInputPort = criaImagemProdutoInputPort;
        this.editaProdutoInputPort = editaProdutoInputPort;
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

            return ResponseEntity.noContent().build();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar a imagem: " + e.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<ProdutoResponse> update(@PathVariable("id") Long id, @RequestBody ProdutoRequest produtoRequest) {
        var produtoRequestMapper = produtoMapper.toProdutoResponse(id, produtoRequest);
        var produtoOut = editaProdutoInputPort.editar(produtoRequestMapper);

//        representation.setIdentifier(id);
//        avariaService.update(AvariaRepresentation.build(representation));

        return ResponseEntity.noContent().build();

    }

}
