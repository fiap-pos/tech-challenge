package br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Cobranca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CobrancaJpaRepository extends JpaRepository<Cobranca, Long> {

    Optional<Cobranca> findFirstByPedidoIdOrderByCreatedAtDesc(Long pedidoId);

    boolean existsCobrancaByPedidoId(Long pedidoId);

}
