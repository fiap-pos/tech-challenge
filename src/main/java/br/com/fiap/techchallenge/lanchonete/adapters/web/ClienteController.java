package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.mapper.ClienteMapperWeb;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.ClienteRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.ClienteResponse;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.AtualizaClienteInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaClientePorCpfInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaTodosClientesInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CadastraClienteInputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clientes", description = "APIs para gerenciamento de Clientes")
@RestController
@RequestMapping("/clientes")
public class ClienteController extends ControllerBase {


    private final AtualizaClienteInputPort atualizaClienteInputPort;
    private final BuscaClientePorCpfInputPort buscaClientePorCpfInputPort;

    private final BuscaTodosClientesInputPort buscaTodosClientesInputPort;
    private final CadastraClienteInputPort cadastraClienteInputPort;
    private final ClienteMapperWeb mapperWeb;

    public ClienteController(AtualizaClienteInputPort atualizaClienteInputPort,
                             BuscaClientePorCpfInputPort buscaClientePorCpfInputPort,
                             BuscaTodosClientesInputPort buscaTodosClientesInputPort,
                             CadastraClienteInputPort cadastraClienteInputPort,
                             ClienteMapperWeb mapperWeb
    ) {
        this.atualizaClienteInputPort = atualizaClienteInputPort;
        this.buscaClientePorCpfInputPort = buscaClientePorCpfInputPort;
        this.buscaTodosClientesInputPort = buscaTodosClientesInputPort;
        this.cadastraClienteInputPort = cadastraClienteInputPort;
        this.mapperWeb = mapperWeb;
    }

    @Operation(summary = "Busca um Cliente pelo CPF")
    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteResponse> buscaPorCpf(@PathVariable String cpf) {
        ClienteResponse clienteResponse = mapperWeb.toClienteResponse(
                buscaClientePorCpfInputPort.buscar(cpf)
        );

        return ResponseEntity.ok(clienteResponse);
    }

    @Operation(summary = "Busca todos os Clientes")
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> buscaTodos() {
        List<ClienteOut> listaClientes = buscaTodosClientesInputPort.buscarTodos();
        List<ClienteResponse> clienteResponseList = mapperWeb.toClientesResponse(listaClientes);

        return ResponseEntity.ok(clienteResponseList);
    }

    @Operation(summary = "Cadastra um novo Cliente")
    @PostMapping
    public ResponseEntity<ClienteResponse> cadastra(@Valid @RequestBody ClienteRequest clienteRequest) {
        ClienteOut clienteOut = cadastraClienteInputPort.cadastrar(clienteRequest);
        ClienteResponse clienteResponse = mapperWeb.toClienteResponse(clienteOut);

        var uri = getExpandedCurrentUri("/{id}", clienteResponse.getId());

        return ResponseEntity
                .created(uri)
                .body(clienteResponse);
    }

    @Operation(summary = "Atualiza Cliente pelo id")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> atualiza(@RequestBody ClienteRequest clienteRequest, @PathVariable Long id) {
        ClienteOut clienteAtualizado = atualizaClienteInputPort.atualizar(clienteRequest, id);

        return ResponseEntity.ok(mapperWeb.toClienteResponse(clienteAtualizado));
    }
}
