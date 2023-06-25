package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.mapper.CobrancaMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.CobrancaRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.CobrancaResponse;
import br.com.fiap.techchallenge.lanchonete.core.port.in.cobranca.BuscaCobrancaPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.cobranca.CriaCobrancaInputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Cobranca", description = "APIs para geração e confirmação de pagamento de cobranças")
@RestController
@RequestMapping("/cobranca")
public class CobrancaController extends ControllerBase{
    private final CriaCobrancaInputPort criaCobrancaInputPort;
    private final BuscaCobrancaPorIdInputPort buscaCobrancaPorIdInputPort;
    private final CobrancaMapper cobrancaMapper;

    public CobrancaController(
        CriaCobrancaInputPort criaCobrancaInputPort,
        BuscaCobrancaPorIdInputPort buscaCobrancaPorIdInputPort,
        CobrancaMapper cobrancaMapper
    ) {
        this.criaCobrancaInputPort = criaCobrancaInputPort;
        this.buscaCobrancaPorIdInputPort = buscaCobrancaPorIdInputPort;
        this.cobrancaMapper = cobrancaMapper;
    }

    @Operation(summary = "Cria uma nova Cobrança")
    @PostMapping
    ResponseEntity<CobrancaResponse> criar(@Valid @RequestBody CobrancaRequest cobrancaRequest) {
        var cobrancaOut = criaCobrancaInputPort.criar(cobrancaRequest);
        var cobrancaResponse = cobrancaMapper.toCobrancaResponse(cobrancaOut);
        var uri = getExpandedCurrentUri("/{id}", cobrancaResponse.getId());

        return ResponseEntity.created(uri).body(cobrancaResponse);
    }

    @Operation(summary = "Busca uma Cobrança por id")
    @GetMapping(value = "/{id}")
    ResponseEntity<CobrancaResponse> get(@PathVariable("id") Long id) {
        var cobrancaOut = buscaCobrancaPorIdInputPort.buscaPorId(id);
        var cobrancaResponse = cobrancaMapper.toCobrancaResponse(cobrancaOut);
        return ResponseEntity.ok().body(cobrancaResponse);
    }

    @Operation(summary = "Atualiza o status de uma cobrança para Pago ou Cancelado")
    @PostMapping(value = "/{id}/status")
    ResponseEntity<CobrancaResponse> updateStatus(@PathVariable("id") Long id) {
        return null;
    }


}
