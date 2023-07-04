package br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Pedido;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PedidoJpaRepository extends JpaRepository<Pedido, Long> {
}
