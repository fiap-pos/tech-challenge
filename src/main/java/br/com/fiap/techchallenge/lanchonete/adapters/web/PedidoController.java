package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.mappers.CobrancaMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.web.mappers.PedidoMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.*;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cobranca.BuscaCobrancaPorPedidoIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.*;
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
    private final BuscaTodosPedidosPorStatusInputPort buscaTodosPedidosPorStatusInputPort;
    private final BuscaCobrancaPorPedidoIdInputPort buscaCobrancaPorPedidoIdInputPort;
    private final PedidoMapper pedidoMapper;
    private final CobrancaMapper cobrancaMapper;

    public PedidoController(CriaPedidoInputPort criaPedidoInputPort,
                            AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort,
                            BuscaTodosPedidosInputPort buscaTodosPedidosInputPort,
                            BuscarPedidoPorIdInputPort buscarPedidoPorIdInputPort,
                            BuscaTodosPedidosPorStatusInputPort buscaTodosPedidosPorStatusInputPort,
                            BuscaCobrancaPorPedidoIdInputPort buscaCobrancaPorPedidoIdInputPort,
                            PedidoMapper pedidoMapper,
                            CobrancaMapper cobrancaMapper
    ) {
        this.criaPedidoInputPort = criaPedidoInputPort;
        this.atualizaStatusPedidoInputPort = atualizaStatusPedidoInputPort;
        this.buscaTodosPedidosInputPort = buscaTodosPedidosInputPort;
        this.buscarPedidoPorIdInputPort = buscarPedidoPorIdInputPort;
        this.buscaTodosPedidosPorStatusInputPort = buscaTodosPedidosPorStatusInputPort;
        this.buscaCobrancaPorPedidoIdInputPort = buscaCobrancaPorPedidoIdInputPort;
        this.pedidoMapper = pedidoMapper;
        this.cobrancaMapper = cobrancaMapper;
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
        var pedidoOut = criaPedidoInputPort.criar(pedidoRequest.toCriaItemPedidoDTO());
        var pedidoResponse = pedidoMapper.toPedidoResponse(pedidoOut);
        var uri = getExpandedCurrentUri("/{id}", pedidoResponse.getId());
        return ResponseEntity.created(uri).body(pedidoResponse);
    }

    @Operation(summary = "Atualiza status de um  pedido")
    @PatchMapping("/{id}/status")
    public ResponseEntity<PedidoResponse> atualizaStatus(@PathVariable("id") Long id,
                                                         @RequestBody AtualizaStatusPedidoRequest pedidoRequest){
        var pedidoOut = atualizaStatusPedidoInputPort.atualizarStatus(id, pedidoRequest.toAtualizaStatusPedidoDTO());
        var pedidoResponse = pedidoMapper.toPedidoResponse(pedidoOut);
        var uri = getExpandedCurrentUri("/{id}", pedidoResponse.getId());
        return ResponseEntity.created(uri).body(pedidoResponse);
    }

    @Operation(summary = "Busca todos os pedidos por status")
    @GetMapping(value = "/status/{status}")
    public ResponseEntity<List<PedidoResponse>> buscarTodos(@PathVariable("status") String status){
        var pedidosOut = buscaTodosPedidosPorStatusInputPort.buscarTodosStatus(StatusPedidoEnum.fromString(status))
                .stream()
                .map(pedidoMapper::toPedidoResponse)
                .toList();
        return ResponseEntity.ok(pedidosOut);
    }

    @Operation(summary = "Busca cobrança pelo id do pedido")
    @GetMapping(value = "/{id}/cobranca")
    ResponseEntity<CobrancaResponse> buscarCobrancaPorPedidoId(
            @PathVariable("id") Long id
    ) {
        var cobrancaOut = buscaCobrancaPorPedidoIdInputPort.buscarPorPedidoId(id);
        var cobrancaResponse = cobrancaMapper.toCobrancaResponse(cobrancaOut);
        return ResponseEntity.ok().body(cobrancaResponse);
    }

}
