package br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.models.FilaProducaoDTO;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.models.FilaProducaoItemDTO;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.models.FilaProducaoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.models.FilaProducaoItem;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoDTO;
import org.springframework.stereotype.Component;

@Component
public class FilaProducaoMapper {

    public FilaProducaoRequest toRequest(PedidoDTO pedidoDTO) {
        return new FilaProducaoRequest(
                pedidoDTO.id(),
                pedidoDTO.itens().stream().map(
                    item -> new FilaProducaoItem(
                        item.produtoNome(),
                        item.produtoDescricao(),
                        item.quantidade()
                )).toList()
        );
    }

    public FilaProducaoDTO toFilaProducaoDTO(PedidoDTO pedidoDTO) {
        return new FilaProducaoDTO(
                pedidoDTO.id(),
                pedidoDTO.itens().stream().map(
                        item -> new FilaProducaoItemDTO(
                                item.produtoNome(),
                                item.produtoDescricao(),
                                item.quantidade()
                        )).toList()
        );
    }
}
