package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.mapper.CobrancaMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.CobrancaRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.CobrancaResponse;
import br.com.fiap.techchallenge.lanchonete.core.port.in.cobranca.CriaCobrancaInputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cobranca", description = "APIs para geração e confirmacção de pagamento de cobranças")
@RestController
@RequestMapping("/cobranca")
public class CobrancaController extends ControllerBase{
    private final CriaCobrancaInputPort criaCobrancaInputPort;
    private final CobrancaMapper cobrancaMapper;

    public CobrancaController(
        CriaCobrancaInputPort criaCobrancaInputPort,
        CobrancaMapper cobrancaMapper
    ) {
        this.criaCobrancaInputPort = criaCobrancaInputPort;
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
}
