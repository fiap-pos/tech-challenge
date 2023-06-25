package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.CobrancaJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper.CobrancaMapper;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.CobrancaBase;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.cobranca.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.port.out.cobranca.CriaCobrancaOutputPort;
import org.springframework.stereotype.Repository;

@Repository
public class CobrancaRepository implements CriaCobrancaOutputPort {

    private final CobrancaJpaRepository cobrancaJpaRepository;
    private final CobrancaMapper cobrancaMapper;

    public CobrancaRepository(CobrancaJpaRepository cobrancaJpaRepository, CobrancaMapper cobrancaMapper) {
        this.cobrancaJpaRepository = cobrancaJpaRepository;
        this.cobrancaMapper = cobrancaMapper;
    }
    @Override
    public CobrancaOut criar(CobrancaBase cobrancaBase) {
        var cobranca = cobrancaMapper.toCobranca(cobrancaBase);
        var cobrancaSalva = cobrancaJpaRepository.save(cobranca);
        return cobrancaMapper.toCobrancaOut(cobrancaSalva);
    }

}
