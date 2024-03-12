package br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.models.FilaProducaoDTO;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.producao.models.FilaProducaoRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static br.com.fiap.techchallenge.lanchonete.utils.PedidoHelper.getPedidoDTO;
import static org.assertj.core.api.Assertions.assertThat;

class FilaProducaoMapperTest {

    private FilaProducaoMapper filaProducaoMapper;

    @BeforeEach
    void setUp() {
        this.filaProducaoMapper = new FilaProducaoMapper();
    }

    @Test
    void toRequest() {
        var pedidoDTO = getPedidoDTO();

        FilaProducaoRequest filaProducaoRequest = filaProducaoMapper.toRequest(pedidoDTO);

        assertThat(filaProducaoRequest).isNotNull().isInstanceOf(FilaProducaoRequest.class);

        assertThat(filaProducaoRequest.codigo()).isEqualTo(pedidoDTO.id());
        assertThat(filaProducaoRequest.itens()).allSatisfy( item -> {
            assertThat(item.nome()).isEqualTo(pedidoDTO.itens().get(0).produtoNome());
            assertThat(item.descricao()).isEqualTo(pedidoDTO.itens().get(0).produtoDescricao());
            assertThat(item.quantidade()).isEqualTo(pedidoDTO.itens().get(0).quantidade());
        });

    }

    @Test
    void toFilaProducaoDTO() {

        var pedidoDTO = getPedidoDTO();

        FilaProducaoDTO filaProducaoDTO = filaProducaoMapper.toFilaProducaoDTO(pedidoDTO);

        assertThat(filaProducaoDTO).isNotNull().isInstanceOf(FilaProducaoDTO.class);

        assertThat(filaProducaoDTO.codigo()).isEqualTo(pedidoDTO.id());
        assertThat(filaProducaoDTO.itens()).allSatisfy( item -> {
            assertThat(item.nome()).isEqualTo(pedidoDTO.itens().get(0).produtoNome());
            assertThat(item.descricao()).isEqualTo(pedidoDTO.itens().get(0).produtoDescricao());
            assertThat(item.quantidade()).isEqualTo(pedidoDTO.itens().get(0).quantidade());
        });
    }
}