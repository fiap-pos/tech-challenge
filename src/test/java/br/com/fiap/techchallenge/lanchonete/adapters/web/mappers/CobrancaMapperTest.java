package br.com.fiap.techchallenge.lanchonete.adapters.web.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static br.com.fiap.techchallenge.lanchonete.utils.CobrancaHelper.getCobrancaDTO;
import static org.assertj.core.api.Assertions.assertThat;

class CobrancaMapperTest {

    private CobrancaMapper cobrancaMapper;

    @BeforeEach
    void setup() {
        this.cobrancaMapper = new CobrancaMapper();
    }

    @Test
    void dadoCobrancaDTO_DeveFazerMapper_RetornarCobrancaResponse() {
        // Arrange
        var cobrancaDTO = getCobrancaDTO();

        // Act
        var cobrancaResponse = cobrancaMapper.toCobrancaResponse(cobrancaDTO);

        // Assert
        assertThat(cobrancaResponse).isNotNull();
        assertThat(cobrancaResponse.getId()).isEqualTo(cobrancaDTO.id());
        assertThat(cobrancaResponse.getPedidoId()).isEqualTo(cobrancaDTO.pedidoId());
        assertThat(cobrancaResponse.getStatus()).isEqualTo(cobrancaDTO.status());
        assertThat(cobrancaResponse.getValor()).isEqualTo(cobrancaDTO.valor());
        assertThat(cobrancaResponse.getQrCode()).isEqualTo(cobrancaDTO.qrCode());
    }
}