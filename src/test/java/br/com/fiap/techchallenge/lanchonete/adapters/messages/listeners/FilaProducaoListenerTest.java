package br.com.fiap.techchallenge.lanchonete.adapters.messages.listeners;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.AtualizaStatusPedidoInputPort;
import br.com.fiap.techchallenge.producao.core.dtos.ItemPedidoDTO;
import br.com.fiap.techchallenge.producao.core.dtos.PedidoDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;

import static br.com.fiap.techchallenge.lanchonete.utils.PedidoHelper.getPedidoDTO;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class FilaProducaoListenerTest {

    private FilaProducaoListener filaProducaoListener;

    @Mock
    AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort;

    AutoCloseable openMocks;

    @BeforeEach
    void setup() {
        openMocks = MockitoAnnotations.openMocks(this);
        filaProducaoListener = new FilaProducaoListener(atualizaStatusPedidoInputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void listenTest() {
        var nome = "nome";
        var descricao = "descricao";
        var quantidade = 1;
        var item = new ItemPedidoDTO(nome, descricao, quantidade);
        var itens = List.of(item);
        var codigo = 1L;
        var status = StatusPedidoEnum.RECEBIDO;
        var dataCriacao = LocalDateTime.now();
        var pedidoDTO = new PedidoDTO(codigo, itens, status, dataCriacao);

        var pedidoDTORetorno = getPedidoDTO();

        when(atualizaStatusPedidoInputPort.atualizarStatus(
                pedidoDTO.codigo(),
                pedidoDTO.status())).thenReturn(pedidoDTORetorno);

        filaProducaoListener.listen(pedidoDTO);

        verify(atualizaStatusPedidoInputPort, times(1))
                .atualizarStatus(pedidoDTO.codigo(), pedidoDTO.status());
    }


}