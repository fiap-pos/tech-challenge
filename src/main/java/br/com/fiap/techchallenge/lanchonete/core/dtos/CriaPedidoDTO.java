package br.com.fiap.techchallenge.lanchonete.core.dtos;

import java.util.List;

public record CriaPedidoDTO(
    List<CriaItemPedidoDTO> itens
)  {
}
