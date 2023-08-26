package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.mappers.CobrancaMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.AtualizaStatusCobrancaRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.CobrancaRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.CobrancaResponse;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cobranca.AtualizaStatusCobrancaInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cobranca.BuscaCobrancaPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cobranca.CriaCobrancaInputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Cobranca", description = "APIs para geração e confirmação de pagamento de cobranças")
@RestController
@RequestMapping("/cobrancas")
public class CobrancaController extends ControllerBase {
    private final CriaCobrancaInputPort criaCobrancaInputPort;
    private final BuscaCobrancaPorIdInputPort buscaCobrancaPorIdInputPort;
    private final AtualizaStatusCobrancaInputPort atualizaStatusCobrancaInputPort;
    private final CobrancaMapper cobrancaMapper;

    public CobrancaController(
        CriaCobrancaInputPort criaCobrancaInputPort,
        BuscaCobrancaPorIdInputPort buscaCobrancaPorIdInputPort,
        AtualizaStatusCobrancaInputPort atualizaStatusCobrancaInputPort,
        CobrancaMapper cobrancaMapper
    ) {
        this.criaCobrancaInputPort = criaCobrancaInputPort;
        this.buscaCobrancaPorIdInputPort = buscaCobrancaPorIdInputPort;
        this.atualizaStatusCobrancaInputPort = atualizaStatusCobrancaInputPort;
        this.cobrancaMapper = cobrancaMapper;
    }

    @Operation(summary = "Cria uma nova Cobrança")
    @PostMapping
    ResponseEntity<CobrancaResponse> criar(@Valid @RequestBody CobrancaRequest cobrancaRequest) {
        var cobrancaOut = criaCobrancaInputPort.criar(cobrancaRequest.toCriaCobrancaDTO());
        var cobrancaResponse = cobrancaMapper.toCobrancaResponse(cobrancaOut);
        var uri = getExpandedCurrentUri("/{id}", cobrancaResponse.getId());

        return ResponseEntity.created(uri).body(cobrancaResponse);
    }

    @Operation(summary = "Busca uma Cobrança por id")
    @GetMapping(value = "/{id}")
    ResponseEntity<CobrancaResponse> get(@PathVariable("id") Long id) {
        var cobrancaOut = buscaCobrancaPorIdInputPort.buscarPorId(id);
        var cobrancaResponse = cobrancaMapper.toCobrancaResponse(cobrancaOut);
        return ResponseEntity.ok().body(cobrancaResponse);
    }

    @Operation(summary = "Atualiza o status de uma cobrança para Pago ou Cancelado")
    @PostMapping(value = "/{id}/status")
    ResponseEntity<CobrancaResponse> updateStatus(
            @PathVariable("id") Long id,
            @Valid @RequestBody AtualizaStatusCobrancaRequest atualizaStatusCobrancaRequest
    ) {
        var cobrancaOut = atualizaStatusCobrancaInputPort.atualizarStatus(id, atualizaStatusCobrancaRequest.toAtualizaStatusCobrancaDTO());
        var cobrancaResponse = cobrancaMapper.toCobrancaResponse(cobrancaOut);
        return ResponseEntity.ok().body(cobrancaResponse);
    }
}
