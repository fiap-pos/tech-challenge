package br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.models.FilaProducaoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.models.FilaProducaoItem;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import org.springframework.stereotype.Component;

@Component
public class FilaProducaoMapper {

    public FilaProducaoRequest toRequest(PedidoDTO pedidoDTO) {
        return new FilaProducaoRequest(
                pedidoDTO.id(),
                pedidoDTO.getNomeCliente(),
                pedidoDTO.itens().stream().map(
                    item -> new FilaProducaoItem(
                        item.produtoNome(),
                        item.produtoDescricao(),
                        item.quantidade()
                )).toList()
        );
    }
}
