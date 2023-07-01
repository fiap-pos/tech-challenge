package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.mapper.PedidoMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.AtualizaStatusPedidoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.PedidoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.PedidoResponse;
import br.com.fiap.techchallenge.lanchonete.core.port.in.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pedido", description = "APIs para gerenciamento de Pedido")
@RestController
@RequestMapping("/pedidos")
public class PedidoController extends ControllerBase{
    private final CriaPedidoInputPort criaPedidoInputPort;
    private final AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort;
    private final BuscaTodosPedidosInputPort buscaTodosPedidosInputPort;
    private final BuscarPedidoPorIdInputPort buscarPedidoPorIdInputPort;
    private final PedidoMapper pedidoMapper;

    public PedidoController(CriaPedidoInputPort criaPedidoInputPort,
                            AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort,
                            BuscaTodosPedidosInputPort buscaTodosPedidosInputPort,
                            BuscarPedidoPorIdInputPort buscarPedidoPorIdInputPort,
                            PedidoMapper pedidoMapper) {
        this.criaPedidoInputPort = criaPedidoInputPort;
        this.atualizaStatusPedidoInputPort = atualizaStatusPedidoInputPort;
        this.buscaTodosPedidosInputPort = buscaTodosPedidosInputPort;
        this.buscarPedidoPorIdInputPort = buscarPedidoPorIdInputPort;
        this.pedidoMapper = pedidoMapper;
    }

    @Operation(summary = "Busca todos os pedidos")
    @GetMapping
    public ResponseEntity<List<PedidoResponse>> buscarTodos(){
        var pedidosOut = buscaTodosPedidosInputPort.buscarTodos();
        var listPedidoResponse = pedidoMapper.toPedidoListResponse(pedidosOut);
        return ResponseEntity.ok(listPedidoResponse);
    }
    @Operation(summary = "Busca pedido pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscarPorId(@PathVariable("id") Long id){
        var pedidoOut = buscarPedidoPorIdInputPort.buscarPorId(id);
        var pedidoResponse = pedidoMapper.toPedidoResponse(pedidoOut);
        return ResponseEntity.ok(pedidoResponse);
    }

    @Operation(summary = "Cria um pedido")
    @PostMapping
    public ResponseEntity<PedidoResponse> criarPedido(@Valid @RequestBody PedidoRequest pedidoRequest){
        var pedidoOut = criaPedidoInputPort.criar(pedidoRequest);
        var pedidoResponse = pedidoMapper.toPedidoResponse(pedidoOut);
        var uri = getExpandedCurrentUri("/{id}", pedidoResponse.getId());
        return ResponseEntity.created(uri).body(pedidoResponse);
    }
    @Operation(summary = "Atualiza status de um  pedido")
    @PostMapping("/{id}/status")
    public ResponseEntity<PedidoResponse> atualizaStatus(@PathVariable("id") Long id,
                                                         @RequestBody AtualizaStatusPedidoRequest pedidoRequest){
        var pedidoOut = atualizaStatusPedidoInputPort.atualizarStatus(id, pedidoRequest);
        var pedidoResponse = pedidoMapper.toPedidoResponse(pedidoOut);
        var uri = getExpandedCurrentUri("/{id}", pedidoResponse.getId());
        return ResponseEntity.created(uri).body(pedidoResponse);
    }
    /*@Operation(summary = "Edita um  pedido")
    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponse> editar(@PathVariable("id") Long id,
                                                 @RequestBody PedidoRequest pedidoRequest){
        var pedidoMapperRequest = pedidoMapper.toPedidoRequest(id, pedidoRequest);
        var pedidoOut = editarPedidoInputPort.editar(pedidoMapperRequest);
        var pedidoResponse = pedidoMapper.toPedidoResponse(pedidoOut);
        var uri = getExpandedCurrentUri("/{id}", pedidoResponse.getId());
        return ResponseEntity.created(uri).body(pedidoResponse);
    }
    @Operation(summary = "Remove um  pedido")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable("id") Long id){
        removerPedidoInputPort.remover(id);
        var uri = getExpandedCurrentUri("/{id}", id);
        return ResponseEntity.noContent().build();
    }*/
}
