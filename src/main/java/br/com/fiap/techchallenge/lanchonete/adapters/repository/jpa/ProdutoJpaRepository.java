package br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoJpaRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByCategoria(Categoria categoria);

}
