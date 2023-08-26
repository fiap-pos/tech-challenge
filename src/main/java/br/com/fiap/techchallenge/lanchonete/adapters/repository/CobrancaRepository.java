package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.CobrancaJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers.CobrancaMapper;
import br.com.fiap.techchallenge.lanchonete.core.domain.exceptions.EntityNotFoundException;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.Cobranca;
import br.com.fiap.techchallenge.lanchonete.core.dtos.CobrancaDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaStatusCobrancaDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cobranca.AtualizaStatusCobrancaOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cobranca.BuscaCobrancaOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cobranca.CriaCobrancaOutputPort;
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
    public CobrancaDTO criar(CobrancaDTO cobrancaDTO) {
        var cobranca = cobrancaMapper.toCobranca(cobrancaDTO);
        var cobrancaSalva = cobrancaJpaRepository.save(cobranca);
        return cobrancaMapper.toCobrancaOut(cobrancaSalva);
    }

    @Override
    public CobrancaDTO buscarPorId(Long id) {
        var cobranca = buscaCobrancaPorId(id);
        return cobrancaMapper.toCobrancaOut(cobranca);
    }

    @Override
    public CobrancaDTO buscarPorPedidoId(Long pedidoId) {
        var cobranca = cobrancaJpaRepository.findFirstByPedidoIdOrderByCreatedAtDesc(pedidoId)
                                            .orElseThrow(() -> new EntityNotFoundException("Cobrança com o pedidoId " + pedidoId + " não existe"));
        return cobrancaMapper.toCobrancaOut(cobranca);
    }

    @Override
    public boolean pedidoPossuiCobranca(Long pedidoId) {
        return cobrancaJpaRepository.existsCobrancaByPedidoId(pedidoId);
    }


    @Override
    public CobrancaDTO atualizarStatus(Long id, AtualizaStatusCobrancaDTO cobrancaStatusIn) {
        var cobranca = buscaCobrancaPorId(id);
        cobranca.setStatus(cobrancaStatusIn.status());
        var cobrancaSalva = cobrancaJpaRepository.save(cobranca);
        return cobrancaMapper.toCobrancaOut(cobrancaSalva);
    }

    private br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Cobranca buscaCobrancaPorId(Long id) {
        return cobrancaJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cobrança com o id " + id + " não existe"));
    }
}
