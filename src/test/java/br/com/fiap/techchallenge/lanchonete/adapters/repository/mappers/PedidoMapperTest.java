package br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ClienteJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static br.com.fiap.techchallenge.lanchonete.utils.PedidoHelper.getPedidoDTO;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PedidoMapperTest {

    private ItemPedidoMapper itemPedidoMapper;

    private ClienteJpaRepository clienteJpaRepository;

    private PedidoMapper pedidoMapper;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        this.pedidoMapper = new PedidoMapper(itemPedidoMapper, clienteJpaRepository);
    }

    @Test
    void toPedido() {
        var pedidoDTO = getPedidoDTO();

//        var pedido = pedidoMapper.toPedido(pedidoDTO);


        //  public Pedido toPedido(PedidoDTO pedidoIn)
    }

    @Test
    void toPedidoDTO() {
    }
}