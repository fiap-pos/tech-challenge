package br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoJpaRepository extends JpaRepository<Produto, Long> {
}
