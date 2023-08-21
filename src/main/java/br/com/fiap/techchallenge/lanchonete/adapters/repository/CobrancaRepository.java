package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.CobrancaJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper.CobrancaMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Cobranca;
import br.com.fiap.techchallenge.lanchonete.core.domain.exception.EntityNotFoundException;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.CobrancaBase;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CobrancaOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CobrancaStatusIn;
import br.com.fiap.techchallenge.lanchonete.core.port.out.AtualizaStatusCobrancaOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaCobrancaOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.CriaCobrancaOutputPort;
import org.springframework.stereotype.Repository;

@Repository
public class CobrancaRepository implements CriaCobrancaOutputPort, BuscaCobrancaOutputPort, AtualizaStatusCobrancaOutputPort {

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

    @Override
    public CobrancaOut buscarPorId(Long id) {
        var cobranca = buscaCobrancaPorId(id);
        return cobrancaMapper.toCobrancaOut(cobranca);
    }

    @Override
    public CobrancaOut buscarPorPedidoId(Long pedidoId) {
        var cobranca = cobrancaJpaRepository.findFirstByPedidoIdOrderByCreatedAtDesc(pedidoId)
                                            .orElseThrow(() -> new EntityNotFoundException("Cobrança com o pedidoId " + pedidoId + " não existe"));
        return cobrancaMapper.toCobrancaOut(cobranca);
    }

    @Override
    public boolean pedidoPossuiCobranca(Long pedidoId) {
        return cobrancaJpaRepository.existsCobrancaByPedidoId(pedidoId);
    }


    @Override
    public CobrancaOut atualizarStatus(Long id, CobrancaStatusIn cobrancaStatusIn) {
        var cobranca = buscaCobrancaPorId(id);
        cobranca.setStatus(cobrancaStatusIn.getStatus());
        var cobrancaSalva = cobrancaJpaRepository.save(cobranca);
        return cobrancaMapper.toCobrancaOut(cobrancaSalva);
    }

    private Cobranca buscaCobrancaPorId(Long id) {
        return cobrancaJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cobrança com o id " + id + " não existe"));
    }
}
