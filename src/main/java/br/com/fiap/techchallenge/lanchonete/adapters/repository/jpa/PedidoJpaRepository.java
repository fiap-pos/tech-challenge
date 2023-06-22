package br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Pedido;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PedidoJpaRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatus(StatusPedidoEnum statusPedido);
    List<Pedido> findAllByClienteid(Long clienteid);
}
