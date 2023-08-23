package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.entities.CriaItemPedido;
import br.com.fiap.techchallenge.lanchonete.core.entities.CriaPedido;
import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.CriaPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.BuscaProdutoPorIdOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.CriaPedidoOutputPort;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CriaPedidoUseCase implements CriaPedidoInputPort {


    private final CriaPedidoOutputPort criaPedidoOutputPort;
    private final BuscaProdutoPorIdOutputPort buscaProdutoPorIdOutputPort;

    public CriaPedidoUseCase(CriaPedidoOutputPort criaPedidoOutputPort,
                             BuscaProdutoPorIdOutputPort buscaProdutoPorIdOutputPort
    ) {
        this.criaPedidoOutputPort = criaPedidoOutputPort;
        this.buscaProdutoPorIdOutputPort = buscaProdutoPorIdOutputPort;
    }

    @Override
    public PedidoOut criar(PedidoIn pedidoIn) {
        var pedido = new CriaPedido();
        pedido.setCliente(pedidoIn.getClienteId());
        pedido.setItens(montaListaCriaItemPedido(pedidoIn));
        pedido.setStatus(StatusPedidoEnum.PENDENTE_DE_PAGAMENTO);
        pedido.setValorTotal(calculaValorTotalPedido(pedido.getItens()));
        pedido.setDataCriacao(LocalDateTime.now());
        return criaPedidoOutputPort.criar(pedido);
    }

    private List<CriaItemPedido> montaListaCriaItemPedido(PedidoIn pedidoIn){
        var listaCriaItemPedido = new ArrayList<CriaItemPedido>();
        pedidoIn.getItens().forEach(itemPedidoIn -> {
            var produtoOut = buscaProdutoPorIdOutputPort.buscarPorId(itemPedidoIn.getProdutoId());
            listaCriaItemPedido.add(
                    new CriaItemPedido(produtoOut.getId(), produtoOut.getPreco(), itemPedidoIn.getQuantidade())
            );
        });
        return listaCriaItemPedido;
    }

    private BigDecimal calculaValorTotalPedido(List<CriaItemPedido> listaCriaItemPedido){
        return listaCriaItemPedido.stream()
                .map(criaItemPedido ->
                        BigDecimal.valueOf(criaItemPedido.getQuantidade())
                        .multiply(criaItemPedido.getValorUnitario()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }
}
