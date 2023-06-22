package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.mapper.PedidoMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.PedidoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.PedidoResponse;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.AtualizaStatusPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaPedidoPorClienteIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaTodosPedidosInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaTodosPedidosOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.CriaPedidoOutputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
@Tag(name = "Pedido", description = "APIs para gerenciamento de Pedido")
@RestController
@RequestMapping("/pedido")
public class PedidoController {
    private final CriaPedidoInputPort criaPedidoInputPort;
    private final BuscaTodosPedidosInputPort buscaTodosPedidosInputPort;
    private final BuscaPedidoPorClienteIdInputPort buscaPedidoPorClienteIdInputPort;
    private final PedidoMapper pedidoMapper;

    public PedidoController( CriaPedidoInputPort criaPedidoInputPort,
                             BuscaTodosPedidosInputPort buscaTodosPedidosInputPort,
                             BuscaPedidoPorClienteIdInputPort buscaPedidoPorClienteIdInputPort,
                             AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort,
                             PedidoMapper pedidoMapper) {
        this.criaPedidoInputPort = criaPedidoInputPort;
        this.buscaTodosPedidosInputPort = buscaTodosPedidosInputPort;
        this.buscaPedidoPorClienteIdInputPort = buscaPedidoPorClienteIdInputPort;
        this.pedidoMapper = pedidoMapper;
    }
    @Operation(summary = "Busca todos os pedidos")
    @GetMapping
    public ResponseEntity<List<PedidoResponse>> buscarTodos(){
        List<PedidoOut> pedidosOut = buscaTodosPedidosInputPort.buscarTodos();
        List<PedidoResponse> listPedidoResponse = pedidoMapper.toPedidoListResponse(pedidosOut);

        return ResponseEntity.status(OK)
                .body(listPedidoResponse);
    }
    @Operation(summary = "Busca todos os pedidos de um cliente")
    @GetMapping("/cliente/{clienteid}")
    public ResponseEntity<List<PedidoResponse>> buscarPedidoDoCliente(@PathVariable("clienteid") Long clienteid){
        var pedidos = buscaPedidoPorClienteIdInputPort.buscaPedidosDoCliente(clienteid);
        return ResponseEntity.status(OK)
                .body(pedidoMapper.toPedidoListResponse(pedidos));
    }
    @Operation(summary = "Cria um pedido")
    @PostMapping
    public ResponseEntity<PedidoResponse> criarPedido(@Valid @RequestBody PedidoRequest pedidoRequest){
        pedidoRequest.setStatus(StatusPedidoEnum.PENDENTE_DE_PAGAMENTO);
        PedidoOut pedidoOut = criaPedidoInputPort.criar(pedidoRequest);
        PedidoResponse pedidoResponse = pedidoMapper.toPedidoResponse(pedidoOut);
        return ResponseEntity.status(CREATED)
                .body(pedidoResponse);
    }

    @Operation(summary="Atualiza o status do pedido")
    @PutMapping("/cliente/{clienteid}/{status}")
    public ResponseEntity<List<PedidoResponse>> atualizaStatusPedido(@PathVariable("clienteid")Long clienteid,
                                                                     @PathVariable("status") StatusPedidoEnum status){
        List<PedidoOut> pedidos = buscaPedidoPorClienteIdInputPort.buscaPedidosDoCliente(clienteid);
        pedidos.forEach(pedidoOut -> pedidoOut.setStatus(status));
        List<PedidoResponse> listPedidoResponse = pedidoMapper.toPedidoListResponse(pedidos);
        return ResponseEntity.status(OK)
                .body(listPedidoResponse);
    }
}
