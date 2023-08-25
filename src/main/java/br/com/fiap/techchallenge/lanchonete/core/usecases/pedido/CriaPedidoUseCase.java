package br.com.fiap.techchallenge.lanchonete.core.usecases.pedido;

import br.com.fiap.techchallenge.lanchonete.core.dtos.*;
import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.CriaPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.produto.BuscaProdutoPorIdOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.CriaPedidoOutputPort;

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
    public PedidoDTO criar(CriaPedidoDTO pedidoIn) {

        var cliente = getCliente(pedidoIn);
        var itensPedido = montaListaCriaItemPedido(pedidoIn);
        var valorTotal = calculaValorTotalPedido(itensPedido);


        var pedido = new PedidoDTO(
                null,
                cliente,
                itensPedido,
                StatusPedidoEnum.PENDENTE_DE_PAGAMENTO,
                valorTotal,
                LocalDateTime.now()
        );

        return criaPedidoOutputPort.criar(pedido);
    }

    private ClienteDTO getCliente(CriaPedidoDTO pedidoIn) {
        if (pedidoIn.clientId() != null) {
            return new ClienteDTO(pedidoIn.clientId());
        }
        return null;
    }

    private List<ItemPedidoDTO> montaListaCriaItemPedido(CriaPedidoDTO pedidoIn){
        var listaCriaItemPedido = new ArrayList<ItemPedidoDTO>();
        pedidoIn.itens().forEach(itemPedidoIn -> {
            var produtoOut = buscaProdutoPorIdOutputPort.buscarPorId(itemPedidoIn.produtoId());
            listaCriaItemPedido.add(
                    new ItemPedidoDTO(produtoOut.id(), produtoOut.nome(), produtoOut.preco(), itemPedidoIn.quantidade())
            );
        });
        return listaCriaItemPedido;
    }

    private BigDecimal calculaValorTotalPedido(List<ItemPedidoDTO> listaItemPedido){
        return listaItemPedido.stream()
                .map(criaItemPedido ->
                        BigDecimal.valueOf(criaItemPedido.quantidade())
                        .multiply(criaItemPedido.valorUnitario()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }
}
