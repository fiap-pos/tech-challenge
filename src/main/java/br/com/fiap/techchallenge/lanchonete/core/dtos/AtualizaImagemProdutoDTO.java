package br.com.fiap.techchallenge.lanchonete.core.dtos;

import java.util.Arrays;

public record AtualizaImagemProdutoDTO(byte[] imagem) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtualizaImagemProdutoDTO that = (AtualizaImagemProdutoDTO) o;
        return Arrays.equals(imagem, that.imagem);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(imagem);
    }

    @Override
    public String toString() {
        return "AtualizaImagemProdutoDTO{" +
                "imagem=" + Arrays.toString(imagem) +
                '}';
    }
}
